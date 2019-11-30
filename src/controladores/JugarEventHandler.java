package controladores;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tp2java.modelo.Jugador;
import vista.Aplicacion;
import vista.IngresoJugadores;

public class JugarEventHandler implements EventHandler<ActionEvent> {
	
	private final  Aplicacion app;
	private final ArrayList<IngresoJugadores>jugadores;
	private static final String RUTA_PRESIONARBOTON="src/vista/sonidos/presionarBoton.mp3";
	MediaPlayer mp;
	MediaPlayer mediaplayer;
	public JugarEventHandler(Aplicacion aplicacion,ArrayList<IngresoJugadores> jugadores,MediaPlayer mediaplayer) {
		this.app=aplicacion;
		this.jugadores=jugadores;
		this.mediaplayer=mediaplayer;
		
		
	}
	@Override
	public void handle(ActionEvent actionEvent) {
		
		
		mediaplayer.stop();
		Media sonyInicio=new Media(new File(RUTA_PRESIONARBOTON).toURI().toString());
        mp=new MediaPlayer(sonyInicio);
		mp.play();
		
		String nombreJugador1 = jugadores.get(0).getNombre();
		String nombreJugador2 = jugadores.get(1).getNombre();
		
		if(nombreJugador1 == nombreJugador2)
			nombreJugador2 = nombreJugador2 + "2";
		
		Jugador jugador1 = new Jugador(nombreJugador1,0,9);
		Jugador jugador2 = new Jugador(nombreJugador2,10,19);
		
		this.app.cambiarEscenaCompra(jugador1,jugador2);
	}

}
