package controladores;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.ContenedorCompra;
import vista.IngresoJugadores;

public class JugarEventHandler implements EventHandler<ActionEvent> {
	
	private final Stage stage;
	private final ArrayList<IngresoJugadores>jugadores;
	
	
	
	public JugarEventHandler(Stage stage,ArrayList<IngresoJugadores> jugadores) {
		this.stage=stage;
		this.jugadores=jugadores;
		
	}
	@Override
	public void handle(ActionEvent actionEvent) {
		ContenedorCompra compra = new ContenedorCompra(this.stage);
		compra.setBotonSiguiente();
		Scene escenaCompra = new Scene(compra,1100,650);
		this.stage.setScene(escenaCompra);
		this.stage.show();
		// TODO: debe tratarse los nombres de los jugadores que no sean repetidos, que no 
		// vacio, etc
	}

}
