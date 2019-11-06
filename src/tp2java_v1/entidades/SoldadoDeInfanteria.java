package tp2java_v1.entidades;

import tp2java_v1.entidadInterfaces.IEntidad;
import tp2java_v1.tablero.Coordenada;

public class SoldadoDeInfanteria implements IEntidad{
	
	private Coordenada ubicacion;
	private int sector;

	public SoldadoDeInfanteria(int sector,Coordenada coordenadas){
		this.ubicacion=coordenadas;
		this.sector=sector;
		
		
	}
	
	public Coordenada getUbicacion(){
		return this.ubicacion;
	}

	public int getSector() {
		return this.sector;
	}		
	
	

}
