package tp2java_v1.tablero;

import tp2java_v1.tablero.Coordenada;
public class Celda {
	private Coordenada coordenadas;
	private boolean ocupada;
	private int sector;
	
	public Celda(Coordenada coordenada) {
		this.coordenadas=coordenada;
		this.ocupada=false;
		this.sector=0;
	}
	public Coordenada getCoordenada() {
		return coordenadas;
		
	}
	public void sectorUno() {
		this.sector=1;
		
	}
	public void sectorDos() {
		this.sector=2;
	}
	public int sectorEs() {
		return sector;
	}
	public void ocupada() {
		this.ocupada=true;
		
	}
	public void desocupada() {
		this.ocupada=false;
		
	}
	public boolean estaOcupada() {
		return ocupada;
	}
	

}
