package tp2java.modelo.unidades;

import java.util.ArrayList;

import tp2java.excepciones.ObjetivoAliado;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.unidades.Atacante;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;

public class Catapulta extends Unidad implements Atacante {
	
	private Ataque ataque;
	private int distanciaMinimaAtaque = 6;
	private static int precio = 5;
	private static int poderAtaque = 20;
	
	public Catapulta(Jugador jugador, Coordenada ubicacion, Tablero tablero) {
		super(50,precio,jugador,ubicacion,tablero);
		this.ataque = new Ataque(this,poderAtaque);
		
	}
	
	public Catapulta(Jugador jugador) {
		super(50,precio,jugador);
		this.ataque = new Ataque(this,poderAtaque);
	}
	
	public Catapulta() {
		super(50,precio);
		this.ataque = new Ataque(this,20);
	}
	
	@Override
	public void interactuar(Unidad unidad) {
		atacar(unidad);
	}
	@Override
	public boolean puedoInteractuar(Unidad unidad) {
		return (distanciaA(unidad) > this.distanciaMinimaAtaque);	
	}
	
	@Override 
	public void atacar(Unidad unidad) throws ObjetivoAliado{	
				
		if(esEnemiga(unidad)) {
			if(this.puedoInteractuar(unidad)) {
				ArrayList<Unidad> unidadesAfectadas = recorrerUnidadesAfectadas(unidad);
				for(Unidad unidadAfectada : unidadesAfectadas) {
					ataque.sinDistincionDeEquipoA(unidadAfectada);
				}
			}
		}
		else throw (new ObjetivoAliado());
		
	}
	
	public ArrayList<Unidad> recorrerUnidadesAfectadas(Unidad unidad){
		
		ArrayList<Unidad> unidadesAfectadas = new ArrayList<Unidad>();
				
		agregarEnCadena(unidad, unidadesAfectadas);
		
		return unidadesAfectadas;	
		
	}
	
	private void agregarEnCadena(Unidad unidad, ArrayList<Unidad> unidadesAfectadas) {
		int distanciaAdyacente = 1;
		if(!unidadesAfectadas.contains(unidad)) {
			unidadesAfectadas.add(unidad);
			ArrayList<Unidad> unidadesAdyacentes = unidad.getTablero().unidadesCercanas(unidad, distanciaAdyacente);
			for(Unidad unidadAdyacente : unidadesAdyacentes) {
				agregarEnCadena(unidadAdyacente, unidadesAfectadas);
			}
		}	
	}
	
}
