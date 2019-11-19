package tp2java.modelo.interfaces;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.Jugador;

public interface IUnidad {
	
	public int restarPuntos(int puntos);
	
	public int getCosto();
	
	public Coordenada getUbicacion();
	
	public void setUbicacion(Coordenada ubicacion);
	
	public Jugador getJugador();
	
	public boolean tieneVida();
	
	//public boolean noAlcanzaParaComprar(int puntos);
	
	//public void matar();
	
}
