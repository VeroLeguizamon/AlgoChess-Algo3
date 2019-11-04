package tp2java_v1.tablero;

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
	public boolean equals(Object obj) {
		Coordenada coordenada = (Coordenada)obj;
		
		return ((this.coordx == coordenada.getCoordx()) && 
				(this.coordy == coordenada.getCoordy()));
		
	}

}
