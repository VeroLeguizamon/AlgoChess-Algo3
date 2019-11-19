package tp2java.modeloTest.unidadesTest;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import org.junit.Test;


import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Direccion;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Batallon;
import tp2java.modelo.unidades.SoldadoDeInfanteria;



public class BatallonTest {
	private SoldadoDeInfanteria soldado1,soldado3;
	private SoldadoDeInfanteria soldado2;
	private Tablero tablero;
	private Jugador jugador1 = new Jugador("Player1",0,9);
	private Jugador jugador2 = new Jugador("Player2",10,9);
	@Test
	public void test01BatallonExiste(){
		

		tablero=new Tablero();
		
		SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
		SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
		SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,4),tablero);
		
		soldado1.setJugador(jugador1);
		soldado2.setJugador(jugador1);
		soldado3.setJugador(jugador1);
		
		ArrayList<SoldadoDeInfanteria>soldados=new ArrayList<SoldadoDeInfanteria>();
		
		soldados.add(soldado1);
		soldados.add(soldado2);
		soldados.add(soldado3);
		
		Batallon batallon=new Batallon(soldados);
		
		batallon.mover(Direccion.ARRIBA);
		
		assertEquals(Direccion.ARRIBA.calcularCoordenada(new Coordenada(2,2)), soldado1.getUbicacion());
		
	}

}
