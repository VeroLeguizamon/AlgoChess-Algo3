package vista;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Unidad;

public class VistaTablero extends Group {
	
	public double ancho;
    public double alto;
    private double anchoCelda = 32;
    private double altoCelda = 32;
    private Tablero tableroM;
    private ContenedorConTablero juego;

    private GridPane tablero;
    private VistaCelda[][] paneles;
	
	public VistaTablero(Tablero tableroM, ContenedorConTablero juego) {
        tablero = new GridPane();
        ancho = anchoCelda * 20;
        alto = altoCelda * 20;
        this.tableroM = tableroM;
        this.juego = juego;
        paneles = new VistaCelda[ (int)ancho][(int)alto];
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                VistaCelda v = new VistaCelda(i,j,anchoCelda,altoCelda,tableroM, juego);
                
                if (i>9) {
                	v.setStyle("-fx-border-style:solid; -fx-border-color:blue;-fx-border-size:1px;");                    
                }
                paneles[i][j] = v;                
                tablero.add(v, i, j);
            }
        }
        this.agregarVista(tablero);
    }

    public void colocarVista(VistaUnidad view, int x, int y) {
    	
    	try {
    		VistaCelda vista = paneles[x][y];
    		vista.colocarUnidad(view);
    	} catch (Exception e) {
    		//TODO: Tratar Excepcion
    	}
    }
    
    public void dibujarUnidades(Tablero tablero) {
    	for(Unidad unidad : tablero.getUnidades()){
    		colocarVista(new VistaUnidad(this,unidad), unidad.getUbicacion().getCoordx(), unidad.getUbicacion().getCoordy());
    	}
    	
    }
    
    public void actualizarTablero(Tablero tablero) {
    	for (int i = 0; i < 20; i++) {
    		for (int j = 0; j < 20; j++) {
    			paneles[i][j].setBackground(Background.EMPTY);
    			paneles[i][j].setText("");
    		}
    	}
    	dibujarUnidades(tablero);
    }

    public void agregarVista(Node view) {
        this.getChildren().add(view);
    }

    public void actualizarVista(Node view) {
		getChildren().remove(view);
		getChildren().add(view);
    }
    
}