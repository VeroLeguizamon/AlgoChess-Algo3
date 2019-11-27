package controladores;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.Aplicacion;
import vista.IngresoJugadores;

public class JugarEventHandler implements EventHandler<ActionEvent> {
	
	private final  Aplicacion app;
	private final ArrayList<IngresoJugadores>jugadores;
	
	
	
	public JugarEventHandler(Aplicacion aplicacion,ArrayList<IngresoJugadores> jugadores) {
		this.app=aplicacion;
		this.jugadores=jugadores;
		
	}
	@Override
	public void handle(ActionEvent actionEvent) {
		this.app.cambiarEscenaCompra();
		
		// TODO: debe tratarse los nombres de los jugadores que no sean repetidos, que no 
		// vacio, etc
	}

}
