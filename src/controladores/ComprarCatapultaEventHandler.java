package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Catapulta;

public class ComprarCatapultaEventHandler extends ComprarUnidadEventHandler implements EventHandler<ActionEvent> {

	public ComprarCatapultaEventHandler(Jugador jugador) {
		super(jugador, new Catapulta(jugador));
	}


}
