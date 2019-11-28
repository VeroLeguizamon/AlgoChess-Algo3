package vista;

import controladores.ColocarUnidadEventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import tp2java.modelo.unidades.Unidad;

public class VistaTablero extends Group {
	
	public double ancho;
    public double alto;
    private double anchoCelda = 32;
    private double altoCelda = 32;

    private GridPane tablero;

    private Pane[][] paneles;
	
	public VistaTablero(String rutaImagen) {
	
        tablero = new GridPane();
        ancho = anchoCelda * 20;
        alto = altoCelda * 20;
        paneles = new Pane[ (int)ancho][(int)alto];
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Pane v = new Pane();
                v.setMinHeight(this.altoCelda);
                v.setMinWidth(this.anchoCelda);
                paneles[i][j] = v;
                tablero.add(v, i, j);
            }
        }
        
        Background bi = new Background(new BackgroundImage(new Image(rutaImagen),
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        new BackgroundSize(this.ancho, this.alto, false, false, false, false)));
        tablero.setBackground(bi);

        this.agregarVista(tablero);
    }

    public void agregarVistaAlMapa(Node view, int x, int y) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                try {
                    paneles[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: manejar excepcion.
                }
            }
        }
        paneles[x-1][y-1].getChildren().add(0, view);
    }

    public void agregarVista(Node view) {
        this.getChildren().add(view);
    }

    public void actualizarVista(Node view) {
		getChildren().remove(view);
		getChildren().add(view);
    }
    
}