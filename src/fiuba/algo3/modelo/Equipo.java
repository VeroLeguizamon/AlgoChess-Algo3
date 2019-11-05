package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.mock.interfaces.IUnidad;

public class Equipo {
	
	ArrayList<IUnidad> unidades; 
	
	public Equipo() {
		this.unidades = new ArrayList<IUnidad>();
	}
	
	public void agregar(IUnidad unidad) {
		this.unidades.add(unidad);
	}
	
	public boolean hayUnidadesConVida() {
		Iterator<IUnidad> actual = unidades.iterator();
		
		while(actual.hasNext()) {
			IUnidad unidadActual = actual.next();
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
