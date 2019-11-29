package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Unidad;
import vista.ContenedorColocar;
import vista.VistaCelda;

public class ColocarUnidadTableroHandlerEvent implements EventHandler<ActionEvent> {
	private ContenedorColocar escena;
	private Tablero tablero;
	private Coordenada coordenada;
	
	public ColocarUnidadTableroHandlerEvent(VistaCelda celda, Tablero tablero, ContenedorColocar juego, int x, int y) {
		this.escena = juego;
		this.tablero = tablero;
		this.coordenada =new Coordenada(x,y);
	}
	@Override
	public void handle(ActionEvent event) {
		 
		if(escena.hayUnidadSeleccionada()) {
			Unidad unidad = escena.getUnidadSeleccionada().getUnidad();
			unidad.setUbicacion(this.coordenada);
			unidad.setTablero(tablero);
			if (tablero.laCeldaEstaLibre(coordenada) && unidad.perteneceASuSector()) {
				tablero.colocarUnidad(unidad);
				escena.resetSeleccionado();
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Elige otra celda");
				alert.setHeaderText("Por favor, selecciona una.");
				alert.setContentText("Un gran poder conlleva una gran responsabilidad");
				alert.showAndWait();
			}	
		
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No seleccionaste una unidad antes :(");
			alert.setHeaderText("Por favor, selecciona una.");
			alert.setContentText("Un gran poder conlleva una gran responsabilidad");
			alert.showAndWait();
		}
	}

}
