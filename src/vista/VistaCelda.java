package vista;

import controladores.ColocarUnidadTableroHandlerEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Unidad;

public class VistaCelda extends Button {
	private VistaUnidad vista;
	private int x;
	private int y;	
	public VistaCelda(int x, int y, double anchoCelda, double altoCelda, Tablero tablero, ContenedorColocar escena) {
        this.setMinHeight(altoCelda);
        this.setMinWidth(anchoCelda);
        this.x = x;
        this.y = y;
        this.setStyle("-fx-border-style:solid;\r\n"+
        				"-fx-border-color:red;\r\n" +
        				"-fx-border-size:1px; ");
        this.setOnAction(new ColocarUnidadTableroHandlerEvent(this,tablero, escena, x,y));
        this.vista = null;
	}
	public void colocarUnidad(VistaUnidad view) {
		//Al descolocar se lo debe pintar de nuevo.
		this.vista = view;
		this.setBackground(vista.getBackground());
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
