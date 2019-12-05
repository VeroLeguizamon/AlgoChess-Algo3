package tp2java.controladores;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import tp2java.modelo.Jugador;
import tp2java.vista.Aplicacion;
import tp2java.vista.ContenedorCompra;
import tp2java.vista.IngresoJugadores;

public class JugarEventHandler implements EventHandler<ActionEvent> {
	
	private final Stage stage;
	private final ArrayList<IngresoJugadores>jugadores;
	private static final String RUTA_PRESIONARBOTON="src/vista/sonidos/presionarBoton.mp3";
	MediaPlayer mp;
	MediaPlayer mediaplayer;
	
	public JugarEventHandler(Stage stage,ArrayList<IngresoJugadores> jugadores,MediaPlayer mediaplayer) {
		this.stage = stage;
		this.jugadores=jugadores;
		this.mediaplayer=mediaplayer;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		Media sonyInicio=new Media(new File(RUTA_PRESIONARBOTON).toURI().toString());
        mp=new MediaPlayer(sonyInicio);
		mp.play();
		
		if(jugadores.get(0).tieneNombreVacio() || jugadores.get(1).tieneNombreVacio()) {
			Alert alert = new Alert(AlertType.INFORMATION);
 			alert.setTitle("USUARIO NO IDENTIFICADO. ");
 			alert.setHeaderText("Debes colocar nombres correctos.");
 			alert.setContentText("Por favor, intenta de nuevo.");

 			alert.showAndWait();

		} else {
			mediaplayer.stop();
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
