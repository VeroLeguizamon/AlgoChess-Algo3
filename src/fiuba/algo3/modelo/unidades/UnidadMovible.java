package fiuba.algo3.modelo.unidades;

import tp2java_v1.tablero.Coordenada;
import tp2java_v1.tablero.Tablero;
import fiuba.algo3.modelo.excepciones.*;

public class UnidadMovible extends Unidad {
	
	private Tablero tablero;
	
	public void moverA(Coordenada coord) throws MovimientoInvalido{
		
		boolean exito = false;
		
		try {
			tablero.moverUnidad(this, coord);
			exito = true;
		} catch(MovimientoInvalido e) {
			throw e;
		}
		if(exito) {
			setUbicacion(coord);
		}
		
	}
	
	public void moverHaciaArriba() throws MovimientoInvalido{
		
		try {
			moverA(new Coordenada(getUbicacion().getCoordx() , getUbicacion().getCoordy() + 1));
		} catch(MovimientoInvalido e) {
			throw e;
		}
		
	}
	
	public void moverHaciaAbajo() throws MovimientoInvalido{
		
		try {
			moverA(new Coordenada(getUbicacion().getCoordx() , getUbicacion().getCoordy() - 1));
		} catch(MovimientoInvalido e) {
			throw e;
		}
		
	}
	
	public void moverHaciaLaDerecha() throws MovimientoInvalido{
		
		try {
			moverA(new Coordenada(getUbicacion().getCoordx() + 1, getUbicacion().getCoordy()));
		} catch(MovimientoInvalido e) {
			throw e;
		}
		
	}
	
	public void moverHaciaLaIzquierda() throws MovimientoInvalido{
		
		try {
			moverA(new Coordenada(getUbicacion().getCoordx() - 1, getUbicacion().getCoordy()));
		} catch(MovimientoInvalido e) {
			throw e;
		}
		
	}

	public void moverEnDiagonalArribaDerecha() throws MovimientoInvalido{
		
		try {
			moverA(new Coordenada(getUbicacion().getCoordx() + 1, getUbicacion().getCoordy() + 1));
		} catch(MovimientoInvalido e) {
			throw e;
		}
		
	}
	
	public void moverEnDiagonalArribaIzquierda() throws MovimientoInvalido{
		
		try {
			moverA(new Coordenada(getUbicacion().getCoordx() - 1, getUbicacion().getCoordy() + 1));
		} catch(MovimientoInvalido e) {
			throw e;
		}
		
	}
	
	public void moverEnDiagonalAbajoDerecha() throws MovimientoInvalido{
		
		try {
			moverA(new Coordenada(getUbicacion().getCoordx() + 1, getUbicacion().getCoordy() - 1));
		} catch(MovimientoInvalido e) {
			throw e;
		}
		
	}
	
	public void moverEnDiagonalAbajoIzquierda() throws MovimientoInvalido{
		
		try {
			moverA(new Coordenada(getUbicacion().getCoordx() - 1, getUbicacion().getCoordy() - 1));
		} catch(MovimientoInvalido e) {
			throw e;
		}
		
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;		
	}


	
	
}
