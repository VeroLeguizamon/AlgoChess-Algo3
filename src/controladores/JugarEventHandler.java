package controladores;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.IngresoJugadores;

public class JugarEventHandler implements EventHandler<ActionEvent> {
	
	private final Stage stage;
	private final ArrayList<IngresoJugadores>jugadores;
	
	
	
	public JugarEventHandler(Stage stage,ArrayList<IngresoJugadores> jugadores) {
		this.stage=stage;
		this.jugadores=jugadores;
		
	}
	@Override
	public void handle(ActionEvent actionEvent) {
		//tenemos que poner lo que tendremos en Contenedor principal
	}

}
