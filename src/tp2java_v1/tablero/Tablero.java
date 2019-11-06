package tp2java_v1.tablero;

import java.util.ArrayList;

import java.util.Hashtable;

import tp2java_v1.entidadInterfaces.IEntidad;
import tp2java_v1.excepciones.CeldaEstaOcupadaExcepcion;
import tp2java_v1.excepciones.CeldaNoExisteExcepcion;
import tp2java_v1.excepciones.CeldaNoPerteneceAlSector;
import tp2java_v1.tablero.Celda;
import tp2java_v1.tablero.Coordenada;;


public class Tablero {
	private Hashtable<Coordenada, Celda> celdas;
	private ArrayList<IEntidad> entidades;

	public Tablero() {
		this.celdas=new Hashtable<Coordenada,Celda>();
		this.entidades=new ArrayList<IEntidad>();
		
		//cargamos las celdas como desocupadas
		for (int i = 0; i < 20 ; i++) {
			for (int j = 0; j < 20; j++) {
				Coordenada coordenadas=new Coordenada(i, j);
				Celda celda=new Celda(coordenadas);
				
				if(j<=9) {
					celda.sectorUno();
				}else { celda.sectorDos();}
				this.celdas.put(coordenadas,celda);				
			}			
		}
		
		
		
	}

	public void agregarEntidad(IEntidad entidad){
		//obtengo la celda donde quiero agregar la entidad.
		
		Celda celda=celdas.get(entidad.getUbicacion());
		//verifico si la celda existe y si esta ocupada
		
		if(celda!=null){
			if(entidad.getSector()==celda.sectorEs()) {
				if(!celda.estaOcupada()){
					celda.ocupada();
					this.entidades.add(entidad);
				}else {
					throw new CeldaEstaOcupadaExcepcion();
				}
				
			}else {
				throw new CeldaNoPerteneceAlSector();
			}
			
			
		}else {
			throw new CeldaNoExisteExcepcion();
		}
		
		
	}
	/*public void moverEntidad(IEntidad entidad, Coordenada nuevaCoordenada) {
		Coordenada ubiEntidad=entidad.getUbicacion();
		
		//verificamos que la entidad que desean mover este en el tablero
		if(entidades.contains(entidad)) {
			//verificamos la celda donde quiere moverse
			Celda celda=celdas.get(nuevaCoordenada);
			if(celda!=null){
				if(entidad.getSector()==celda.sectorEs()) {
					if(!celda.estaOcupada()){
						celda.ocupada();
						entidad.
					}else {
						throw new CeldaEstaOcupadaExcepcion();
					}
					
				}else {
					throw new CeldaNoPerteneceAlSector();
				}
				
				
			}else {
				throw new CeldaNoExisteExcepcion();
			}
			
			
		}else {
			throw new EntidadNoExisteExcepcion();
		}
		
	}*/
	public int cantEntidades(){
		return this.entidades.size();
	}
	
	

}
