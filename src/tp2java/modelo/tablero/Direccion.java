package tp2java.modelo.tablero;

public enum Direccion {
	ARRIBA(0,1),
	ABAJO (0,-1),
	DERECHA (1,0),
	IZQUIERDA (-1,0),
	ARRIBA_DERECHA(1,1),
	ARRIBA_IZQUIERDA(-1,1),
	ABAJO_DERECHA(1,-1),
	ABAJO_IZQUIERDA(-1,-1);
	
	private final int coordenadaX;
	private final int coordenadaY;
	
	Direccion(int coordenadaX, int coordenadaY){
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	public Coordenada calcularCoordenada(Coordenada coordenada) {
		return (coordenada.calcularCoordenada(this.coordenadaX, this.coordenadaY));
	}
}