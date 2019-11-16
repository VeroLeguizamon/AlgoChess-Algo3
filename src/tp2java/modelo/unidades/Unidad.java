package tp2java.modelo.unidades;

import tp2java.modelo.Jugador;
import tp2java.modelo.interfaces.IUnidad;
import tp2java.modelo.tablero.Coordenada;

public class Unidad implements IUnidad{
	
	private int costo; 
	private int vida; 
	private int penalizador; 
	private Jugador jugador;
	private Coordenada ubicacion;
	
	public Unidad() {
		
		this.penalizador = 0;
		
	}
	
	public Unidad(int vida, int costo, Coordenada ubicacion) {
		
		this.vida = vida;
		this.costo = costo;
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
	
	public int restarPuntos(int puntosDelJugador) {
		return (puntosDelJugador - this.costo);
	}
	
	public boolean tieneMismaUbicacion(Coordenada coordenada) {
		return (this.ubicacion.equals(coordenada));
	}
	public void setJugador(Jugador nuevo) {
		this.jugador = nuevo;
	}
	public Jugador getJugador() {
		return this.jugador;
	}
	public boolean mismoEquipo(Unidad unidad) {
		return (this.jugador == unidad.getJugador());
	}
	public boolean perteneceASuSector() {
		return this.jugador.perteneceAlSector(this.ubicacion);
	}
}
	
