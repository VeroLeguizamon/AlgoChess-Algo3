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
		
		if (unidadCentral.sePuedeUnirAlBatallon()) {
			ArrayList<Unidad>listAdyacentes=new ArrayList<Unidad>(unidadCentral.getTablero().unidadesCercanas(unidadCentral,1));
			batallonAux.add(unidadCentral);
			for(Unidad unidadAdyacente:listAdyacentes) {
				if(unidadAdyacente.sePuedeUnirAlBatallon()&(batallonAux.size()<=2)) {
					batallonAux.add(unidadAdyacente);
				}
			}
		}
		this.batallon=batallonAux;
		return(batallonAux);
		
	}
	
	public void mover(Direccion direccion){
		Queue<Unidad> soldadosAMover = this.formarPila();
		
		while(!soldadosAMover.isEmpty()) {
			Unidad soldado = soldadosAMover.poll();
			Coordenada coordenada = direccion.calcularCoordenada(soldado.getUbicacion());
			
			if(!this.coincideCoordenada(coordenada, movidos)) {
				if(!this.coincideCoordenada(coordenada, batallon)) {
					((UnidadMovible) soldado).mover(direccion);
					this.movidos.add(soldado);
				} else {
					soldadosAMover.add(soldado);
				}
			} else {
				this.movidos.add(soldado);
			}
		}
	}
	private Queue<Unidad> formarPila(){
		Queue<Unidad> soldados = new LinkedList<>();
		
		for(Unidad soldado : this.batallon) {
			soldados.add(soldado);
		}
		return soldados;
	}
	private boolean coincideCoordenada(Coordenada coordenada,ArrayList<Unidad>lista) {
		if(!lista.isEmpty()) {
			for(Unidad soldado : lista) {
				if(soldado.tieneMismaUbicacion(coordenada)) return true;
			}
		}
		return false;
	}
}