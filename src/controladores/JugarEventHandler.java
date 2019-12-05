package controladores;


import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import tp2java.modelo.Jugador;
import vista.ContenedorCompra;
import vista.IngresoJugadores;
import vista.Sound;

public class JugarEventHandler implements EventHandler<ActionEvent> {
	
	private final Stage stage;
	private final ArrayList<IngresoJugadores>jugadores;
	
	
	private Sound soundInicio;
	
	public JugarEventHandler(Stage stage,ArrayList<IngresoJugadores> jugadores,Sound soundInicio) {
		this.stage = stage;
		this.jugadores=jugadores;
		this.soundInicio=soundInicio;
		
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {


		if(jugadores.get(0).tieneNombreVacio() || jugadores.get(1).tieneNombreVacio()) {
			Alert alert = new Alert(AlertType.INFORMATION);
 			alert.setTitle("USUARIO NO IDENTIFICADO. ");
 			alert.setHeaderText("Debes colocar nombres correctos.");
 			alert.setContentText("Por favor, intenta de nuevo.");

 			alert.showAndWait();

		} else {
			this.soundInicio.stop();
			String nombreJugador1 = jugadores.get(0).getNombre();
			String nombreJugador2 = jugadores.get(1).getNombre();
			
			if(nombreJugador1.equals(nombreJugador2))
				nombreJugador2 = nombreJugador2 + "2";
			
			Jugador jugador1 = new Jugador(nombreJugador1,0,9);
			Jugador jugador2 = new Jugador(nombreJugador2,10,19);

			this.cambiarEscenaCompra(jugador1,jugador2);
		}
	}
	public void cambiarEscenaCompra(Jugador jugador1, Jugador jugador2) {
		ContenedorCompra compra = new ContenedorCompra(this.stage, jugador1, jugador2);
		compra.setBotonSiguiente();
		
		Scene escenaCompra = new Scene(compra,1100,650);
		
		this.stage.setScene(escenaCompra);
		this.stage.show();
	}
}
