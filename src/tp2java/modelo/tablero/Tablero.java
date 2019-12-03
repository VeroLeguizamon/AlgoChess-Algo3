package tp2java.modelo.tablero;

import java.util.ArrayList;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.unidades.SoldadoDeInfanteria;
import tp2java.modelo.unidades.Unidad;


public class Tablero{
	private Sector limites;
	private ArrayList<Unidad> unidades;

	public Tablero() {
		this.unidades = new ArrayList<Unidad>();
		this.limites = new Sector(0,19);
	}
	
	public boolean existeLaCelda(Coordenada coordenada) {
		return this.limites.perteneceAlSector(coordenada);
	}
	
	public boolean laCeldaEstaLibre(Coordenada coordenada) {
		for(Unidad unidad : this.unidades) {
			if(unidad.tieneMismaUbicacion(coordenada)) {
				return false;
			}
			
		}
		return true;
	}
	public boolean colocarUnidad(Unidad unidad) {
		if (this.existeLaCelda(unidad.getUbicacion()) && this.laCeldaEstaLibre(unidad.getUbicacion())) {
			if(unidad.perteneceASuSector()) {
				this.unidades.add(unidad);
				unidad.notifyObservers();
				return true;
			}
		}
		return false;
	}
	
	public boolean sePuedeMoverUnidad(Coordenada coordenada) {
		return (this.existeLaCelda(coordenada) && this.laCeldaEstaLibre(coordenada));
	}
	public int cantUnidades() {
		return this.unidades.size();
	}
	public ArrayList<Unidad> unidadesCercanas(Unidad unidadActual, int distancia){
		ArrayList<Unidad> unidades  = new ArrayList<Unidad>();		
		for(Unidad unidad : this.unidades) {
			if(!unidad.tieneMismaUbicacion(unidadActual.getUbicacion()) && (unidad.distanciaA(unidadActual) <= distancia)) {
				unidades.add(unidad);
			}
		}
		return unidades;
	}
	
	public ArrayList<Unidad> getUnidades(){
		return unidades;
	}	

	
}
