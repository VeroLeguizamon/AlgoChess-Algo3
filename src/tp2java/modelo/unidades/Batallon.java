package tp2java.modelo.unidades;

import java.util.ArrayList;


import tp2java.modelo.tablero.Direccion;

public class Batallon {
	private ArrayList<SoldadoDeInfanteria> batallon=new ArrayList<SoldadoDeInfanteria>();
	

	
	public Batallon(ArrayList<SoldadoDeInfanteria>listBatallon) {
		this.batallon=listBatallon;
		
		
	}
	public void mover(Direccion direccion){
		for(SoldadoDeInfanteria soldado:this.batallon ){
			soldado.mover(direccion);
		}
	}

}
