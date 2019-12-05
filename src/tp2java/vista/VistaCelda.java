package tp2java.vista;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import tp2java.modelo.Observer;
import tp2java.modelo.tablero.Tablero;

public class VistaCelda extends Button implements Observer{
	
	private VistaUnidad vista;
	private int x;
	private int y;
	
	public VistaCelda(int x, int y, double anchoCelda, double altoCelda, Tablero tablero, ContenedorConTablero escena) {

        this.setMinHeight(altoCelda);
        this.setMinWidth(anchoCelda);
        this.x = x;
        this.y = y;
        this.setStyle("-fx-border-style:solid;\r\n"+
        				"-fx-border-color:red;\r\n" +
        				"-fx-border-size:1px; ");
        
        escena.definirAccionDeCelda(this, tablero, x , y);
        this.vista = null;
	}
	public void colocarUnidad(VistaUnidad view) {
		this.vista = view;
		this.setBackground(vista.getBackground());
		
		this.setText(String.valueOf(vista.getUnidad().getVida()));
		System.out.print(vista.getUnidad().getVida());
		
		this.setStyle("-fx-font-family:arial; -fx-font-size:10px");
	    this.setTextFill(Color.web("#fff"));
	    this.setTextAlignment(TextAlignment.CENTER);
	}
	public void limpiarCelda() {
        
        this.setBackground(Background.EMPTY);
		this.setGraphic(null);
        this.setText(" ");
        this.setStyle("-fx-font-family:arial; -fx-font-size:10px; -fx-background-color: #FFFFFF;");
	    this.setTextFill(Color.web("#fff"));
	    this.setTextAlignment(TextAlignment.CENTER);
	    this.vista=null;
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
	}
	
	public void reiniciar() {
		this.setText("");
	}
	public boolean estaVacia() {
		return this.vista == null;
	}
	public boolean mismaUnidad(VistaUnidad seleccionado) {
		return this.vista == seleccionado;
	}
}
