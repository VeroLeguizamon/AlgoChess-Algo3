package tp2java.entregasTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import tp2java.modelo.tablero.*;
import tp2java.modelo.*;
import tp2java.modelo.unidades.*;

public class PrimeraEntregaTest {
	
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	
	@Before
	public void setUp() {
		
		tablero = new Tablero();
		jugador1 = new Jugador("player1",0,9);
		jugador2 = new Jugador("player2",10,19);
		
	}
	
	// Pruebas Entidades
	@Test
	public void test00UnidadMovibleSeMueveHaciaAbajoUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.mover(Direccion.ABAJO);
		assertEquals(jinete.getUbicacion(), new Coordenada(5,4));	
		
	}
	@Test
	public void test01UnidadMovibleSeMueveHaciaArribaUnCasilleroExitosamente() {
			
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.mover(Direccion.ARRIBA);
		assertEquals(jinete.getUbicacion(), new Coordenada(5,6));	
		
	}
	@Test
	public void test02UnidadMovibleSeMueveHaciaLaDerechaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.mover(Direccion.DERECHA);
		assertEquals(jinete.getUbicacion(), new Coordenada(6,5));	
		
	}
	@Test
	public void test03UnidadMovibleSeMueveHaciaLaIzquierdaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.mover(Direccion.IZQUIERDA);
		assertEquals(jinete.getUbicacion(), new Coordenada(4,5));
		
	}
	@Test
	public void test04UnidadMovibleSeMueveEnDiagonalArribaDerechaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.mover(Direccion.ARRIBA_DERECHA);
		assertEquals(jinete.getUbicacion(), new Coordenada(6,6));
		
	}
	@Test
	public void test05UnidadMovibleSeMueveHaciaDiagonalArribaIzquierdaUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.mover(Direccion.ARRIBA_IZQUIERDA);
		assertEquals(jinete.getUbicacion(), new Coordenada(4,6));
		
	}
	@Test
	public void test06UnidadMovibleSeMueveHaciaDiagonalAbajoDerechoUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.mover(Direccion.ABAJO_DERECHA);
		assertEquals(jinete.getUbicacion(), new Coordenada(6,4));
		
	}
	@Test
	public void test07UnidadMovibleSeMueveHaciaDiagonalAbajoIzquierdoUnCasilleroExitosamente() {
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jinete.mover(Direccion.ABAJO_IZQUIERDA);
		assertEquals(jinete.getUbicacion(), new Coordenada(4,4));
		
	}
	@Test
	public void test08UnidadMovibleNoPuedeMoverseACasilleroOcupadoExitosamente() {
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador1, new Coordenada(6,5),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		jugador1.comprarUnidad(soldado);
		tablero.colocarUnidad(soldado);
		jinete.mover(Direccion.DERECHA);
		
		assertTrue(true);
		
	}
	@Test
	public void test09SoldadoDeInfanteriaAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Jinete jinete = new Jinete(jugador1,new Coordenada(5,5),tablero);
		jinete.setJugador(new Jugador("player1",0,9));
		
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador2,new Coordenada(6,5),tablero);
		soldado.setJugador(new Jugador("player2",10,19));
		
		soldado.atacar(jinete);
		assertEquals(jinete.getVida(), 90);
		
	}
	@Test
	public void test10JineteAliadoAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,5),tablero);		
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador2, new Coordenada(6,5),tablero);
		
		jinete.atacar(soldado);
		assertEquals(soldado.getVida(), 95);
		
	}
	@Test
	public void test11CatapultaAliadaAtacaAPiezaEnemigaYRestaPuntosExitosamente() {
		
		Catapulta catapulta = new Catapulta(jugador1, new Coordenada(5,5),tablero);
		
		Curandero curandero = new Curandero(jugador2, new Coordenada(15,15),tablero);
		
		catapulta.atacar(curandero);
		assertEquals(curandero.getVida(), 55);
		
	}
	@Test
	public void test12CuranderoAliadoCuraAPiezaAliadaYSumaPuntosExitosamente() {
		
		Curandero curandero = new Curandero(jugador1, new Coordenada(5,5),tablero);
		Jinete jinete = new Jinete(jugador1, new Coordenada(5,6),tablero);
		
		curandero.curar(jinete);
		assertEquals(jinete.getVida(), 115);
		
	}
	
	// Pruebas Tablero
	@Test
	public void test13TableroColocaPiezaAliadaEnZonaAliadaVaciaExitosamente() {
		Tablero tablero = new Tablero();
		
		Jinete jinete = new Jinete(jugador1, new Coordenada(0,0), tablero);
		jugador1.comprarUnidad(jinete);
		
		tablero.colocarUnidad(jinete);
		
		Assert.assertEquals(tablero.cantUnidades(), 1);
		
	}
	@Test 
	public void test14TableroNoPuedeColocarPiezaAliadaEnCasilleroAliadoOcupadoExitosamente() {
		Tablero tablero = new Tablero();
		
		Jinete jinete = new Jinete(jugador1,new Coordenada(0,0),tablero);
		jugador1.comprarUnidad(jinete);
		tablero.colocarUnidad(jinete);
		
		Catapulta catapulta = new Catapulta(jugador2,new Coordenada(0,0),tablero);
		tablero.colocarUnidad(catapulta);
		
		assertEquals(tablero.cantUnidades(),1);
	}
	
	@Test
	public void test15TableroNoPuedeColocarPiezaAliadaEnUnCasilleroDelSectorEnemigo() {
		Tablero tablero = new Tablero();
		
		Jinete jinete = new Jinete(jugador1,new Coordenada(15,0),tablero);
		jugador1.comprarUnidad(jinete);
		
		tablero.colocarUnidad(jinete);
		
		assertEquals(0,tablero.cantUnidades());
	}
	
	@Test
	public void test16TableroSeCreaEIniciaCorrectamente () {
		Tablero tablero = new Tablero();
		Assert.assertEquals(tablero.cantUnidades(), 0);
	}
	
	// Pruebas Jugador 	
	@Test
	public void test17JugadorNoPuedeTomarMasEntidadesDeLoQuesusPuntosLePermiteExitosamente() {

		Tablero tablero = new Tablero();
		Jinete jinete = new Jinete(jugador1,new Coordenada(0,0),tablero);
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(jugador1,new Coordenada(0,1),tablero);
		Catapulta catapulta = new Catapulta(jugador1,new Coordenada(0,2),tablero);
		
		jugador1.comprarUnidad(jinete);//17
		jugador1.comprarUnidad(soldado);//16
		jugador1.comprarUnidad(soldado);//15
		jugador1.comprarUnidad(catapulta);//10
		jugador1.comprarUnidad(catapulta);//5
		jugador1.comprarUnidad(catapulta);//0
		jugador1.comprarUnidad(jinete); // 0
		Assert.assertEquals(6,jugador1.cantidadDeUnidades());
	}
	@Test
	public void test18JugadorSinEntidadesResultaSerPerdedor() {
		
		Jinete jinete = new Jinete (jugador1,new Coordenada(0,0),tablero);
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria (jugador2,new Coordenada(0,1), tablero);
		
		jugador1.comprarUnidad(jinete);
		
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		soldado.atacar(jinete);
		
		Assert.assertTrue(jugador1.esPerdedor());
	}

}
