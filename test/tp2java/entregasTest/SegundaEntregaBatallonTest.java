package tp2java.entregasTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.modelo.tablero.*;
import tp2java.modelo.*;
import tp2java.modelo.unidades.*;


public class SegundaEntregaBatallonTest {
		
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	
	@Before
	public void setUp() {
		
		tablero = new Tablero();
		jugador1 = new Jugador("player1",0,9);
		jugador2 = new Jugador("player2",10,19);
		
	}
	
	@Test
	public void test01SeFormaBatallonSiHayTresSoldadosYSeMuevenTodosJuntos() {
		assert(true); // Desarrollar
	}
	
	@Test
	public void test02DosSoldadosSeMuevenYUnoSeQuedaQuietoPorObstruccion() {
		assert(true); // Desarrollar
	}
	
	@Test
	public void test03BatallonDejaDeExistirAnteObstruccion() {
		assert(true); // Desarrollar
	}
	
	@Test
	public void test04TeniendoCuatroOMasSoldadosSeFormaBatallonSoloConTres() {
		assert(true); // Desarrollar
	}
}