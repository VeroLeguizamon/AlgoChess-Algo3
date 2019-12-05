package controladores;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;
import vista.ContenedorColocar;
import vista.Sound;

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
	public void handle(ActionEvent actionEvent) {


		
		if(jugador2.tieneUnidades()) {
			
			Juego juego = new Juego(jugador1, jugador2);
			ContenedorColocar colocar = new ContenedorColocar(this.stage, jugador1, jugador2,juego);
			Scene escenaColocar= new Scene(colocar,1100,650);
			this.stage.setScene(escenaColocar);
			
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
 			alert.setTitle("Compra algo!.");
 			alert.setHeaderText("Debes comprar al menos una unidad para poder jugar");
 			alert.setContentText("Por favor, intenta de nuevo.");

 			alert.showAndWait();
		}
		
	}
}
