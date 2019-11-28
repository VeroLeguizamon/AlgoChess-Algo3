package vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import tp2java.modelo.Observer;
import tp2java.modelo.unidades.Unidad;

public class VistaUnidad extends Button implements Observer{
	
	private Unidad unidad;
	private VistaTablero tablero;
	private String rutaImagen;
	
	public VistaUnidad(VistaTablero tablero, Unidad unidad) {
		
		super();
		this.unidad = unidad;
		rutaImagen = ("file:src/vista/imagenes/" + unidad.getClass().getSimpleName() + ".png");
		Image unidadImagen = new Image(rutaImagen,32,32,false,true);
        BackgroundImage vistaUnidad =new BackgroundImage(unidadImagen, BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        this.setBackground(new Background(vistaUnidad));
        this.setMinHeight(32);
        this.setMinWidth(32);
        tablero.agregarVistaAlMapa(this, unidad.getUbicacion().getCoordx(), unidad.getUbicacion().getCoordy());
        
	}
	
	public String getRutaImagen() {
		return rutaImagen;
	}
	
	@Override
	public void change() {
		 tablero.agregarVistaAlMapa(this, unidad.getUbicacion().getCoordx(), unidad.getUbicacion().getCoordy());
	}
	
}
