package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import vista.ContenedorColocar;
import vista.VistaUnidad;

public class UnidadColocarEventHandler implements EventHandler<ActionEvent> {

	private VistaUnidad unidad;
	private ContenedorColocar escena;
	
	public UnidadColocarEventHandler(VistaUnidad vista, ContenedorColocar juego) {
		this.unidad = vista;
		this.escena = juego;
	}
	@Override
	public void handle(ActionEvent arg0) {
		if(escena.hayUnidadSeleccionada()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alertaaaa!");
			alert.setHeaderText("Ya seleccionaste una unidad");
			alert.setContentText("Intente otra vez");

			alert.showAndWait();
		} else {
			escena.setUnidadSeleccionada(this.unidad);
		}
	}

}
