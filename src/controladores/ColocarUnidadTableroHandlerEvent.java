package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Unidad;
import vista.ContenedorJuego;
import vista.VistaCelda;

public class ColocarUnidadTableroHandlerEvent implements EventHandler<ActionEvent> {
	private ContenedorJuego escena;
	private Tablero tablero;
	private int x;
	private int y;
	private VistaCelda celda;
	
	public ColocarUnidadTableroHandlerEvent(VistaCelda celda, Tablero tablero, ContenedorJuego juego, int x, int y) {
		this.escena = juego;
		this.x = x;
		this.y = y;
		this.celda = celda;
	}
	@Override
	public void handle(ActionEvent arg0) {
		if(escena.hayUnidadSeleccionada()) {
			this.celda.setStyle("-fx-border-style:solid; -fx-border-size:2px; -fx-border-color:#fff;");
			escena.setCeldaSeleccionada(celda);
			
			escena.colocar(celda);
			
			escena.resetCelda();
			escena.resetSeleccionado();
			
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Celda ya seleccionada");
			alert.setHeaderText("Look, an Information Dialog");
			alert.setContentText("I have a great message for you!");
			alert.showAndWait();
		}
	}

}
