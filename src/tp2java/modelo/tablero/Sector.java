package tp2java.modelo.tablero;

public class Sector {
	private Coordenada coordenadaMinima;
	private Coordenada coordenadaMaxima;
	
	public Sector(Coordenada min, Coordenada max) {
		this.coordenadaMaxima = max;
		this.coordenadaMinima = min;
	}
	
	public boolean perteneceAlSector(Coordenada coordenada) {
		if((coordenada.tieneCoeficientesMayoresOIgualesQue(coordenadaMinima)) && 
		   (coordenada.tieneCoeficientesMenoresOIgualesQue(coordenadaMaxima))) {
			return true;
		}
		return false;
	}
}
