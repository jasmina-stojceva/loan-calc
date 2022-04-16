package loan.calc.exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String descException;

	public ResourceNotFoundException(String desc) {
		super();
		this.descException=desc;
	}

}
