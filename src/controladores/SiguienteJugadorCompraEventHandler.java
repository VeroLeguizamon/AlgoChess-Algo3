package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import tp2java.modelo.Jugador;
import vista.ContenedorCompra;


public class SiguienteJugadorCompraEventHandler implements EventHandler<ActionEvent>{
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


		
		if(jugador1.tieneUnidades()) {
			ContenedorCompra compra =new ContenedorCompra(this.stage, jugador2, jugador1);
			compra.setBotonTerminar();
			Scene escenaCompra = new Scene(compra,1100,650);
			this.stage.setScene(escenaCompra);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
 			alert.setTitle("Compra algo!.");
 			alert.setHeaderText("Debes comprar al menos una unidad para poder jugar");
 			alert.setContentText("Por favor, intenta de nuevo.");

 			alert.showAndWait();
		}

	}
}
