package tp2java.modelo.unidades;

import tp2java.modelo.interfaces.IUnidad;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;
import tp2java.modelo.Observable;

public class Unidad extends Observable implements IUnidad{
	
	private int costo; 
	private int vida; 
	private Jugador jugador = null;
	private Coordenada ubicacion;
	private Tablero tablero;
	
	public Unidad() {
		
	}
	
	public Unidad(int vida, int costo, Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		
		this.vida = vida;
		this.costo = costo;
		this.jugador = jugador;
		this.ubicacion = ubicacion;
		this.tablero = tablero;
		
	}
	
	public Unidad(int vida, int costo) {
		
		this.vida = vida;
		this.costo = costo;
		
	}
	public Unidad(int vida, int costo, Jugador jugador) {
		
		this.vida = vida;
		this.costo = costo;
		
	}
	public void perderVida(int puntosAPerder) {
		this.vida -= puntosAPerder;
		if(this.estaMuerta()) {
			tablero.quitar(this);
		}
		notifyObservers();
		
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
	
	public boolean estaMuerta() {
		return !tieneVida();
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
	public Jugador getJugador() {
		return jugador;
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public int restarPuntos(int puntosDelJugador) {
		return (puntosDelJugador - this.costo);
	}

	public boolean mismoEquipo(Unidad unidad) {
		return (this.jugador == unidad.getJugador());
	}
	
	public boolean perteneceASuSector() {
		return this.jugador.perteneceAlSector(this.ubicacion);
	}
	
	public boolean tienePenalizador() {
		return !(perteneceASuSector());
	}
	
	public boolean tieneMismaUbicacion(Coordenada coordenada) {
		return (this.ubicacion.equals(coordenada));
	}
	
	public boolean esEnemiga(Unidad unidad) {
		return (this.jugador != unidad.getJugador());
	}
	
	public int distanciaA(Unidad unidad) {
		return this.ubicacion.calcularDistancia(unidad.getUbicacion());
	}
	public int distanciaA(Coordenada coordenada) {
		return this.ubicacion.calcularDistancia(coordenada);
	}

	@Override
	public boolean esSoldadoDeInfanteria() {
		return false;
	}	
	
	@Override
	public boolean sePuedeUnirAlBatallon() {
		return false;
	}
	
	public boolean sePuedeMover() {
		return false;
	}

	public void interactuar(Unidad unidad) {
		
	}

	public boolean esCurable() {
		return false;
	}
	
}
	
