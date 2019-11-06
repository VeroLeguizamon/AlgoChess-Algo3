package fiuba.algo3.modelo;

import fiuba.algo3.interfaces.IUnidad;
import fiuba.algo3.modelo.excepciones.PuntosInsuficientes;


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
	
	public void comprarUnidad(IUnidad unidad) {
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
