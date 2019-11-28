package controladores;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2java.modelo.Jugador;
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
		
		String nombreJugador1 = jugadores.get(0).getNombre();
		String nombreJugador2 = jugadores.get(1).getNombre();
		
		if(nombreJugador1 == nombreJugador2)
			nombreJugador2 = nombreJugador2 + "2";
		
		Jugador jugador1 = new Jugador(nombreJugador1,0,9);
		Jugador jugador2 = new Jugador(nombreJugador2,10,19);
		
		this.app.cambiarEscenaCompra(jugador1,jugador2);
	}

}
