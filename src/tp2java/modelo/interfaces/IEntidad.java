package tp2java.modelo.interfaces;

import tp2java.modelo.tablero.Coordenada;

public interface IEntidad {
	
	public int restarPuntos(int puntos);
	
	public int getCosto();
	
	public Coordenada getUbicacion();
	
	public void setUbicacion(Coordenada ubicacion);
	
	public int getSector();
	
	public boolean tieneVida();
	
	//public boolean noAlcanzaParaComprar(int puntos);
	
	//public void matar();
	
}
