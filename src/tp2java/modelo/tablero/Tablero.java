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
	// int distancia?
	public ArrayList<Unidad> unidadesCercanas(Unidad unidadActual, int distancia){
		ArrayList<Unidad> unidades  = new ArrayList<Unidad>();
		// actual, si no me envian la coordenada bien puedo tirar una expeccion en distanciaA
		
		for(Unidad unidad : this.unidades) {
			// tiene misma ubicacion mandarle una unidad, no una ubicacion, como distancia A
			if(!unidad.tieneMismaUbicacion(unidadActual.getUbicacion()) && (unidad.distanciaA(unidadActual) <= distancia)) {
				unidades.add(unidad);
			}
		}
		return unidades;
	}
	private ArrayList<SoldadoDeInfanteria> existeBatallon(SoldadoDeInfanteria unidadCentral) {
		
		ArrayList<Unidad>list=new ArrayList<Unidad>(this.unidadesCercanas(unidadCentral,1));
		ArrayList<SoldadoDeInfanteria>listSalida=new ArrayList<SoldadoDeInfanteria>();
		
		listSalida.add(unidadCentral);
		for(Unidad unidadAdy: list) {
			if(unidadAdy instanceof SoldadoDeInfanteria) {
				listSalida.add((SoldadoDeInfanteria)unidadAdy);
				
			}
		}
		
		return (listSalida);
	}

	
}
