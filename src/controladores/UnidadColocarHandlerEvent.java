package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import vista.ContenedorJuego;
import vista.VistaUnidad;

public class UnidadColocarHandlerEvent implements EventHandler<ActionEvent> {

	private VistaUnidad unidad;
	private ContenedorJuego escena;
	
	public UnidadColocarHandlerEvent(VistaUnidad vista, ContenedorJuego juego) {
		this.unidad = vista;
		this.escena = juego;
	}
	@Override
	public void handle(ActionEvent arg0) {
		if(escena.hayUnidadSeleccionada()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Look, an Information Dialog");
			alert.setContentText("I have a great message for you!");

			alert.showAndWait();
		} else {
			escena.setUnidadSeleccionada(this.unidad);
			this.unidad.setStyle("-fx-border-style:solid; -fx-border-size:2px; -fx-border-color:#fff;");
		}
	}

}
