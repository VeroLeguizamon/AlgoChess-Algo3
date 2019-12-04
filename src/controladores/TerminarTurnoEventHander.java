package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import tp2java.modelo.Juego;
import vista.ContenedorJuego;

public class TerminarTurnoEventHander implements EventHandler<ActionEvent>{
//	private static final String RUTA_PRESIONARBOTON = null;
	private Juego juego;
	private ContenedorJuego contJuego;
	
	public TerminarTurnoEventHander(ContenedorJuego contJuego, Juego juego){
		super();
		this.contJuego = contJuego;
		this.juego = juego;
	}
	@Override
	public void handle(ActionEvent arg0) {
		if(juego.hayGanador()) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Felicidades!");
			alert.setHeaderText("Ha ganado el jugador "+contJuego.getJugadorEnTurno().getNombre());
			alert.showAndWait();
		}
		else {
			if(contJuego.hayUnidadSeleccionada()) {
				contJuego.resetSeleccionado();
			}
			contJuego.quitarBotonesMovimiento();
			contJuego.siguienteTurno();
		}
	}

}
