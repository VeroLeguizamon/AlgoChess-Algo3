package vista;

import controladores.ComprarCatapultaEventHandler;
import controladores.ComprarJineteEventHandler;
import controladores.ComprarSoldadoEventHandler;
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
		
		VistaUnidad soldado = new VistaUnidad(RUTA_SOLDADO);
		soldado.setOnAction(new ComprarSoldadoEventHandler (this.jugador));
		
		VistaUnidad catapulta = new VistaUnidad(RUTA_CATAPULTA);
		catapulta.setOnAction(new ComprarCatapultaEventHandler (this.jugador));
		
		VistaUnidad jinete = new VistaUnidad(RUTA_JINETE);
		jinete.setOnAction(new ComprarJineteEventHandler (this.jugador));
		
		VistaUnidad soldado1 = new VistaUnidad(RUTA_SOLDADO);
		soldado1.setOnAction(new ComprarSoldadoEventHandler (this.jugador));
		
		this.getChildren().add(soldado);
		this.getChildren().add(catapulta);
		this.getChildren().add(jinete);
		this.getChildren().add(soldado1);
	}
}
