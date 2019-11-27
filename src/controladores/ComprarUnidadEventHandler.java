package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import tp2java.excepciones.PuntosInsuficientes;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.SoldadoDeInfanteria;
import tp2java.modelo.unidades.Unidad;

public class ComprarUnidadEventHandler implements EventHandler<ActionEvent> {
	private Unidad unidad;
	private Jugador jugador;
	
	public ComprarUnidadEventHandler(Jugador jugador, Unidad unidad){
		this.unidad = unidad;
		this.jugador = jugador;
	}
	@Override
	public void handle(ActionEvent event) {
		
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
 		if(jugador.noTienePuntosSuficientesParaComprar(soldado)) {
 			// TODO: mandar alerta
 			System.out.println();
		} else {
			jugador.comprarUnidad(soldado);
		}
	}

}
