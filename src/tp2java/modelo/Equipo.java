package tp2java.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import tp2java.modelo.unidades.Unidad;

public class Equipo {
	
	ArrayList<Unidad> unidades; 
	
	public Equipo() {
		this.unidades = new ArrayList<Unidad>();
	}
	
	public void agregar(Unidad unidad) {
		this.unidades.add(unidad);
	}
	
	public int cantidadUnidades() {
		return this.unidades.size();
	}
	public boolean hayUnidadesConVida() {
		Iterator<Unidad> actual = unidades.iterator();
		
		while(actual.hasNext()) {
			Unidad unidadActual = actual.next();
			if(unidadActual.tieneVida()) {
				return true;
			}
		}	
		return false;
	}
	
	public boolean noTieneUnidades() {
		return this.unidades.isEmpty();
	}
	
}
