package vista;

import java.util.ArrayList;

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
import javafx.stage.Stage;
import tp2java.modelo.Juego;
import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.*;

public class ContenedorJuego extends HBox{
	private static final String RUTA_FONDO="file:src/vista/imagenes/fondoTienda.png";
	private static final String RUTA_TABLERO="file:src/vista/imagenes/tablero.jpg";	
	public final Stage stage;	
	private VBox vBox = new VBox(20);
	private HBox hBox = new HBox(0);
	private Juego juego;
	private VistaTablero vTablero;
	private Tablero tab;
	private VistaUnidad seleccionado;
	private VistaCelda celdaS;
	
	public ContenedorJuego(Stage stage, Jugador jugador1, Jugador jugador2) {
		//Recibe jugadores
		this.stage = stage;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
	    this.setPadding(new Insets(25));
	    this.hBox.setAlignment(Pos.CENTER_RIGHT);
	    this.juego = new Juego(jugador1, jugador2);

	    this.tab = juego.getTablero();
	    this.vTablero = new VistaTablero(tab,this);
	    
	    this.seleccionado = null;
        this.celdaS = null;
        
	    Image fondoBienvenida= new Image(RUTA_FONDO,1100,650,false,true);
        BackgroundImage mostrarFondoBienvenida=new BackgroundImage(fondoBienvenida, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
                
        this.vBox.getChildren().add(vTablero);
        this.getChildren().add(vBox);
        //this.getChildren().add(hBox);     
        
        colocarUnidades(hBox,jugador1);
       // colocarUnidades(hBox,jugador2);
        
        this.setBackground(new Background(mostrarFondoBienvenida));
        
	}
	
	public void colocarUnidades(HBox hBox, Jugador jugador) {
		 
		HBox b = new HBox(20);
		
		ContenedorUnidadesColocar unidades = new ContenedorUnidadesColocar(this.vTablero,jugador.getUnidades(),this);
		
		Label label = new Label();
		label.setText("Colocando: " + jugador.getNombre());
		label.setStyle("-fx-font-family:arial; -fx-font-size:20;");
		label.setTextFill(Color.web("#fff"));
	        
	    b.getChildren().add(label);
	    this.getChildren().add(unidades);
	    this.getChildren().add(b);

	}
	
	public void colocar(VistaCelda celda) {
		Unidad unidad = this.getUnidadSeleccionada();
		
		unidad.setTablero(tab);
		unidad.setUbicacion(new Coordenada(this.celdaS.getX(),this.celdaS.getY()));
		
		tab.colocarUnidad(unidad);
		
		System.out.println(unidad.getUbicacion().getCoordx() + unidad.getUbicacion().getCoordy());
	}
	
	public boolean hayCeldaSeleccionada() {
		return this.celdaS != null;
	}
	public void setCeldaSeleccionada(VistaCelda celda) {
		this.celdaS = celda;
	}
	public void resetCelda() {
		this.celdaS=null;
	}
	public boolean hayUnidadSeleccionada() {
		return this.seleccionado != null;
	}
	public void setUnidadSeleccionada(VistaUnidad unidad) {
		this.seleccionado = unidad;
	}
	public Unidad getUnidadSeleccionada() {
		return this.seleccionado.getUnidad();
	}
	public void resetSeleccionado() {
		this.seleccionado = null;
	}
}