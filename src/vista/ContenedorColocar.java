package vista;

//import controladores.SiguienteJugadorColocarEventHandler;
import controladores.SiguienteJugadorCompraEventHandler;
//import controladores.TerminarColocarEventHander;
import controladores.TerminarCompraEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;

public class ContenedorColocar extends HBox{
	private static final String RUTA_FONDO="file:src/vista/imagenes/fondoTienda.png";
	private static final String RUTA_SIGUIENTE="file:src/vista/imagenes/siguiente.png";
	private static final String RUTA_TERMINAR="file:src/vista/imagenes/terminar.png";

	public final Stage stage;	
	
	private VBox vBox = new VBox(20);
	private HBox hBox = new HBox(0);
	
	
	private VistaTablero vTablero;
	private VistaUnidad seleccionado;
	
	public ContenedorColocar(Stage stage, Jugador jugador1, Jugador jugador2,Juego juego) {
		this.stage = stage;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
	    this.setPadding(new Insets(25));
//	    this.hBox.setAlignment(Pos.CENTER_RIGHT);
	    this.vTablero = new VistaTablero(juego.getTablero(),this);
	    
	    this.seleccionado = null;
        
	    Image fondoBienvenida= new Image(RUTA_FONDO,1100,650,false,true);
        BackgroundImage mostrarFondoBienvenida=new BackgroundImage(fondoBienvenida, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
                
        this.colocarUnidades(jugador1);
        
        this.vBox.getChildren().add(vTablero);
        this.getChildren().add(vBox);         
        this.colocarUnidades(jugador2);
        
        this.setBackground(new Background(mostrarFondoBienvenida));
        
	}
	
	public void colocarUnidades(Jugador jugador) {
		 
		VBox b = new VBox(20);
		
		ContenedorUnidadesColocar unidades = new ContenedorUnidadesColocar(this.vTablero,jugador.getUnidades(),this);
		
		Label label = new Label();
		label.setText("Colocando: \r\n"+jugador.getNombre());
	    label.setStyle("-fx-font-family:arial; -fx-font-size:20px;");
	    label.setTextFill(Color.web("#fff"));
	    label.setTextAlignment(TextAlignment.CENTER);
	    
	    System.out.println(jugador.cantidadDeUnidades());
	    
	    b.getChildren().add(label);
	    b.getChildren().add(unidades);
	    this.getChildren().add(b);

	}
	public boolean hayUnidadSeleccionada() {
		return this.seleccionado != null;
	}
	public void setUnidadSeleccionada(VistaUnidad unidad) {
		this.seleccionado = unidad;
		this.seleccionado.setStyle("-fx-border-size:1px;"+
				"-fx-border-color:#888;"+
				"-fx-border-style:solid;");
	}
	public VistaUnidad getUnidadSeleccionada() {
		return this.seleccionado;
	}
	public void resetSeleccionado() {
		this.seleccionado.setStyle("-fx-opacity:0;");
		this.seleccionado.setOnAction(null);
		this.seleccionado = null;
	}

//	public void setBotonSiguiente(Jugador jugadorSiguiente, Jugador jugadorEnEspera, Juego juego) {
//		this.setBoton(RUTA_SIGUIENTE, new SiguienteJugadorColocarEventHandler(this.stage,jugadorSiguiente,jugadorEnEspera,juego));
//	}
//	public void setBotonTerminar(Jugador jugador1, Jugador jugador2, Juego juego) {
//		this.setBoton(RUTA_TERMINAR, new TerminarColocarEventHander(this.stage, jugador2, jugador1,juego));
//	}
	private void setBoton(String ruta, EventHandler<ActionEvent> event) {
		HBox hb = new HBox();
		
		Button boton=new Button("");
		boton.setOnAction(event);
		
		boton.setBackground(Background.EMPTY);
		Image image=new Image(ruta,150,30,true,true);
		boton.setGraphic(new ImageView(image));
		
		hb.getChildren().addAll(boton);
		hb.setAlignment(Pos.BOTTOM_CENTER);
		
		this.getChildren().add(hb);
	}
}