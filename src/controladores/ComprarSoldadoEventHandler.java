package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.SoldadoDeInfanteria;
import tp2java.modelo.unidades.Unidad;

public class ComprarSoldadoEventHandler extends ComprarUnidadEventHandler {

	
	public ComprarSoldadoEventHandler(Jugador jugador){
		
		
		super(jugador,new SoldadoDeInfanteria());
	}

}
