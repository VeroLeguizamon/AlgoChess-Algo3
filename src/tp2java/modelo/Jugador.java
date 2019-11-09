package tp2java.modelo;

import tp2java.modelo.interfaces.IUnidad;


public class Jugador {
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
	public String getNombre() {
		return this.nombre;
	}
	private void setPuntos(int puntosNuevos) {
		this.puntos = puntosNuevos;
	}
	
	public void comprarUnidad(IUnidad unidad) {
		if(this.noTienePuntosSuficientesParaComprar(unidad)) { return ;} // Como debe tratarse puntos insuficientes?
		this.setPuntos(unidad.restarPuntos(this.puntos));
		// unidad.setJugador(this); // Para que recién cuando se lo compre se lo agregue. 
		this.equipo.agregar(unidad);
	}
	
	public boolean esPerdedor() {
		if(this.equipo.noTieneUnidades() || this.equipo.hayUnidadesConVida()) return false;
		return true;
	}
	
	public boolean noTienePuntosSuficientesParaComprar(IUnidad unidad) {
		return (unidad.restarPuntos(this.puntos)<0);
	}
}
