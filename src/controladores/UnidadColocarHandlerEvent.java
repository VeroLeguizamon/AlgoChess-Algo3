package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import vista.ContenedorColocar;
import vista.VistaUnidad;

public class UnidadColocarHandlerEvent implements EventHandler<ActionEvent> {

	private VistaUnidad unidad;
	private ContenedorColocar escena;
	
	public UnidadColocarHandlerEvent(VistaUnidad vista, ContenedorColocar juego) {
		this.unidad = vista;
		this.escena = juego;
	}
	@Override
	public void handle(ActionEvent arg0) {
		if(escena.hayUnidadSeleccionada()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Oops I did it again");
			alert.setHeaderText("I play with your heart");
			alert.setContentText("Got lost in the game OH BABY BABY");

			alert.showAndWait();
		} else {
			escena.setUnidadSeleccionada(this.unidad);
			unidad.setStyle("-fx-border-size:1px"+
							"-fx-border-color:#fff;"+
							"-fx-border-style:solid;");
		}
	}

}
