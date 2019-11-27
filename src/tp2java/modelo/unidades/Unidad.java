package tp2java.modelo.unidades;

import tp2java.modelo.interfaces.IUnidad;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;

public class Unidad implements IUnidad{
	
	private int costo; 
	// Costo al comprar la Unidad.
	private int vida; 
	// Puntos de vida de la Unidad.
	private Jugador jugador;
	private Coordenada ubicacion;
	// Ubicación en el tablero.
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
	public void perderVida(int puntosAPerder) {
		
		this.vida -= puntosAPerder;

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
	public Unidad crearUnidad() {
		return new Unidad();
	}
}
	
