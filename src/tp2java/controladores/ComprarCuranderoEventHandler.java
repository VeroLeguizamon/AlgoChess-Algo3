package tp2java.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2java.controladores.ComprarUnidadEventHandler;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Curandero;

public class ComprarCuranderoEventHandler extends ComprarUnidadEventHandler implements EventHandler<ActionEvent> {

	public ComprarCuranderoEventHandler(Jugador jugador) {
		super(jugador, new Curandero());
	}
}
