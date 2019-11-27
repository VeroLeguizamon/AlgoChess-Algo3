package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp2java.modelo.Jugador;
import vista.ContenedorCompra;

public class SiguienteJugadorEventHandler implements EventHandler<ActionEvent>{
	//private final Jugador jugador;
	private final Stage stage;
	
	
	public SiguienteJugadorEventHandler(Stage stage) {
		this.stage = stage;
	}
	@Override
	public void handle(ActionEvent actionEvent) {
		ContenedorCompra compra =new ContenedorCompra(this.stage);
		compra.setBotonTerminar();
		Scene escenaCompra = new Scene(compra,1100,650);
		this.stage.setScene(escenaCompra);
	}
}
