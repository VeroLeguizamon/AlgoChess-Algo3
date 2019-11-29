package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;

public class TerminarColocarEventHander implements EventHandler<ActionEvent>{
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
		
	}

}
