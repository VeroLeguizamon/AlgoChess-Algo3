package tp2java_v1.entidades;

import tp2java_v1.entidadInterfaces.IEntidad;
import tp2java_v1.tablero.Coordenada;

public class Jinete implements IEntidad{
	
	
	private Coordenada ubicacion;
	private int sector;

	public Jinete(int sector,Coordenada coordenadas){
		this.ubicacion=coordenadas;
		this.sector=sector;
	}

	@Override
	public Coordenada getUbicacion() {
		// TODO Auto-generated method stub
		return this.ubicacion;
	}

	@Override
	public int getSector() {
		// TODO Auto-generated method stub
		return this.sector;
	}

}
