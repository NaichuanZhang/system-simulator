package simulator;
import java.util.*;
import java.io.*;
public class Queue{
    public static final int BIRTH = 0; // represents arrival
    public static final int DEATH = 1; // represents departure
	LinkedList<Event> schedule_queue; // initialize the queue
	double currentTime;
	double endTime;             // the end time for the simulation 
	double lambda;				// the arrival rate
	double ts;					// the average service time 
	double nextArrvial;		// the arrival time for the next scheduled event
	double nextLeft;			// the time for the next scheduled event to leave
	
	
    ArrayList<Double> cpt;			// list of monitoring checkpoint times (Check_count)
    int Check_count;					// number of checkpoint 
	
	double Tw;
	double Ts;					// average service time
	double Tq;
	int w, q;
	
	int request_count;
	int served_count;
	
	
	public Queue(double lambda, double Ts, double endTime){
		this.lambda = lambda;
		this.Ts = Ts;
		this.endTime = endTime;
		
		
        cpt = new ArrayList<Double>();      
        double n = 0;
        while (n < 2*endTime) {
        	Check_count++;
        	n += Exp_random.exp_gen(lambda);
        	cpt.add(n);
        }
		
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
	
	public void death_calender(double arrivalTime){
    	nextLeft = currentTime + Exp_random.exp_gen(1/ts);
        schedule_queue.addFirst(new Event(nextLeft,"Death"));
        served_count++;
        Tq += (nextLeft - arrivalTime);
        Tw += (currentTime - arrivalTime);
        Ts += (nextLeft - currentTime);
		
	}
	
    public void monitor(PrintWriter out) {
    	int cur_q = schedule_queue.size();
    	int cur_w = (cur_q > 0) ? (schedule_queue.size() - 1) : 0;
    	w += cur_w;
    	q += cur_q;
    	cpt.remove(0);
    	System.out.println("Check-point time: " + currentTime);
    	System.out.println("\tnum waiting (w): " + cur_w);
    	
    }
	
    
    
    public void run(PrintWriter out) {
    	while (currentTime < 2*endTime) {
    		if (cpt.get(0) < nextArrvial && cpt.get(0) < nextLeft) {
    			currentTime = cpt.get(0);
        		System.out.println("\tmonitoring at " + currentTime);
    			monitor(out); 			
    		}
    		else if (nextArrvial <= nextLeft) { // an object has arrived to the system
            	currentTime = nextArrvial;
        		out.println("\tarrival at " + currentTime);
            	birth_gen(nextArrvial); 
            	request_count++;
            }
            else {	// element has been serviced, remove it from queue
            	currentTime = nextLeft;
        		out.println("\tdeparture at " + currentTime);
            	death_gen();
            }           
    	}
    	
    	print_info(out);
    	System.out.close();
    }
	
    
    public void print_info(PrintWriter out){
    	out.println("\nResults from M/M/1 Simulation");
    	out.println("w = " + w/Check_count);
    	out.println("q = " + q/Check_count);
    	out.println("Tw = " + Tw/request_count);
    	out.println("Tq = " + Tq/served_count);
    	out.println("Ts = " + Ts/served_count);

    	System.out.println("Results from M/M/1 Simulation");
    	System.out.println("requests: " + request_count);
    	System.out.println("w = " + w/Check_count + "  requests");
    	System.out.println("q = " + q/Check_count + "  requests");
    	System.out.println("Tw = " + Tw/request_count + " sec");
    	System.out.println("Tq = " + Tq/served_count + "  sec");
    	System.out.println("Ts = " + Ts/served_count+ "  sec");    	
    }
	
	
}