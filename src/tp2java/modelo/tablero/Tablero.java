package tp2java.modelo.tablero;

import java.util.ArrayList;

import java.util.Hashtable;

import tp2java.excepciones.CeldaEstaOcupadaExcepcion;
import tp2java.excepciones.CeldaNoExisteExcepcion;
import tp2java.excepciones.CeldaNoPerteneceAlSector;
import tp2java.excepciones.EntidadNoExisteExcepcion;
import tp2java.modelo.interfaces.IUnidad;
import tp2java.modelo.tablero.Celda;
import tp2java.modelo.tablero.Coordenada;;


public class Tablero{
	private Hashtable<Coordenada, Celda> celdas;
	private ArrayList<IUnidad> entidades;

	public Tablero() {
		this.celdas=new Hashtable<Coordenada,Celda>();
		this.entidades=new ArrayList<IUnidad>();
		
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

	public void agregarEntidad(IUnidad unidad){
		//obtengo la celda donde quiero agregar la entidad.
		
		Celda celda=celdas.get(unidad.getUbicacion());
		//verifico si la celda existe y si esta ocupada
		
		if(celda!=null){
			if(unidad.getSector()==celda.sectorEs()) {
				if(!celda.estaOcupada()){
					celda.ocupada();
					this.entidades.add(unidad);
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
	
	
	public void moverEntidad(IUnidad unidad, Coordenada nuevaCoordenada) {
		
		//verificamos que la entidad que desean mover este en el tablero
		if(entidades.contains(unidad)) {
			//verificamos la celda donde quiere moverse
			Celda celda=celdas.get(nuevaCoordenada);
			if(celda!=null){
				if(unidad.getSector()==celda.sectorEs()) {
					if(!celda.estaOcupada()){
						celda.ocupada();
						unidad.setUbicacion(nuevaCoordenada);
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
		
	}
	public int cantEntidades(){
		return this.entidades.size();
	}
	
	

}
