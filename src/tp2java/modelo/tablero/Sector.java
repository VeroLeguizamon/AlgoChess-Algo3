package tp2java.modelo.tablero;

public class Sector {
	
	private int columnaInferior;
	private int filaSuperior;
	private int filaInferior;
	private int columnaSuperior;
	
	
	public boolean perteneceAlSector(Coordenada coordenada) {
		if((coordenada.tieneCoeficientesMayoresOIgualesQue(this.columnaInferior,this.filaInferior)) &&
		   (coordenada.tieneCoeficientesMenoresOIgualesQue(this.columnaSuperior, this.filaSuperior))) {
			return true;
		}
		return false;
	}
	
	public Sector(int columnaInferior, int columnaSuperior) {
		this.columnaSuperior = columnaSuperior;
		this.columnaInferior = columnaInferior;
		this.filaInferior = 0;
		this.filaSuperior = 19;
	}
}
