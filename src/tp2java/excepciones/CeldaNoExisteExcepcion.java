package tp2java.excepciones;

public class CeldaNoExisteExcepcion extends MovimientoInvalido{
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "La celda que intenta alcanzar no existe";
}
