package simulator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

public class Event {
	public double birth_time;
	public double service_time;
	public double death_time;
	public String state_type;
	
	public Event (double b, String state){
		this.birth_time = b;
		this.state_type = state;
	}
	
	
	//This set of methods are for Querying the state_type of each event
	
	public boolean isBirth(Event a){
		return a.state_type.equals("Birth");
	}
	
	public boolean isDeath(Event a){
		return a.state_type.equals("Birth");
	}
	
	public boolean isInqueue(Event a){
		return a.state_type.equals("Inqueue");
	}

}

