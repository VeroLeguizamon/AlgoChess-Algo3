package controladores;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;
import vista.ContenedorColocar;

public class TerminarCompraEventHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	private Jugador jugador1;
	private Jugador jugador2;
	private static final String RUTA_PRESIONARBOTON="src/vista/sonidos/presionarBoton.mp3";
	MediaPlayer mp;
	
	public TerminarCompraEventHandler(Stage stage, Jugador jugador1, Jugador jugador2) {
		super();
		this.stage = stage;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}

	@Override
	public void handle(ActionEvent event) {
		Media sonyInicio=new Media(new File(RUTA_PRESIONARBOTON).toURI().toString());
        mp=new MediaPlayer(sonyInicio);
		mp.play();
		
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
