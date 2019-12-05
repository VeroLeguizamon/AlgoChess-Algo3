package controladores;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Unidad;

public class ComprarUnidadEventHandler implements EventHandler<ActionEvent> {
	private Unidad unidad;
	private Jugador jugador;
	private static final String RUTA_PRESIONARBOTON="src/vista/sonidos/presionarBoton.mp3";
	MediaPlayer mp;
	
	
	public ComprarUnidadEventHandler(Jugador jugador, Unidad unidad){
		this.unidad = unidad;
		this.jugador = jugador;
		
	}
	@Override
	public void handle(ActionEvent event) {        
		Unidad nueva = null;
		try {
			nueva = unidad.getClass().newInstance();
		}  catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if (jugador.tieneSuficientesPuntosParaComprar(nueva)) {
			jugador.comprarUnidad(nueva);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
 			alert.setTitle("Puntos insuficientes");
 			alert.setHeaderText("No puedes comprar mas unidades!");
 			alert.setContentText("Por favor, presiona siguiente.");

 			alert.showAndWait();
		}
		Media sonyInicio=new Media(new File(RUTA_PRESIONARBOTON).toURI().toString());
		        MediaPlayer mediaplayer=new MediaPlayer(sonyInicio);
		        mediaplayer.play();
	}
}
