package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.SoldadoDeInfanteria;

public class ComprarSoldadoEventHandler extends ComprarUnidadEventHandler implements EventHandler<ActionEvent> {
	
	public ComprarSoldadoEventHandler(Jugador jugador){
		super(jugador, new SoldadoDeInfanteria(jugador));
	}

}
