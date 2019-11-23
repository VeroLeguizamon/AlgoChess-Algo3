package tp2java.modeloTest.unidadesTest;



import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import tp2java.modelo.Jugador;
import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Direccion;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.unidades.Batallon;
import tp2java.modelo.unidades.SoldadoDeInfanteria;



public class BatallonTest {
	private Tablero tablero = mock(Tablero.class);
	private Jugador jugador1 = mock(Jugador.class);
	private SoldadoDeInfanteria soldado1=new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
	private SoldadoDeInfanteria soldado2= new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
	private SoldadoDeInfanteria soldado3=new SoldadoDeInfanteria(jugador1,new Coordenada(2,4),tablero);
	private ArrayList<SoldadoDeInfanteria>soldados;
	
	@Before
	public void setUp() {
		this.soldados = new ArrayList<SoldadoDeInfanteria>();
		soldados.add(soldado1);
		soldados.add(soldado2);
		soldados.add(soldado3);
	}
	@Test
	public void test01BatallonExiste(){

		when(tablero.sePuedeMoverUnidad(anyObject())).thenReturn(false);
		
		Batallon batallon=new Batallon();	
		batallon.mover(Direccion.ARRIBA);
		
		
		assertEquals(new Coordenada(2,2), soldado1.getUbicacion());
		assertEquals(new Coordenada(2,3),soldado2.getUbicacion());
		assertEquals(new Coordenada(2,4),soldado3.getUbicacion());
	}
	
//	@Test
//	public void test00SePuedenMoverTodasLasUnidades() {		
//		Batallon batallon=new Batallon();	
//		
//		when(tablero.sePuedeMoverUnidad(anyObject())).thenReturn(true);
//		
//		batallon.mover(Direccion.ARRIBA);
//		
//		assertEquals(Direccion.ARRIBA.calcularCoordenada(new Coordenada(2,2)),soldado1.getUbicacion());
//		assertEquals(Direccion.ARRIBA.calcularCoordenada(new Coordenada(2,3)),soldado2.getUbicacion());
//		assertEquals(Direccion.ARRIBA.calcularCoordenada(new Coordenada(2,4)),soldado3.getUbicacion());
//	}
	
}



