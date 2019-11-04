package tp2java_v1.tablero;

//import java.util.ArrayList;
import java.util.Hashtable;
import tp2java_v1.tablero.Celda;
import tp2java_v1.tablero.Coordenada;;


public class Tablero {
	private Hashtable<Coordenada, Celda> celdas;
	//private ArrayList<IEntidades> entidades;

	public Tablero() {
		this.celdas=new Hashtable<Coordenada,Celda>();
		//this.entidades=new ArrayList<IEntidades>();
		
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

	

}
