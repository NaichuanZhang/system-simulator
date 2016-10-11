package simulator;
import java.util.*;
import java.io.*;
public class Queue{
	LinkedList<Event> schedule_queue; // initialize the queue
	double currentTime;
	double endTime;             // the end time for the simulation 
	double lambda;				// the arrival rate
	double ts;					// the average service time 
	double nextArrvial;		// the arrival time for the next scheduled event
	double nextLeft;			// the time for the next scheduled event to leave
	
	double Tw;
	double Ts;					// average service time
	double Tq;
	int w, q;
	
	public Queue(double lambda, double Ts, double endTime){
		this.lambda = lambda;
		this.Ts = Ts;
		this.endTime = endTime;
		
		currentTime =0;
		schedule_queue = new LinkedList<Event>();
		nextArrvial = Exp_random.exp_gen(lambda);
		nextLeft = Double.POSITIVE_INFINITY; // nothing scheduled 
		Tq = 0;
		Tw = 0;
		Ts = 0;
		w = 0;
		q = 0;
		
	}
	
	
	
	public void birth_gen(double t){
		if(schedule_queue.isEmpty()){
			death_calender(t);  // schedule the next death event
		}
		else{
			schedule_queue.add(new Event(t,"Birth"));
		}
		nextArrvial +=Exp_random.exp_gen(lambda);
	}
	
	public void death_gen(){
		schedule_queue.pop();
		if(!schedule_queue.isEmpty()){
			Event next = schedule_queue.pop();
			death_calender(next.getTime());
		}
		
	}
}