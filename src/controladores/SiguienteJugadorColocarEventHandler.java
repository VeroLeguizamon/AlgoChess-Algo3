package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;
import vista.ContenedorColocar;

public class SiguienteJugadorColocarEventHandler implements EventHandler<ActionEvent> {
	private Jugador jugador1;
	private Jugador jugador2;
	private Juego juego;
	private Stage stage;
	
	public SiguienteJugadorColocarEventHandler(Stage stage, Jugador jugadorSiguiente, Jugador jugadorEnEspera, Juego juego){
		super();
		this.jugador1 = jugadorSiguiente;
		this.jugador2 = jugadorEnEspera;
		this.stage = stage;
		this.juego = juego;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		
		ContenedorColocar colocar = new ContenedorColocar(this.stage, jugador1, jugador2,juego);
		colocar.setBotonTerminar(jugador1, jugador2, juego);
		Scene escenaColocar= new Scene(colocar,1100,650);
		this.stage.setScene(escenaColocar);
	}

}
