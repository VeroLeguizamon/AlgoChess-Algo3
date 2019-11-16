package tp2java.modelo.unidades;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;

public class UnidadMovible extends Unidad {
	
	private Tablero tablero;
	
	public UnidadMovible() {
		super();	
	}
	
	public UnidadMovible(int vida, int costo, Coordenada ubicacion, Tablero tablero) {
		super(vida, costo, ubicacion);
		this.tablero = tablero;
	}
	
	// Si no se puede mover, se queda en la misma posicion
	// MoverA no deberia ser un metodo privado?
	public void moverA(Coordenada coord){
		if (this.tablero.sePuedeMoverUnidad(coord)) this.setUbicacion(coord);
	}
	
	public void moverHaciaArriba(){
		this.moverA(this.getUbicacion().getCoordenadaArriba());
	}
	
	public void moverHaciaAbajo(){
		this.moverA(this.getUbicacion().getCoordenadaAbajo());
		
	}
	
	public void moverHaciaLaDerecha(){
		this.moverA(this.getUbicacion().getCoordenadaDerecha());
	}
	
	public void moverHaciaLaIzquierda(){
		this.moverA(this.getUbicacion().getCoordenadaIzquierda());
	}

	public void moverEnDiagonalArribaDerecha(){
		this.moverA(this.getUbicacion().getCoordenadaDiagonalArribaDerecha());
	}
	
	public void moverEnDiagonalArribaIzquierda(){
		this.moverA(this.getUbicacion().getCoordenadaDiagonalArribaIzquierda());
	}
	
	public void moverEnDiagonalAbajoDerecha(){
		this.moverA(this.getUbicacion().getCoordenadaDiagonalAbajoDerecha());
	}
	
	public void moverEnDiagonalAbajoIzquierda(){
		this.moverA(this.getUbicacion().getCoordenadaDiagonalAbajoIzquierda());
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;		
	}
	
}
