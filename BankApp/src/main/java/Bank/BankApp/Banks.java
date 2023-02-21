package Bank.BankApp;

public abstract class Banks {
	
	private String name;
	
	
	public Banks(String name) {
		super();
		this.name = name;
	}

	public String getName()
	{
		
		if (name == null) {
			
			return null;
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
