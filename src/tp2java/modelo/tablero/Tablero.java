package tp2java.modelo.tablero;

import java.util.ArrayList;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.unidades.Unidad;


public class Tablero{
	private Sector limites;
	private ArrayList<Unidad> unidades;
	
	
	public Tablero() {
		this.unidades = new ArrayList<Unidad>();
		this.limites = new Sector(new Coordenada(0,0), new Coordenada(19,19));
	}
	
	public boolean existeLaCelda(Coordenada coordenada) {
		return this.limites.perteneceAlSector(coordenada);
	}
	
	public boolean laCeldaEstaLibre(Coordenada coordenada) {
		for(Unidad unidad : this.unidades) {
			if(unidad.tieneMismaUbicacion(coordenada)) return false;
		}
		return true;
	}

	public void colocarUnidad(Unidad unidad) {
		if (this.existeLaCelda(unidad.getUbicacion()) && this.laCeldaEstaLibre(unidad.getUbicacion())) {
			if(unidad.perteneceASuSector()) this.unidades.add(unidad);
		}
	}
	
	public boolean sePuedeMoverUnidad(Coordenada coordenada) {
		return (this.existeLaCelda(coordenada) && this.laCeldaEstaLibre(coordenada));
	}
	public int cantUnidades() {
		return this.unidades.size();
	}
	public boolean tieneEnemigosCercanos(Unidad unidad) {
		return false; //Implementar bien
	}
	public boolean tieneSoldadoAliadoCercano(Unidad unidad) {
		return false; //Implementar bien
	}

}
