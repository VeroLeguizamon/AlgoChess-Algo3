package controladores;
import controladores.ComprarUnidadEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Curandero;

public class ComprarCuranderoEventHandler extends ComprarUnidadEventHandler implements EventHandler<ActionEvent> {

	public ComprarCuranderoEventHandler(Jugador jugador) {
		super(jugador, new Curandero());
	}
}
