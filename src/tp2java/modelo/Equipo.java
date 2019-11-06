package tp2java.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import tp2java.modelo.interfaces.IEntidad;

public class Equipo {
	
	ArrayList<IEntidad> unidades; 
	
	public Equipo() {
		this.unidades = new ArrayList<IEntidad>();
	}
	
	public void agregar(IEntidad unidad) {
		this.unidades.add(unidad);
	}
	
	public boolean hayUnidadesConVida() {
		Iterator<IEntidad> actual = unidades.iterator();
		
		while(actual.hasNext()) {
			IEntidad unidadActual = actual.next();
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
