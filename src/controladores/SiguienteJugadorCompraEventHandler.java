package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp2java.modelo.Jugador;
import vista.ContenedorCompra;

public class SiguienteJugadorCompraEventHandler implements EventHandler<ActionEvent>{
	//private final Jugador jugador;
	private final Stage stage;
	private Jugador jugador1;
	private Jugador jugador2;
	
	public SiguienteJugadorCompraEventHandler(Stage stage, Jugador jugador1, Jugador jugador2) {
		this.stage = stage;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	@Override
	public void handle(ActionEvent actionEvent) {
		
		ContenedorCompra compra =new ContenedorCompra(this.stage, jugador2, jugador1);
		compra.setBotonTerminar();
		Scene escenaCompra = new Scene(compra,1100,650);
		this.stage.setScene(escenaCompra);
	}
}
