package tp2java.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DatosJugador extends VBox{
	private VistaJugador jugador;
	
	public DatosJugador(VistaJugador jugador) {
		super(34);
		this.jugador = jugador;
		this.nombreJugador();
		this.puntosJugador();
		this.setAlignment(Pos.CENTER);
	}
	public void nombreJugador() {
		Label label = new Label();
		label.setText("Nombre : " + jugador.getJugador().getNombre());
		label.setStyle("-fx-font-family:arial; -fx-font-size:20;");
	    label.setTextFill(Color.web("#fff"));
	    
		this.getChildren().add(label);
	}
	public void puntosJugador() {
		Label label = new Label();
		label.setText("Puntos : " + jugador.getPuntos());
		label.setStyle("-fx-font-family:arial; -fx-font-size:20;");
	    label.setTextFill(Color.web("#fff"));
	    
		this.getChildren().add(label);
	}
	public void cambiarPuntos() {
		this.getChildren().remove(1);
		this.puntosJugador();
	}
	
}
