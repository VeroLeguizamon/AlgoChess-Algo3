package tp2java.modelo.unidades;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.unidades.Unidad;

public class Ataque {
	
	private Unidad atacante; 
	private int poderDeAtaque;
	
	public Ataque(Unidad atacante, int poderDeAtaque) {
		this.atacante = atacante;
		this.poderDeAtaque = poderDeAtaque;
	}

	public void a(Unidad unidad) throws ObjetivoAliado{
		
		int penalizador = 0;
		
		if(atacante.esEnemiga(unidad)) {
			if(unidad.tienePenalizador())
				penalizador = 5;
			unidad.perderVida(poderDeAtaque + ((penalizador * poderDeAtaque) / 100));
		}
		else {
			throw new ObjetivoAliado();
		}
		
	}
	
}