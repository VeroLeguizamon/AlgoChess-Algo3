package vista;

import controladores.ColocarUnidadTableroEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import tp2java.modelo.Observer;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Unidad;

public class VistaCelda extends Button implements Observer{
	private VistaUnidad vista;
	private int x;
	private int y;
	private Tablero tablero;
	private ContenedorConTablero escena;
	public VistaCelda(int x, int y, double anchoCelda, double altoCelda, Tablero tablero, ContenedorConTablero escena) {
        this.setMinHeight(altoCelda);
        this.setMinWidth(anchoCelda);
        this.x = x;
        this.y = y;
        this.tablero = tablero;
        this.escena = escena;
        this.setStyle("-fx-border-style:solid;\r\n"+
        				"-fx-border-color:red;\r\n" +
        				"-fx-border-size:1px; ");
        
        escena.definirAccionDeCelda(this, tablero, x , y);
        this.vista = null;
	}
	public void colocarUnidad(VistaUnidad view) {
		//Al descolocar se lo debe pintar de nuevo.
		this.vista = view;
		this.setBackground(vista.getBackground());
		
		this.setText(String.valueOf(vista.getUnidad().getVida()));
		System.out.print(vista.getUnidad().getVida());
		this.setStyle("-fx-font-family:arial; -fx-font-size:10px");
	    this.setTextFill(Color.web("#fff"));
	    this.setTextAlignment(TextAlignment.CENTER);
	    
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public VistaUnidad getVistaUnidad() {
		return vista;
	}
	
	@Override
	public void change() {
		this.setText(String.valueOf(vista.getUnidad().getVida()));
		if(vista.getUnidad().estaMuerta()) {
	       this.escena.getVistaTablero().actualizarTablero(tablero);
		}
	}
}
