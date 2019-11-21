package tp2java.modelo.unidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Direccion;

public class Batallon {
	private ArrayList<SoldadoDeInfanteria> batallon=new ArrayList<SoldadoDeInfanteria>();
	private ArrayList<SoldadoDeInfanteria> movidos =new ArrayList<SoldadoDeInfanteria>();
	
	public Batallon(ArrayList<SoldadoDeInfanteria>listBatallon) {
		this.batallon=listBatallon;
	}
	
	public void mover(Direccion direccion){
		Queue<SoldadoDeInfanteria> soldadosAMover = this.formarPila();
		
		while(!soldadosAMover.isEmpty()) {
			SoldadoDeInfanteria soldado = soldadosAMover.poll();
			Coordenada coordenada = direccion.calcularCoordenada(soldado.getUbicacion());
			
			if(!this.coincideCoordenada(coordenada, movidos)) {
				if(!this.coincideCoordenada(coordenada, batallon)) {
					soldado.mover(direccion);
					this.movidos.add(soldado);
				} else {
					soldadosAMover.add(soldado);
				}
			} else {
				this.movidos.add(soldado);
			}
		}
	}
	private Queue<SoldadoDeInfanteria> formarPila(){
		Queue<SoldadoDeInfanteria> soldados = new LinkedList<>();
		
		for(SoldadoDeInfanteria soldado : this.batallon) {
			soldados.add(soldado);
		}
		return soldados;
	}
	private boolean coincideCoordenada(Coordenada coordenada,ArrayList<SoldadoDeInfanteria>lista) {
		if(!lista.isEmpty()) {
			for(SoldadoDeInfanteria soldado : lista) {
				if(soldado.tieneMismaUbicacion(coordenada)) return true;
			}
		}
		return false;
	}
}