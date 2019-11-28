package vista;
import controladores.SiguienteJugadorEventHandler;
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
	private VistaJugador jugador = new VistaJugador(new Jugador("player 1"));
	public final Stage stage;
	private VBox box = new VBox(20);
	
	private Button boton;
	
	public ContenedorCompra(Stage stage) {
		this.stage = stage;
		this.setAlignment(Pos.CENTER);
		 this.setSpacing(20);
	     this.setPadding(new Insets(25));
	        
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
        
        this.contenedorJugador(jugador);
        ContenedorUnidades unidades = new ContenedorUnidades(jugador.getJugador());
        
        this.box.getChildren().add(unidades);
        this.getChildren().add(box);
        
        this.setBackground(new Background(mostrarFondoBienvenida));        
	}
	
	public void setBotonSiguiente() {
		this.setBoton(RUTA_SIGUIENTE, new SiguienteJugadorEventHandler(this.stage));
	}
	
	public void setBotonTerminar() {
		this.setBoton(RUTA_TERMINAR, new TerminarCompraEventHandler(this.stage));
	}
	
	private void setBoton(String ruta, EventHandler<ActionEvent> event) {
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
	public void deshabilitarBoton(){

		this.boton.setVisible(false);
		this.boton.setDisable(true);
	}
	public void habilitarBoton() {
		this.boton.setVisible(true);
		this.boton.setDisable(false);
	}
}
