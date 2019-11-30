package vista;

import java.util.ArrayList;

import controladores.UnidadColocarHandlerEvent;
import javafx.scene.layout.VBox;
import tp2java.modelo.unidades.Unidad;

public class ContenedorUnidadesColocar extends VBox {
	
	public ContenedorUnidadesColocar(VistaTablero tablero,ArrayList<Unidad> unidades, ContenedorColocar juego) {
		
//		this.setStyle("-fx-background-color: #FFFFFF");

		for(Unidad unidad : unidades) {
			VistaUnidad vista = new VistaUnidad(tablero,unidad);
			vista.setOnAction(new UnidadColocarHandlerEvent(vista,juego));
			this.getChildren().add(vista);
			
		}
		
//		System.out.println("contenedorUnidadesColocar...se coloco las unidades en la barra");
	}
}
