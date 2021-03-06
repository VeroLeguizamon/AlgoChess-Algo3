package vista;

import controladores.ResolverInteraccionesEventHandler;
import controladores.TerminarTurnoEventHander;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Tablero;

public class ContenedorJuego extends HBox implements ContenedorConTablero{
	private static final String RUTA_FONDO="file:src/vista/imagenes/fondoTienda.png";
	private static final String RUTA_TERMINAR="file:src/vista/imagenes/terminar.png";
	
	private static final String RUTA_ESCENAJUEGO="src/vista/sonidos/escenaJuego.mp3";
	private Sound sound=new Sound(RUTA_ESCENAJUEGO);


	public final Stage stage;	
	
	private VBox vBox = new VBox(20);
	private HBox hBox = new HBox(0);
	
	private VistaTablero vTablero;
	private VistaUnidad seleccionado;
	
	private ContenedorMovimientos contMov;
	
	private Juego juego;	
	private Jugador jugadorActual;
	
	private Label jugadorEnTurno;
	private HBox hb = new HBox();
	private VBox vb = new VBox(20);
	
	public ContenedorJuego(Stage stage, Jugador jugador1, Jugador jugador2,Juego juego) {
		
		this.sound.Nostop();
		this.stage = stage;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
	    this.setPadding(new Insets(25));
	    this.hBox.setAlignment(Pos.CENTER_RIGHT);
	    this.vTablero = new VistaTablero(juego.getTablero(),this);
	    this.juego = juego;
	    this.jugadorActual = juego.getjugadorEnTurno();
	    
	    this.seleccionado = null;
        
	    vTablero.dibujarUnidades(juego.getTablero());
	    
	    Image fondoBienvenida= new Image(RUTA_FONDO,1100,650,false,true);
        BackgroundImage mostrarFondoBienvenida=new BackgroundImage(fondoBienvenida, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
           
        jugadorEnTurno = new Label();
        jugadorEnTurno.setText("Turno de \r\n"+jugadorActual.getNombre());
        jugadorEnTurno.setStyle("-fx-font-family:arial; -fx-font-size:20px;");
        jugadorEnTurno.setTextFill(Color.web("#fff"));
        jugadorEnTurno.setTextAlignment(TextAlignment.CENTER);
        jugadorEnTurno.setAlignment(Pos.TOP_CENTER);
	    
       
        this.getChildren().add(jugadorEnTurno);
        this.vBox.getChildren().add(vTablero);
        this.getChildren().add(vBox);
		this.hb.setAlignment(Pos.TOP_CENTER);
        this.vb.getChildren().add(hb);
        this.getChildren().add(vb);
        
        this.setBotonTerminarTurno();
        
        this.setBackground(new Background(mostrarFondoBienvenida));
        
	}
	
	@Override
	public boolean hayUnidadSeleccionada() {
		return this.seleccionado != null;
	}
	
	@Override
	public void setUnidadSeleccionada(VistaUnidad unidad) {
		this.seleccionado = unidad;
		this.seleccionado.setStyle("-fx-border-size:1px;"+
				"-fx-border-color:#888;"+
				"-fx-border-style:solid;");
	}
	
	@Override
	public VistaUnidad getUnidadSeleccionada() {
		return this.seleccionado;
	}
	
	@Override
	public void resetSeleccionado() {
		this.seleccionado.setStyle("-fx-opacity:0;");
		this.seleccionado.setOnAction(null);
		this.seleccionado = null;
	}

	public void setBotonTerminarTurno() {
		this.setBoton(RUTA_TERMINAR, new TerminarTurnoEventHander(this, juego, sound));
	}
	
	public void quitarBotonTerminarTurno() {
		this.getChildren().remove(hb);
	}
	
	private void setBoton(String ruta, EventHandler<ActionEvent> event) {
		
		Button boton=new Button("");
		boton.setOnAction(event);
		
		boton.setBackground(Background.EMPTY);
		Image image=new Image(ruta,150,30,true,true);
		boton.setGraphic(new ImageView(image));
		
		vb.getChildren().addAll(boton);
		vb.setAlignment(Pos.BOTTOM_CENTER);
		
	}
	

	@Override
	public void definirAccionDeCelda(VistaCelda vistaCelda, Tablero tablero, int x, int y) {

		vistaCelda.setOnAction(new ResolverInteraccionesEventHandler(vistaCelda,tablero, this, x,y));
		
	}


	public void prepararMovimiento(VistaCelda vistaCelda) {
		
		ContenedorMovimientos botonesMov=new ContenedorMovimientos(this,vistaCelda);
        this.contMov=botonesMov;
        this.hb.getChildren().add(botonesMov);
        
	}
	
	@Override
	public VistaTablero getVistaTablero() {
		return vTablero;
	}
	
	public Jugador getJugadorEnTurno() {
		return jugadorActual;
	}
		
	public Juego getJuego() {
		return juego;
	}

	public void siguienteTurno() {
		juego.siguienteTurno();
		this.jugadorActual = juego.getjugadorEnTurno();
		jugadorEnTurno.setText("Turno de \r\n"+jugadorActual.getNombre());
	}

	public void quitarBotonesMovimiento() {
		this.hb.getChildren().remove(contMov);	
	}
	public boolean esLaMismaUnidadSeleccionada(VistaCelda vistaCelda) {
		return vistaCelda.mismaUnidad(this.seleccionado);
	}
}