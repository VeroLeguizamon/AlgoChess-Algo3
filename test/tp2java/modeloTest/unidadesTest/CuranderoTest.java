package tp2java.modeloTest.unidadesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;

import tp2java.modelo.tablero.Coordenada;
import tp2java.modelo.tablero.Tablero;
import tp2java.modelo.Jugador;
import tp2java.modelo.unidades.Curandero;

public class CuranderoTest {
	
	private Curandero curandero1;
	private Curandero curandero2;
	private Tablero mockTablero;
	private Jugador mockJugador;
	
	@Before
	public void setUp() {
		
		mockTablero = mock(Tablero.class);
		mockJugador = mock(Jugador.class);
		curandero1 = new Curandero(mockJugador,new Coordenada(2,2),mockTablero);
		curandero2 = new Curandero(mockJugador,new Coordenada(3,2),mockTablero);
		
	}
	
	@Test
	public void testCurandero1CuraACurandero2YEsteUltimoRecuperaVida() {
		
		curandero1.curar(curandero2);
		assertEquals(curandero2.getVida(),90);
		
	}
	
	@Test
	public void testCuranderoRecuperaVidaCorrectamente() {
		
		curandero1.recuperarVida(15);
		assertEquals(curandero1.getVida(),90);
		
	}
	
}
