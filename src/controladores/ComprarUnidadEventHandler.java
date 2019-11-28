package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Unidad;

public class ComprarUnidadEventHandler implements EventHandler<ActionEvent> {
	private Unidad unidad;
	private Jugador jugador;
	
	public ComprarUnidadEventHandler(Jugador jugador, Unidad unidad){
		this.unidad = unidad;
		this.jugador = jugador;
	}
	@Override
	public void handle(ActionEvent event) {
		if(jugador.noTienePuntosSuficientesParaComprar(unidad)) {
 			// Manda una alerta
 			Alert alert = new Alert(AlertType.INFORMATION);
 			alert.setTitle("Puntos insuficientes");
 			alert.setHeaderText("No puedes comprar mas unidades!");
 			alert.setContentText("Por favor, presiona siguiente.");

 			alert.showAndWait();
		} else {
			jugador.comprarUnidad(unidad);
		}
	}

}
