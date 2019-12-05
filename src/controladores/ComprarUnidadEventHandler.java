package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Unidad;
import vista.Sound;

public class ComprarUnidadEventHandler implements EventHandler<ActionEvent> {
	private Unidad unidad;
	private Jugador jugador;
	private static final String RUTA_PRESIONARBOTON="src/vista/sonidos/presionarBoton.mp3";
	
	private Sound sound=new Sound(RUTA_PRESIONARBOTON);
	
    
	
	public ComprarUnidadEventHandler(Jugador jugador, Unidad unidad){
		this.unidad = unidad;
		this.jugador = jugador;
		
	}
	@Override
	public void handle(ActionEvent event) { 
		this.sound.play();
		
		
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

		
	}
}
