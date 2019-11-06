package tp2java_v1.excepciones;

public class CeldaNoPerteneceAlSector extends RuntimeException {

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
