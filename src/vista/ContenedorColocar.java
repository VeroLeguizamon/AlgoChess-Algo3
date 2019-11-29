package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

public class ContenedorColocar extends HBox{
	private static final String RUTA_FONDO="file:src/vista/imagenes/fondoTienda.png";
	public final Stage stage;	
	
	private VBox vBox = new VBox(20);
	private HBox hBox = new HBox(0);
	
	private Juego juego;
	private VistaTablero vTablero;
	private VistaUnidad seleccionado;
	private VistaCelda celdaS;
	
	public ContenedorColocar(Stage stage, Jugador jugador1, Jugador jugador2) {
		this.stage = stage;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
	    this.setPadding(new Insets(25));
	    this.hBox.setAlignment(Pos.CENTER_RIGHT);
	    this.juego = new Juego(jugador1, jugador2);
	    this.vTablero = new VistaTablero(juego.getTablero(),this);
	    
	    this.seleccionado = null;
        this.celdaS = null;
        
	    Image fondoBienvenida= new Image(RUTA_FONDO,1100,650,false,true);
        BackgroundImage mostrarFondoBienvenida=new BackgroundImage(fondoBienvenida, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
                
        this.vBox.getChildren().add(vTablero);
        this.getChildren().add(vBox);   
        
        colocarUnidades(hBox,jugador1);
        
        this.setBackground(new Background(mostrarFondoBienvenida));
        
	}
	
	public void colocarUnidades(HBox hBox, Jugador jugador) {
		 
		VBox b = new VBox(20);
		
		ContenedorUnidadesColocar unidades = new ContenedorUnidadesColocar(this.vTablero,jugador.getUnidades(),this);
		
		Label label = new Label();
		label.setText("Colocando: ");
		label.setStyle("-fx-font-family:arial; -fx-font-size:20;");
		label.setTextFill(Color.web("#fff"));
	    Label labelNombre = new Label();
	    label.setText(jugador.getNombre());
	    label.setStyle("-fx-font-family:arial; -fx-font-size:20;");
	    
	    b.getChildren().add(label);
	    b.getChildren().add(labelNombre);
	    this.getChildren().add(unidades);
	    this.getChildren().add(b);

	}
	public boolean hayUnidadSeleccionada() {
		return this.seleccionado != null;
	}
	public void setUnidadSeleccionada(VistaUnidad unidad) {
		this.seleccionado = unidad;
	}
	public VistaUnidad getUnidadSeleccionada() {
		return this.seleccionado;
	}
	public void resetSeleccionado() {
		this.seleccionado.setStyle("-fx-background-color:#000;");
		this.seleccionado.setOnAction(null);
		this.seleccionado = null;
	}
}