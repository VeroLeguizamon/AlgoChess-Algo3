package tp2java.modelo;

import tp2java.modelo.interfaces.IUnidad;
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
	
	public void comprarUnidad(IUnidad unidad) {
		if(unidad.restarPuntos(this.puntos)<0) { return ;} // Como debe tratarse puntos insuficientes?
		this.setPuntos(unidad.restarPuntos(this.puntos));
		// unidad.setJugador(this); // Para que recién cuando se lo compre se lo agregue. 
		this.equipo.agregar(unidad);
	}
	
	public boolean esPerdedor() {
		if(this.equipo.noTieneUnidades() || this.equipo.hayUnidadesConVida()) return false;
		return true;
	}
	

}
