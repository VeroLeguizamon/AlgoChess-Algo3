package vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import tp2java.modelo.unidades.Unidad;

public class VistaUnidad extends Button{
	private Unidad unidad;
	
	public VistaUnidad(String rutaImagen, Unidad unidadModelo) {
		
		super();
		this.unidad = unidadModelo;
		
		String string ="-fx-border-style:solid;" + 
				"-fx-border-color:#C89B70;" + 
				"-fx-border-width:1px;";
		Image unidad= new Image(rutaImagen,150,200,false,true);
        BackgroundImage vistaUnidad =new BackgroundImage(unidad, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        this.setBackground(new Background(vistaUnidad));
        this.setStyle(string);
        this.setMinHeight(200);
        this.setMinWidth(150);
        
	}
	public Unidad obtenerNuevaUnidad() {
		return this.unidad.crearUnidad();
	}
}
