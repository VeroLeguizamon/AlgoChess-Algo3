package controladores;

import java.util.Queue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2java.modelo.tablero.Direccion;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Batallon;
import tp2java.modelo.unidades.Unidad;
import tp2java.modelo.unidades.UnidadMovible;
import vista.ContenedorJuego;
import vista.VistaCelda;

public class MoverUnidadEventHandler implements EventHandler<ActionEvent>{
	
	private VistaCelda vistaCelda;
	private ContenedorJuego contenedorJuego;
	private Direccion direccion;
	
	public MoverUnidadEventHandler(VistaCelda seleccionada, ContenedorJuego contenedorJuego, Direccion direccion) {
		
		this.vistaCelda = seleccionada;
		this.contenedorJuego=contenedorJuego;
		this.direccion=direccion;
		
	}
		
	@Override
	public void handle(ActionEvent event) {
		Unidad unidad=vistaCelda.getVistaUnidad().getUnidad();
		Tablero tablero=contenedorJuego.getJuego().getTablero();
		Batallon batallon = new Batallon();
		
		if(batallon.existeBatallon(unidad)) {
			batallon.mover(direccion);
			this.contenedorJuego.getVistaTablero().actualizarTablero(tablero);

		} else {
			if(tablero.sePuedeMoverUnidad(direccion.calcularCoordenada(unidad.getUbicacion()))) {
				contenedorJuego.getVistaTablero().quitarVista(unidad.getUbicacion().getCoordx(), unidad.getUbicacion().getCoordy());
				((UnidadMovible)unidad).mover(direccion);
			}
		}

		contenedorJuego.resetSeleccionado();
		contenedorJuego.quitarBotonesMovimiento();
		
		
		}
		
	}
