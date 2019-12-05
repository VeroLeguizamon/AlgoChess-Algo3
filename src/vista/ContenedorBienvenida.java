package vista;

import java.io.File;
import java.util.ArrayList;

import controladores.JugarEventHandler;
import controladores.SalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ContenedorBienvenida extends VBox{
	private final ArrayList<IngresoJugadores> jugadores;
	private static final String RUTA_FONDOBIENVENIDA="file:src/vista/imagenes/fondoBienvenida.png";
	private static final String RUTA_TITULO="file:src/vista/imagenes/logo1.png";
	private static final String RUTA_JUGAR="file:src/vista/imagenes/juga.png";
	private static final String RUTA_SALIR="file:src/vista/imagenes/salir.png";
	
	private static final String RUTA_SONYINICIO="src/vista/sonidos/sonidoInicio2.mp3";

	
	private Sound sound=new Sound(RUTA_SONYINICIO);

	Stage stage;
	
	public ContenedorBienvenida(Stage stage) {
		super();
		
		this.jugadores=new ArrayList<IngresoJugadores>();
		this.stage=stage;		
		this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        //ingreso nombre de los jugadores
        IngresoJugadores primerjugador= new IngresoJugadores("Ingrese nombre. Primer jugador");
        IngresoJugadores segundojugador= new IngresoJugadores("Ingrese nombre. Segundo jugador");
        
        this.jugadores.add(primerjugador);
        this.jugadores.add(segundojugador);
        
        //mostramos los box para completar los nombres
        VBox vBox= new VBox(30,primerjugador.gethBox(),segundojugador.gethBox());
        vBox.setAlignment(Pos.CENTER);
        //imagen titulo
        Image titulo=new Image(RUTA_TITULO,800,300,true,true);
        ImageView vistaTitulo=new ImageView(titulo);
        
        //para la imagen de fondo
        Image fondoBienvenida= new Image(RUTA_FONDOBIENVENIDA,1100,650,false,true);
        BackgroundImage mostrarFondoBienvenida=new BackgroundImage(fondoBienvenida, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        this.setBackground(new Background(mostrarFondoBienvenida));
        
        this.sound.play();
        this.getChildren().addAll(vistaTitulo,vBox);
	}
	
	public void setBotonesSalirJugar(Aplicacion app) {
		
		JugarEventHandler jugarEvent=new JugarEventHandler(this.stage, jugadores,this.sound);
		SalirEventHandler salirEvent=new SalirEventHandler();
		
		Button botonJugar=new Button("");
		botonJugar.setOnAction(jugarEvent);
		botonJugar.setBackground(Background.EMPTY);
		Image imagenjugar=new Image(RUTA_JUGAR,150,150,true,true);
		botonJugar.setGraphic(new ImageView(imagenjugar));
		
		Button botonSalir=new Button("");
		botonSalir.setOnAction(salirEvent);
		botonSalir.setBackground(Background.EMPTY);
		Image imagensalir=new Image(RUTA_SALIR,150,150,true,true);
		botonSalir.setGraphic(new ImageView(imagensalir));
		
		this.getChildren().addAll(botonJugar,botonSalir);
	}

}
