package simulator;


public class Event {
	public double time;
	//public double service_time;
	//public double death_time;
	public int state_type;
	
	public Event (double t, int state){
		this.state_type = state;
		this.time = t;
	}
	
	public double getTime(){
		return time;
	}
	
	public int getState(Event a){
		return state_type;
	}
	
	
	//This set of methods are for Querying the state_type of each event
	/*
	public boolean isBirth(Event a){
		return a.state_type.equals("Birth");
	}
	
	public boolean isDeath(Event a){
		return a.state_type.equals("Birth");
	}
	
	public boolean isMonitor(Event a){
		return a.state_type.equals("Monitor");
	}
    */
}



