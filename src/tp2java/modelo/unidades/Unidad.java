package tp2java.modelo.unidades;

import tp2java.modelo.interfaces.IUnidad;
import tp2java.modelo.tablero.Coordenada;

public class Unidad implements IUnidad{
	
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
	
	public Unidad(int vida, int costo, int jugador, Coordenada ubicacion) {
		
		this.vida = vida;
		this.costo = costo;
		this.jugador = jugador;
		this.penalizador = 0;
		this.ubicacion = ubicacion;
		
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
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getVida() {
		return vida;
	}
	
	@Override
	public int getCosto() {		
		return costo;
	}
		
	@Override
	public int getSector() {
		return jugador;
	}
	
	public int restarPuntos(int puntosDelJugador) {
		return (puntosDelJugador - this.costo);
	}
	
	
	
}
	
