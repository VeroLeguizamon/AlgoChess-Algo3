package vista;

import controladores.ColocarUnidadTableroEventHandler;
import controladores.ResolverInteraccionesEventHandler;
import controladores.SiguienteJugadorCompraEventHandler;
import controladores.TerminarColocarEventHander;
import controladores.TerminarCompraEventHandler;
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
	private static final String RUTA_SIGUIENTE="file:src/vista/imagenes/siguiente.png";
	private static final String RUTA_TERMINAR="file:src/vista/imagenes/terminar.png";

	public final Stage stage;	
	
	private VBox vBox = new VBox(20);
	private HBox hBox = new HBox(0);
	
	private VistaTablero vTablero;
	private VistaUnidad seleccionado;
	
	private Jugador jugadorActual;
	private Juego juego;
	
	private Label jugadorEnTurno;
	private HBox hb;
	
	public ContenedorJuego(Stage stage, Jugador jugador1, Jugador jugador2,Juego juego) {
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
        jugadorEnTurno.setAlignment(Pos.TOP_LEFT);
	    
        this.vBox.getChildren().add(vTablero);
        this.getChildren().add(vBox);
        this.getChildren().add(jugadorEnTurno);
        
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
		this.setBoton(RUTA_TERMINAR, new TerminarTurnoEventHander(this, juego));
	}
	
	public void quitarBotonTerminarTurno() {
		this.getChildren().remove(hb);
	}
	
	private void setBoton(String ruta, EventHandler<ActionEvent> event) {
		
		hb = new HBox();
		
		Button boton=new Button("");
		boton.setOnAction(event);
		
		boton.setBackground(Background.EMPTY);
		Image image=new Image(ruta,150,30,true,true);
		boton.setGraphic(new ImageView(image));
		
		hb.getChildren().addAll(boton);
		hb.setAlignment(Pos.BOTTOM_CENTER);
		
		this.getChildren().add(hb);
	}
	

	@Override
	public void definirAccionDeCelda(VistaCelda vistaCelda, Tablero tablero, int x, int y) {

		vistaCelda.setOnAction(new ResolverInteraccionesEventHandler(vistaCelda,tablero, this, x,y));
		
	}

	public void prepararMovimiento(VistaCelda vistaCelda) {
		
		// Mostrar flechas en las direcciones, que sean botones para realizar los movimientos.
		// (cada una mueva en una Direccion diferente)
		
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
	
}