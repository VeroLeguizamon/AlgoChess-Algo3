package fiuba.algo3.modelo.unidades;

import tp2java_v1.tablero.Coordenada;

public class Unidad {
	
	private int costo; 
	// Costo al comprar la Unidad.
	private int vida; 
	// Puntos de vida de la Unidad.
	private int penalizador; 
	// Porcentaje de penalizacion al recibir daño.
	private int jugador;
	// Jugador al que pertenece. 1 = Jugador1, 2 = Jugador2.
	private Coordenada ubicacion;
	// Ubicación en el tablero.
	
	public Unidad() {
		
		this.penalizador = 0;
		
	}
	
	public Unidad(int vida, int costo, int jugador) {
		
		this.vida = vida;
		this.costo = costo;
		this.jugador = jugador;
		this.penalizador = 0;
		
	}
	
	public void setPenalizador(int pen) {
		penalizador = pen;
	}
	
	public void perderVida(int puntosAPerder) {
		
		this.vida -= (puntosAPerder + (((puntosAPerder * penalizador) / 100)));

	}
	
	public void setUbicacion(Coordenada coordenadas){
		this.ubicacion = coordenadas;
	}
	
	public Coordenada getUbicacion(){
		return ubicacion;
	}
	
	
	public boolean tieneVida() {
		return (vida > 0);
	}
	
	public int getVida() {
		return vida;
	}

	public int getCosto() {		
		return costo;
	}
	
	public int getJugador() {
		return jugador;
	}
	
	public int restarPuntos(int puntosDelJugador) {
		return (puntosDelJugador - this.costo);
	}
	
	
	
}
	
