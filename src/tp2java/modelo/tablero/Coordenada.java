package tp2java.modelo.tablero;

public class Coordenada {
	private int coordx;
	private int coordy;

	public Coordenada(int coordx,int coordy) {
		this.coordx=coordx;
		this.coordy=coordy;			
	}
	public int getCoordx() {
		return coordx;
	}
	public int getCoordy() {
		return coordy;
	}
	@Override
	public boolean equals(Object other) {
	    if (!(other instanceof Coordenada)) {
	        return false;
	    }
	    Coordenada that = (Coordenada) other;
	    return (this.coordx == that.coordx
	        && this.coordy == that.coordy);
	}
	@Override
    public int hashCode() {
        
        final int prime = 31;
        int result = 1;
        result = prime * result + coordx;
        result = prime * result + coordy;
        return result;
    }
	
	public Coordenada calcularCoordenada (int i, int j) {
		return new Coordenada(this.coordx + i, this.coordy + j);
	}
	
	
	public int calcularDistancia(Coordenada coordenada) {
		int distanciaX = Math.abs(coordenada.getCoordx() - this.coordx);
		int distanciaY = Math.abs(coordenada.getCoordy() - this.coordy);
		
		int distanciaMaxima = Math.max(distanciaX, distanciaY);
		
		return distanciaMaxima;
	}
	public boolean tieneCoeficientesMenoresOIgualesQue(int columna, int fila) {
		return ((this.coordx <= columna) && this.coordy <= fila);
	}

	public boolean tieneCoeficientesMayoresOIgualesQue(int columna, int fila) {
		return ((this.coordx >= columna) && this.coordy >= fila); 
	}
}
