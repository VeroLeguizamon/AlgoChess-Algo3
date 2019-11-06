package tp2java.modelo.unidades;

import tp2java.excepciones.MovimientoInvalido;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;

public class UnidadMovible extends Unidad {
	
	private Tablero tablero;
	
	public UnidadMovible() {
		
		super();
		
	}
	
	public UnidadMovible(int vida, int costo, int jugador, Coordenada ubicacion, Tablero tablero) {
		
		super(vida, costo, jugador, ubicacion);
		this.tablero = tablero;
		
	}
	
	public void moverA(Coordenada coord) throws MovimientoInvalido{
		
		boolean exito = false;
		
		try {
			tablero.moverEntidad(this, coord);
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
