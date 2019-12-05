package controladores;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import tp2java.modelo.Juego;
import vista.ContenedorJuego;
import vista.Sound;

public class TerminarTurnoEventHander implements EventHandler<ActionEvent>{
//	private static final String RUTA_PRESIONARBOTON = null;
	private Juego juego;
	private ContenedorJuego contJuego;
	
	private static final String RUTA_GANADOR="src/vista/sonidos/sonidoGanador.mp3";
	private Sound sound=new Sound(RUTA_GANADOR);
	private Sound ambiente;

	
	public TerminarTurnoEventHander(ContenedorJuego contJuego, Juego juego, Sound ambiente){
		super();
		this.contJuego = contJuego;
		this.juego = juego;
		this.ambiente = ambiente;
	}
	@Override
	public void handle(ActionEvent arg0) {
		if(juego.hayGanador()) {
			
			ambiente.stop();
			sound.play();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Felicidades!");
			alert.setHeaderText("Ha ganado el jugador "+contJuego.getJugadorEnTurno().getNombre());
			alert.showAndWait();
		}
		else {
			if(contJuego.getJugadorEnTurno().realizoAccion()) {
				siguienteTurno();
			}
			else {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Quiere terminar su turno?");
				alert.setHeaderText("Aun no realizo su accion.");
				alert.setContentText("Desea terminarlo de todas formas?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
				    siguienteTurno();
				} 
			}
		}
	}
	
	private void siguienteTurno() {
		
		if(contJuego.hayUnidadSeleccionada()) {
			contJuego.resetSeleccionado();
		}
		contJuego.quitarBotonesMovimiento();
		contJuego.siguienteTurno();
		
	}

}
