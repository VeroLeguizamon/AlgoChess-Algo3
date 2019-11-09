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
	    return this.coordx == that.coordx
	        && this.coordy == that.coordy;
	}
	@Override
    public int hashCode() {
        
        final int prime = 31;
        int result = 1;
        result = prime * result + coordx;
        result = prime * result + coordy;
        return result;
    }
	
	private Coordenada calcularCoordenada (int i, int j) {
		return new Coordenada(this.coordx + i, this.coordy + j);
	}
	
	//Coordenadas Adyacentes
	public Coordenada getCoordenadaArriba() {
		return this.calcularCoordenada(0, 1);
	}
	public Coordenada getCoordenadaAbajo() {
		return this.calcularCoordenada(0, -1);
	}
	public Coordenada getCoordenadaDerecha() {
		return this.calcularCoordenada(1, 0);
	}
	public Coordenada getCoordenadaIzquierda() {
		return this.calcularCoordenada(-1, 0);
	}
	public Coordenada getCoordenadaDiagonalArribaDerecha() {
		return this.calcularCoordenada(1,1);
	}
	public Coordenada getCoordenadaDiagonalArribaIzquierda() {
		return this.calcularCoordenada(-1, 1);
	}
	public Coordenada getCoordenadaDiagonalAbajoDerecha() {
		return this.calcularCoordenada(1, -1);
	}
	public Coordenada getCoordenadaDiagonalAbajoIzquierda() {
		return this.calcularCoordenada(-1, -1);
	}
	
	public int calcularDistancia(Coordenada coordenada) {
		int distanciaX = Math.abs(coordenada.getCoordx() - this.coordx);
		int distanciaY = Math.abs(coordenada.getCoordy() - this.coordy);
		
		int distanciaMaxima = Math.max(distanciaX, distanciaY);
		
		return distanciaMaxima;
	}
}
