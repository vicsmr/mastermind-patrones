package mastermind.models;

public interface Session {

	public int getWidth();

	public StateValue getStateValue();
	
	public String getName();

	public void setName(String name);

}
