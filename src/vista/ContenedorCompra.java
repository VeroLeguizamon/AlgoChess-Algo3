package vista;
import controladores.SiguienteJugadorEventHandler;
import controladores.TerminarCompraEventHandler;
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
	
	public final Stage stage;
	public VBox box = new VBox(70);
	
	public ContenedorCompra(Stage stage) {
		this.stage = stage;
		this.setAlignment(Pos.CENTER);
		 this.setSpacing(20);
	     this.setPadding(new Insets(25));
	        
        Image fondoBienvenida= new Image(RUTA_FONDO,1100,650,false,true);
        BackgroundImage mostrarFondoBienvenida=new BackgroundImage(fondoBienvenida, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        //Jugador no debe estar asi, debe venir por parametro, cambiarlo!!!
        Jugador jugador = new Jugador("player1");
        
        this.contenedorJugador(jugador.getNombre(),jugador.getPuntos());
        ContenedorUnidades unidades = new ContenedorUnidades(jugador);
        
        this.box.getChildren().add(unidades);
        this.getChildren().add(box);
        
        this.setBackground(new Background(mostrarFondoBienvenida));        
	}
	
	public void setBotonSiguiente() {
		HBox hb = new HBox();
		Button botonSiguiente=new Button("");
		SiguienteJugadorEventHandler evento = new SiguienteJugadorEventHandler(this.stage);
		
		botonSiguiente.setOnAction(evento);
		botonSiguiente.setBackground(Background.EMPTY);
		Image imagenSiguiente=new Image(RUTA_SIGUIENTE,300,150,true,true);
		botonSiguiente.setGraphic(new ImageView(imagenSiguiente));
		
		hb.getChildren().addAll(botonSiguiente);
		hb.setAlignment(Pos.BOTTOM_CENTER);
		
		this.box.getChildren().add(hb);
	}
	
	public void setBotonTerminar() {
		HBox hb = new HBox();
		Button botonSiguiente=new Button("");
		TerminarCompraEventHandler evento = new TerminarCompraEventHandler(this.stage);
		
		botonSiguiente.setOnAction(evento);
		botonSiguiente.setBackground(Background.EMPTY);
		Image imagenSiguiente=new Image(RUTA_TERMINAR,300,150,true,true);
		botonSiguiente.setGraphic(new ImageView(imagenSiguiente));
		
		hb.getChildren().addAll(botonSiguiente);
		hb.setAlignment(Pos.BOTTOM_CENTER);
		
		this.box.getChildren().add(hb);
	}

	public void contenedorJugador(String nombre, int puntos) {
		HBox hb = new HBox();
		
		Image titulo=new Image(RUTA_TITULO,450,200,true,true);
        ImageView vistaTitulo=new ImageView(titulo);
        
        hb.getChildren().add(vistaTitulo);
		hb.setMinHeight(100);
		hb.setMinWidth(70);
		hb.setPadding(Insets.EMPTY);
		hb.setAlignment(Pos.TOP_CENTER);

		
		this.box.getChildren().add(hb);
		
	}
}
