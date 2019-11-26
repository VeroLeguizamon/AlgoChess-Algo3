package tp2java.modelo.unidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Direccion;

public class Batallon {
	private ArrayList<Unidad> batallon= new ArrayList<Unidad>();
	private ArrayList<Unidad> movidos =new ArrayList<Unidad>();
	
	public Batallon() {
		
	}
	
	public boolean existeBatallon(Unidad unidadCentral) {
		return(this.obtenerBatallon(unidadCentral).size()==3);	
	}
	
	public ArrayList<Unidad> obtenerBatallon(Unidad unidadCentral) {
		ArrayList<Unidad> batallonAux= new ArrayList<Unidad>();
		ArrayList<Unidad> adyacentes = unidadCentral.getTablero().unidadesCercanas(unidadCentral, 1);

		if (unidadCentral.sePuedeUnirAlBatallon()) {
			batallonAux.add(unidadCentral);
			for(Unidad unidadAdyacente: adyacentes) {
				if(unidadAdyacente.sePuedeUnirAlBatallon() & (batallonAux.size()<=2) ) {
					batallonAux.add(unidadAdyacente);
				}
			}
		}
		this.batallon=batallonAux;
		return(batallonAux);
	}
	
	public void mover(Direccion direccion){
		Queue<Unidad> unidadesAMover = this.formarPila();
		
		while(!unidadesAMover.isEmpty()) {
			Unidad unidad = unidadesAMover.poll();
			Coordenada coordenada = direccion.calcularCoordenada(unidad.getUbicacion());
			
			if(!this.coincideCoordenada(coordenada, movidos)) {
				if(!this.coincideCoordenada(coordenada, batallon)) {
					((UnidadMovible) unidad).mover(direccion);
					this.movidos.add(unidad);
				} else {
					unidadesAMover.add(unidad);
				}
			} else {
				this.movidos.add(unidad);
			}
		}
	}
	
	private Queue<Unidad> formarPila(){
		Queue<Unidad> unidades = new LinkedList<>();
		
		for(Unidad unidad : this.batallon) {
			unidades.add(unidad);
		}
		return unidades;
	}
	
	private boolean coincideCoordenada(Coordenada coordenada,ArrayList<Unidad>lista) {
		if(!lista.isEmpty()) {
			for(Unidad unidad : lista) {
				if(unidad.tieneMismaUbicacion(coordenada)) return true;
			}
		}
		return false;
	}
}