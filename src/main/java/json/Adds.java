package json;

public class Adds {

	private Integer id;
	private String message;
	
	public Adds() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adds(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Adds [id=" + id + ", message=" + message + "]";
	}
	
	
}
