package tp2java.modelo;

import tp2java.modelo.interfaces.IEntidad;
import tp2java.excepciones.PuntosInsuficientes;


public class Jugador {
	@SuppressWarnings("unused")
	private String nombre = "";
	private int puntos = 20;
	private Equipo equipo;
	
	public Jugador(String nombreNuevo) {
		this.equipo = new Equipo();
		this.nombre = nombreNuevo;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	private void setPuntos(int puntosNuevos) {
		this.puntos = puntosNuevos;
	}
	
	public void comprarUnidad(IEntidad unidad) {
		if(unidad.restarPuntos(this.puntos)<0) {
			throw new PuntosInsuficientes();
		}
		this.setPuntos(unidad.restarPuntos(this.puntos));
		this.equipo.agregar(unidad);
	}
	
	public boolean esPerdedor() {
		if(this.equipo.noTieneUnidades() || this.equipo.hayUnidadesConVida()) return false;
		return true;
	}
	

}
