package fiuba.algo3.modelo.unidades;

import tp2java_v1.tablero.Coordenada;

public class Unidad {
	
	private int costo; 
	// Costo al comprar la Unidad.
	private int vida; 
	// Puntos de vida de la Unidad.
	private int penalizador; 
	// Porcentaje de penalizacion al recibir daño.
	private Coordenada coordenadas;
	
	public Unidad() {
		
		this.penalizador = 0;
		
	}
	
	public Unidad(int vida, int costo) {
		
		this.vida = vida;
		this.costo = costo;
		this.penalizador = 0;
		
	}
	
	public void setPenalizador(int pen) {
		penalizador = pen;
	}
	
	public void perderVida(int puntosAPerder) {
		
		this.vida -= (puntosAPerder + (((puntosAPerder * penalizador) / 100)));

	}
	
	public Coordenada getCoordenadas() {
		return coordenadas;
	}
	
	public void setCoordenadas(Coordenada coordenadas){
		
		this.coordenadas = coordenadas;
		
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
	
	public int restarPuntos(int puntosDelJugador) {
		return (puntosDelJugador - this.costo);
	}
	
	
	
}
	
