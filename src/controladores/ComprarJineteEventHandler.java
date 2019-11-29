package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Jinete;

public class ComprarJineteEventHandler extends ComprarUnidadEventHandler implements EventHandler<ActionEvent> {

	public ComprarJineteEventHandler(Jugador jugador) {
		super(jugador, new Jinete());
	}
}
