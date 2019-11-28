package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp2java.modelo.Jugador;
import vista.ContenedorCompra;
import vista.ContenedorJuego;

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
		
		ContenedorJuego juego = new ContenedorJuego(this.stage, jugador1, jugador2);
		Scene escenaJuego= new Scene(juego,1100,650);
		this.stage.setScene(escenaJuego);
		
	}
}
