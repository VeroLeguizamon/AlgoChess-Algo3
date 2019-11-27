package vista;

import controladores.ComprarUnidadEventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Catapulta;
import tp2java.modelo.unidades.Jinete;
import tp2java.modelo.unidades.SoldadoDeInfanteria;

public class ContenedorUnidades extends HBox{
	public Jugador jugador;
	
	public ContenedorUnidades(Jugador jugador) {
		super(5);
		this.jugador = jugador;
		this.setPadding(new Insets(10));
		
		VistaUnidad soldado = new VistaUnidad("file:src/vista/imagenes/soldado.jpg", new SoldadoDeInfanteria());
		soldado.setOnAction(new ComprarUnidadEventHandler (this.jugador,soldado.getUnidad()));
		
		this.getChildren().add(soldado);
	}
}
