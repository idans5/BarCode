package Classes;

public class ClubClient {
	
	private String clientId;
	private String clientFirstName;
	private String clientLastName;
	private String clientPhoneNumber;
	private String clientDateAdded;
	
	public ClubClient(StringBuilder builder) 
	{
		String[] lines = builder.toString().split("\\n");
		
		this.clientId = lines[0];
		this.clientFirstName = lines[1];
		this.clientLastName = lines[2];
		this.clientPhoneNumber = lines[3];
		this.clientDateAdded = lines[4];
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getClientFirstName() {
		return clientFirstName;
	}
	
	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}
	
	public String getClientLastName() {
		return clientLastName;
	}
	
	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}
	
	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}
	
	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}
	
	public String getClientDateAdded() {
		return clientDateAdded;
	}
	
	public void setClientDateAdded(String clientDateAdded) {
		this.clientDateAdded = clientDateAdded;
	}

}
