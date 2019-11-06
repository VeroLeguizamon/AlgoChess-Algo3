package tp2java.excepciones;

public class CeldaEstaOcupadaExcepcion extends MovimientoInvalido {

	@Override
	public String getMessage() {
		return message;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message = "La celda esta ocupada";

}
