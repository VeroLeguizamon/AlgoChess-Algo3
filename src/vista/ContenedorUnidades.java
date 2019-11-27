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
	private static String RUTA_SOLDADO = "file:src/vista/imagenes/soldado.jpg";
	private static String RUTA_JINETE = "file:src/vista/imagenes/jinete.png";
	private static String RUTA_CATAPULTA = "file:src/vista/imagenes/catapulta.png";

	public ContenedorUnidades(Jugador jugador) {
		super(5);
		this.jugador = jugador;
		this.setPadding(new Insets(10));
		
		VistaUnidad soldado = new VistaUnidad(RUTA_SOLDADO, new SoldadoDeInfanteria());
		soldado.setOnAction(new ComprarUnidadEventHandler (this.jugador, soldado));
		
		VistaUnidad catapulta = new VistaUnidad(RUTA_CATAPULTA, new Catapulta());
		catapulta.setOnAction(new ComprarUnidadEventHandler (this.jugador, catapulta));
		
		VistaUnidad jinete = new VistaUnidad(RUTA_JINETE, new Jinete());
		jinete.setOnAction(new ComprarUnidadEventHandler (this.jugador, jinete));
		
		VistaUnidad soldado1 = new VistaUnidad(RUTA_SOLDADO, new SoldadoDeInfanteria());
		soldado1.setOnAction(new ComprarUnidadEventHandler (this.jugador, soldado1));
		
		this.getChildren().add(soldado);
		this.getChildren().add(catapulta);
		this.getChildren().add(jinete);
		this.getChildren().add(soldado1);
	}
}
