package tp2java.modelo.unidades;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Direccion;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;

public class UnidadMovible extends Unidad {

	public UnidadMovible() {
		super();
	}
	public UnidadMovible(int vida, int costo) {
		super(vida,costo);
	}
	
	public UnidadMovible(int vida, int costo, Jugador jugador) {
		super(vida,costo,jugador);
	}
	
	public UnidadMovible(int vida, int costo, Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		super(vida, costo, jugador, ubicacion, tablero);
	}
	
	public void mover(Direccion direccion) {
		Coordenada nueva = direccion.calcularCoordenada(this.getUbicacion());
		if (this.getTablero().sePuedeMoverUnidad(nueva)) this.setUbicacion(nueva);
	}
	
}
