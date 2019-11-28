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
	private HBox hBox = new HBox(20);
	private Juego juego;
	private VistaTablero vTablero;
	
	public ContenedorJuego(Stage stage, Jugador jugador1, Jugador jugador2) {
		//Recibe jugadores
		this.stage = stage;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
	    this.setPadding(new Insets(25));
	    this.hBox.setAlignment(Pos.CENTER_RIGHT);
	    this.vTablero = new VistaTablero(RUTA_TABLERO);
	    this.juego = new Juego(jugador1, jugador2);
	       
        Image fondoBienvenida= new Image(RUTA_FONDO,1100,650,false,true);
        BackgroundImage mostrarFondoBienvenida=new BackgroundImage(fondoBienvenida, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
                
        this.vBox.getChildren().add(vTablero);
        this.getChildren().add(vBox);
        this.getChildren().add(hBox);     
        
        colocarUnidades(hBox,jugador1);
        colocarUnidades(hBox,jugador2);
        
        this.setBackground(new Background(mostrarFondoBienvenida));
        
	}
	
	public void colocarUnidades(HBox hBox, Jugador jugador) {
		 
		VBox vb = new VBox(20);
		ArrayList<Unidad> unidades = jugador.getUnidades();
		
		Label label = new Label();
		label.setText("Colocando:");
		label.setStyle("-fx-font-family:arial; -fx-font-size:20;");
		label.setTextFill(Color.web("#fff"));
	        
	    vb.getChildren().add(label);
	    hBox.getChildren().add(vb);
	    
	    int i = 1;
	    
	    for(Unidad unidad : unidades) {
	    	unidad.setTablero(juego.getTablero());
	    	unidad.setUbicacion(new Coordenada(i,i));
	    	new VistaUnidad(vTablero,unidad);
	    	i++;
	    }// Buscar la manera de poder seleccionar la coordenada desde el tablero.
        
	    hBox.getChildren().clear();
		    
	}
        
	
}