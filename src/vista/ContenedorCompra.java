package vista;
import controladores.SiguienteJugadorCompraEventHandler;
import controladores.TerminarCompraEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tp2java.modelo.Jugador;

public class ContenedorCompra extends HBox{
	private static final String RUTA_FONDO="file:src/vista/imagenes/fondoTienda.png";
	private static final String RUTA_SIGUIENTE="file:src/vista/imagenes/siguiente.png";
	private static final String RUTA_TITULO="file:src/vista/imagenes/TiendaTitulo.png";
	private static final String RUTA_TERMINAR="file:src/vista/imagenes/terminar.png";
	
	
	private static final String RUTA_PRESIONARBOTON="src/vista/sonidos/presionarBoton.mp3";
	
	private Sound soundBoton=new Sound(RUTA_PRESIONARBOTON);
	
	

	
	
	private Jugador jugador1;
	private Jugador jugador2;
	private VistaJugador vistaJugador;
	public final Stage stage;
	
	private VBox box = new VBox(20);
	
	public ContenedorCompra(Stage stage, Jugador jugador1, Jugador jugador2) {

		
		this.stage = stage;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
	    this.setPadding(new Insets(25));

	    vistaJugador = new VistaJugador(jugador1);
        Image fondoBienvenida= new Image(RUTA_FONDO,1100,650,false,true);
        BackgroundImage mostrarFondoBienvenida=new BackgroundImage(fondoBienvenida, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
		
        HBox hb = new HBox(25);
        Image titulo=new Image(RUTA_TITULO,450,200,true,true);
        ImageView vistaTitulo=new ImageView(titulo);
        
        hb.getChildren().add(vistaTitulo);
		hb.setMinHeight(100);
		hb.setMinWidth(70);
		hb.setPadding(Insets.EMPTY);
		hb.setAlignment(Pos.TOP_CENTER);
		
        this.box.getChildren().add(hb);
  
        this.contenedorJugador(vistaJugador);
        ContenedorUnidadesComprar unidades = new ContenedorUnidadesComprar(jugador1);
        
        this.box.getChildren().add(unidades);
        this.getChildren().add(box);
        
        this.setBackground(new Background(mostrarFondoBienvenida));        
	}
	
	public void setBotonSiguiente() {
		this.setBoton(RUTA_SIGUIENTE, new SiguienteJugadorCompraEventHandler(this.stage, jugador1, jugador2));
		
	}
	
	public void setBotonTerminar() {
		
		this.setBoton(RUTA_TERMINAR, new TerminarCompraEventHandler(this.stage, jugador2, jugador1));
		
	}
	
	private void setBoton(String ruta, EventHandler<ActionEvent> event) {
		
		this.soundBoton.play();

		
		HBox hb = new HBox();
		
		Button boton=new Button("");
		boton.setOnAction(event);
		
		boton.setBackground(Background.EMPTY);
		Image image=new Image(ruta,300,150,true,true);
		boton.setGraphic(new ImageView(image));
		
		hb.getChildren().addAll(boton);
		hb.setAlignment(Pos.BOTTOM_CENTER);
		
		this.box.getChildren().add(hb);
	}
	public void contenedorJugador(VistaJugador jugador) {
		DatosJugador datos = new DatosJugador(jugador);
		jugador.setContenedor(datos);
		this.box.getChildren().add(datos);
		
	}
}
