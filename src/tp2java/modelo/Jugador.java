package tp2java.modelo;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Sector;
import tp2java.modelo.unidades.Unidad;


public class Jugador {
	private String nombre = "";
	private int puntos = 20;
	private Equipo equipo;
	private Sector sector;
	
	public Jugador(String nombreNuevo) {
		this.equipo = new Equipo();
		this.nombre = nombreNuevo;
	}
	
	public Jugador(String nombreNuevo, int columnaInferior, int columnaSuperior) {
		this.equipo = new Equipo();
		this.nombre = nombreNuevo;
		// Sector cuadrado.
		this.sector = new Sector(columnaInferior, columnaInferior, columnaSuperior,columnaSuperior);
	}
	public int getPuntos() {
		return this.puntos;
	}
	public String getNombre() {
		return this.nombre;
	}
	private void setPuntos(int puntosNuevos) {
		this.puntos = puntosNuevos;
	}
	
	public void comprarUnidad(Unidad unidad) {
		if(this.noTienePuntosSuficientesParaComprar(unidad)) { return ;} // Como debe tratarse puntos insuficientes?
		this.setPuntos(unidad.restarPuntos(this.puntos));
		unidad.setJugador(this);
		this.equipo.agregar(unidad);
	}
	
	public boolean esPerdedor() {
		if(this.equipo.noTieneUnidades() || this.equipo.hayUnidadesConVida()) return false;
		return true;
	}
	
	public boolean noTienePuntosSuficientesParaComprar(Unidad unidad) {
		return (unidad.restarPuntos(this.puntos)<0);
	}
	public boolean perteneceAlSector(Coordenada coordenada) {
		return (this.sector.perteneceAlSector(coordenada));
	}
	public boolean equals(Jugador jugador) {
		return (this.nombre == jugador.getNombre());
	}
}
