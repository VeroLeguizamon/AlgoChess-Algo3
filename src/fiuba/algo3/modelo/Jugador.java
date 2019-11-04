package fiuba.algo3.modelo;

import fiuba.algo3.mock.interfaces.IUnidad;
import fiuba.algo3.modelo.excepciones.PuntosInsuficientes;


public class Jugador {
	
	private int puntos = 20;
	private Equipo equipo;
	
	public Jugador() {
		this.equipo = new Equipo();
	}
	
	//Solo para pruebas, quitar luego. Buscar mejor manera para testearlo.
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
		if(this.equipo.estaVacio()) return false;
		if(this.equipo.hayUnidadesConVida()) return false;
		return true;
	}
	

}
