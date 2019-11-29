package vista;

import java.util.ArrayList;

import controladores.UnidadColocarHandlerEvent;
import javafx.scene.layout.VBox;
import tp2java.modelo.unidades.Unidad;

public class ContenedorUnidadesColocar extends VBox {
	private ArrayList<Unidad>unidades;
	private VistaTablero tablero;
	
	public ContenedorUnidadesColocar(VistaTablero tablero,ArrayList<Unidad> unidades, ContenedorJuego juego) {
		this.unidades = unidades;
		this.tablero = tablero;
		
		for(Unidad unidad : this.unidades) {
			VistaUnidad vista = new VistaUnidad(this.tablero,unidad);
			vista.setOnAction(new UnidadColocarHandlerEvent(vista,juego));
			this.getChildren().add(vista);
		}
	}
}
