package vista;

import controladores.ComprarCatapultaEventHandler;
import controladores.ComprarCuranderoEventHandler;
import controladores.ComprarJineteEventHandler;
import controladores.ComprarSoldadoEventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import tp2java.modelo.Jugador;

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
		
		VistaCompraUnidad curandero = new VistaCompraUnidad(RUTA_CURANDERO);
		curandero.setOnAction(new ComprarCuranderoEventHandler (this.jugador));
		
		this.getChildren().add(soldado);
		this.getChildren().add(catapulta);
		this.getChildren().add(jinete);
		this.getChildren().add(curandero);
	}
}
