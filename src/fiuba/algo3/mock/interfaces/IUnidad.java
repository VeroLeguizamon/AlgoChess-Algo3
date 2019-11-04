package fiuba.algo3.mock.interfaces;

public interface IUnidad {
	
	public int restarPuntos(int puntos);
	
	public int getPrecio();
	
	public boolean noAlcanzaParaComprar(int puntos);
	
	public boolean tieneVida();
	
	public void matar();
}
