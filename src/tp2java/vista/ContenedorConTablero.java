package tp2java.vista;

import tp2java.modelo.tablero.Tablero;

public interface ContenedorConTablero {

	public boolean hayUnidadSeleccionada();

	public VistaUnidad getUnidadSeleccionada();

	public void resetSeleccionado();

	void setUnidadSeleccionada(VistaUnidad unidad);

	public void definirAccionDeCelda(VistaCelda vistaCelda, Tablero tablero, int x, int y);
	
	public VistaTablero getVistaTablero();
	
}
