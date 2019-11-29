package vista;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import tp2java.modelo.tablero.Tablero;

public class VistaTablero extends Group {
	
	public double ancho;
    public double alto;
    private double anchoCelda = 32;
    private double altoCelda = 32;

    private GridPane tablero;
    private VistaCelda[][] paneles;
	
	public VistaTablero(Tablero tableroM, ContenedorColocar juego) {
        tablero = new GridPane();
        ancho = anchoCelda * 20;
        alto = altoCelda * 20;
        paneles = new VistaCelda[ (int)ancho][(int)alto];
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                VistaCelda v = new VistaCelda(i,j,anchoCelda,altoCelda,tableroM, juego);
                
                if (i>10) {
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

    public void agregarVista(Node view) {
        this.getChildren().add(view);
    }

    public void actualizarVista(Node view) {
		getChildren().remove(view);
		getChildren().add(view);
    }
    
}