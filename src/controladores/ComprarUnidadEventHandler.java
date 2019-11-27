package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Unidad;
import vista.VistaUnidad;

public class ComprarUnidadEventHandler implements EventHandler<ActionEvent> {
	private VistaUnidad unidad;
	private Jugador jugador;
	
	public ComprarUnidadEventHandler(Jugador jugador, VistaUnidad unidad){
		this.unidad = unidad;
		this.jugador = jugador;
	}
	@Override
	public void handle(ActionEvent event) {
		Unidad unidad = this.unidad.obtenerNuevaUnidad();
		if(jugador.noTienePuntosSuficientesParaComprar(unidad)) {
 			// Manda una alerta
 			Alert alert = new Alert(AlertType.INFORMATION);
 			alert.setTitle("Puntos insuficientes");
 			alert.setHeaderText("No puedes comprar mas unidades!");
 			alert.setContentText("Por favor, presiona siguiente.");

 			alert.showAndWait();
		} else {
			jugador.comprarUnidad(unidad);
			// Esto... solo por inseguridada jaja Borrar luego
			System.out.println(jugador.getPuntos());
		}
	}

}
