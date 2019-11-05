package fiuba.algo3.modelo.unidades;

public class Curandero  extends UnidadMovible implements Curable {
	
	private int poderDeCuracion;
	
	@Override
	public void recuperarVida() {
		
	}
	
	// Parámetro es la unidad a curar. 
	// Debe llamar al método recuperarVida de un Curable.
	public void curar(Curable curable) { 
		
	}
	
}
