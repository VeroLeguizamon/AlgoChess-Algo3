package vista;

import java.awt.event.MouseAdapter;
import java.io.File;

import controladores.ComprarCatapultaEventHandler;
import controladores.ComprarJineteEventHandler;
import controladores.ComprarSoldadoEventHandler;
import controladores.ComprarUnidadEventHandler;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Catapulta;
import tp2java.modelo.unidades.Jinete;
import tp2java.modelo.unidades.SoldadoDeInfanteria;

public class ContenedorUnidadesComprar extends HBox{
	public Jugador jugador;
	private static String RUTA_SOLDADO = "file:src/vista/imagenes/SoldadoDeInfanteria.png";
	private static String RUTA_JINETE = "file:src/vista/imagenes/Jinete.png";
	private static String RUTA_CATAPULTA = "file:src/vista/imagenes/Catapulta.png";
	private static String RUTA_CURANDERO = "file:src/vista/imagenes/Curandero.png";
	
	

	public ContenedorUnidadesComprar(Jugador jugador) {
		super(5);
		this.jugador = jugador;
		this.setPadding(new Insets(10));
        
		
		VistaCompraUnidad soldado = new VistaCompraUnidad(RUTA_SOLDADO);
		soldado.setOnAction(new ComprarSoldadoEventHandler (this.jugador));
		
		VistaCompraUnidad catapulta = new VistaCompraUnidad(RUTA_CATAPULTA);
		catapulta.setOnAction(new ComprarCatapultaEventHandler (this.jugador));
		
		VistaCompraUnidad jinete = new VistaCompraUnidad(RUTA_JINETE);
		jinete.setOnAction(new ComprarJineteEventHandler (this.jugador));
		
		VistaCompraUnidad soldado1 = new VistaCompraUnidad(RUTA_CURANDERO);
		soldado1.setOnAction(new ComprarSoldadoEventHandler (this.jugador));
		
		this.getChildren().add(soldado);
		this.getChildren().add(catapulta);
		this.getChildren().add(jinete);
		this.getChildren().add(soldado1);
	}
}
