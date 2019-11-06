package tp2java.excepciones;

public class CeldaNoPerteneceAlSector extends MovimientoInvalido {

	@Override
	public String getMessage() {
		return message;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message = "La entidad pertenece a otro sector";

}
