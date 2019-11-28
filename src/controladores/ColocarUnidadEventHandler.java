package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.unidades.Unidad;

public class ColocarUnidadEventHandler implements EventHandler<ActionEvent> {
	
	private Unidad unidad;
	private int x;
	private int y;
	
	public ColocarUnidadEventHandler(Unidad unidad, int x, int y){
		this.unidad = unidad;
		this.x = x;
		this.y = y;
	}
	@Override
	public void handle(ActionEvent event) {
		unidad.setUbicacion(new Coordenada(x,y));
	}

}
