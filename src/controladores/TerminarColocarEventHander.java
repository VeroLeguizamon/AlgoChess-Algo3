package controladores;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;
import vista.ContenedorColocar;
import vista.ContenedorJuego;

public class TerminarColocarEventHander implements EventHandler<ActionEvent>{
	private static final String RUTA_PRESIONARBOTON = null;
	private Jugador jugador1;
	private Jugador jugador2;
	private Juego juego;
	private Stage stage;
	
	public TerminarColocarEventHander(Stage stage, Jugador jugadorSiguiente, Jugador jugadorEnEspera, Juego juego){
		super();
		this.jugador1 = jugadorSiguiente;
		this.jugador2 = jugadorEnEspera;
		this.stage = stage;
		this.juego = juego;
	}
	@Override
	public void handle(ActionEvent arg0) {
		ContenedorJuego contJuego = new ContenedorJuego(this.stage, jugador1, jugador2,juego);
		Scene escenaJuego= new Scene(contJuego,1100,650);
		this.stage.setScene(escenaJuego);
		
	}

}
