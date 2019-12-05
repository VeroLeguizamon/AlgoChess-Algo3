package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;
import vista.ContenedorJuego;

public class TerminarColocarEventHander implements EventHandler<ActionEvent>{
	private Jugador jugador1;
	private Jugador jugador2;
	private Juego juego;
	private Stage stage;
	
	public TerminarColocarEventHander(Stage stage, Jugador jugadorSiguiente, Jugador jugadorEnEspera, Juego juego){
		super();
		this.jugador1 = jugadorSiguiente;
		this.jugador2 = jugadorEnEspera;
		this.stage = stage;
		this.juego = juego;
	}
	@Override
	public void handle(ActionEvent arg0) {
		int unidadesCompradasPorAmbos = jugador1.cantidadDeUnidades() + jugador2.cantidadDeUnidades();
		int unidadesColocadas = juego.getTablero().cantUnidades();
		
		if(unidadesColocadas == unidadesCompradasPorAmbos) {
			ContenedorJuego contJuego = new ContenedorJuego(this.stage, jugador1, jugador2,juego);
			Scene escenaJuego= new Scene(contJuego,1100,650);
			this.stage.setScene(escenaJuego);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No colocaste todas las unidades.");
			alert.setHeaderText("Por favor, hazlo.");
			alert.setContentText("Un gran poder conlleva una gran responsabilidad");
			alert.showAndWait();	
		}
	}

}
