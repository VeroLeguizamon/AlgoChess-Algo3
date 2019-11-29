package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;
import vista.ContenedorCompra;
import vista.ContenedorColocar;

public class TerminarCompraEventHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	private Jugador jugador1;
	private Jugador jugador2;
	
	public TerminarCompraEventHandler(Stage stage, Jugador jugador1, Jugador jugador2) {
		super();
		this.stage = stage;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}

	@Override
	public void handle(ActionEvent event) {
		Juego juego = new Juego(jugador1, jugador2);
		ContenedorColocar colocar = new ContenedorColocar(this.stage, jugador1, jugador2,juego);
		colocar.setBotonSiguiente(jugador2, jugador1, juego);
		Scene escenaColocar= new Scene(colocar,1100,650);
		this.stage.setScene(escenaColocar);
		
	}
}
