package fiuba.algo3.mock;

import fiuba.algo3.mock.interfaces.IUnidad;

public class MockUnidad implements IUnidad{
	boolean conVida = true;
	
	public MockUnidad () {
		
	}
	@Override
	public int restarPuntos(int puntos) {

		return (puntos-4);
	}
	@Override
	public int getPrecio() {
		return 4;
	}
	@Override 
	public boolean noAlcanzaParaComprar(int puntos) {
		return (0>(puntos-4));
	}
	public boolean tieneVida() {
		return this.conVida;
	}
	public void matar() {
		this.conVida = false;
	}
}
