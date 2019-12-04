package tp2java.entregasTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

import tp2java.modelo.tablero.*;
import tp2java.modelo.*;
import tp2java.modelo.unidades.*;


public class SegundaEntregaBatallonTest {
private SoldadoDeInfanteria soldado1,soldado2,soldado3,soldado4;
	
	private Catapulta catapulta;	
	private Tablero tablero;
	private Jugador jugador1;
	
	@Before
	public void setUp() {
		
		tablero = new Tablero();
		jugador1 = new Jugador("player1",0,9);
		
	}
	
	@Test
	public void test01SeFormaBatallonSiHayTresSoldadosYSeMuevenTodosJuntos() {
		jugador1 = new Jugador("Player1",0,9);
		Batallon batallon = new Batallon();

		tablero=new Tablero();
		soldado1 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
		soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,4),tablero);
		
		
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(soldado3);
		
		if(batallon.existeBatallon(soldado2)) {
			batallon.mover(Direccion.ABAJO);		
			
		}

    	assertEquals(Direccion.ABAJO.calcularCoordenada(new Coordenada(2,2)), soldado1.getUbicacion());
		assertEquals(Direccion.ABAJO.calcularCoordenada(new Coordenada(2,3)), soldado2.getUbicacion());
		assertEquals(Direccion.ABAJO.calcularCoordenada(new Coordenada(2,4)), soldado3.getUbicacion());
	}
	
	@Test
	public void test02DosSoldadosSeMuevenYUnoSeQuedaQuietoPorObstruccion() {
		jugador1 = new Jugador("Player1",0,9);
		tablero=new Tablero();
		Batallon batallon=new Batallon();
		
		soldado1 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
		soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,4),tablero);
		catapulta=new Catapulta(jugador1,new Coordenada(1,3), tablero);
		
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(soldado3);
		tablero.colocarUnidad(catapulta);
		
		
		if(batallon.existeBatallon(soldado2)) {
			
			batallon.mover(Direccion.IZQUIERDA);		
			
		}	
		
		assertEquals(Direccion.IZQUIERDA.calcularCoordenada(new Coordenada(2,2)), soldado1.getUbicacion());
		assertEquals(new Coordenada(2,3), soldado2.getUbicacion());
		assertEquals(Direccion.IZQUIERDA.calcularCoordenada(new Coordenada(2,4)), soldado3.getUbicacion());
		
	}
	
	@Test
	public void test03BatallonDejaDeExistirAnteObstruccion() {
		jugador1 = new Jugador("Player1",0,9);
		tablero=new Tablero();
		Batallon batallon=new Batallon();
		
		soldado1 = new SoldadoDeInfanteria(jugador1,new Coordenada(1,2),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
		soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
		catapulta=new Catapulta(jugador1,new Coordenada(1,3), tablero);
		
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(soldado3);
		tablero.colocarUnidad(catapulta);
		
		
		if(batallon.existeBatallon(soldado2)) {
			
			batallon.mover(Direccion.IZQUIERDA);		
			
		}
			

		
		assertEquals(batallon.existeBatallon(soldado3), false);
	}
	
	@Test
	public void test04TeniendoCuatroOMasSoldadosSeFormaBatallonSoloConTres() {
		jugador1 = new Jugador("Player1",0,9);
		tablero=new Tablero();
		Batallon batallon=new Batallon();
		soldado1 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,2),tablero);
		soldado2 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,3),tablero);
		soldado3 = new SoldadoDeInfanteria(jugador1,new Coordenada(2,4),tablero);
		soldado4 = new SoldadoDeInfanteria(jugador1,new Coordenada(1,4),tablero);
		
		
		tablero.colocarUnidad(soldado1);
		tablero.colocarUnidad(soldado2);
		tablero.colocarUnidad(soldado3);
		tablero.colocarUnidad(soldado4);
		
		
		if(batallon.existeBatallon(soldado2)) {
			
			batallon.mover(Direccion.DERECHA);		
			
		}
		
		
		assertEquals(Direccion.DERECHA.calcularCoordenada(new Coordenada(2,2)), soldado1.getUbicacion());
		assertEquals(Direccion.DERECHA.calcularCoordenada(new Coordenada(2,3)), soldado2.getUbicacion());
		assertEquals(Direccion.DERECHA.calcularCoordenada(new Coordenada(2,4)), soldado3.getUbicacion());
		assertEquals(new Coordenada(1, 4), soldado4.getUbicacion());
	}
}