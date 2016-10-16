package simulator;
import java.io.*;
import java.util.*;

public class simulator_mm1 {
	public static void main(String[] args){
    	
        File dir = new File("logs");
        if (!dir.exists()) {
        	dir.mkdir();
        }
        
        File dir2 = new File("logs/mm1");
        if (!dir2.exists()) {
        	dir2.mkdir();
        }
    	//Simulation 1: Lambda = 60 and Ts = 0.015 and simulation time = 100
        double lambda = 5;
        double ts = 0.15;
        double length = 1000;        
        Queue queue1 = new Queue(lambda,ts,length);    
        
        File file = new File("logs/mm1/sim1_log.txt"); 
        PrintWriter out;
		try {
			out = new PrintWriter(file);
			System.out.println("SIMULATION 1: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length);
	    	out.println("SIMULATION 1: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length + "\n");
	    	out.println("LOG STATISTICS\n");
	        queue1.run(out);
	        System.out.println("DONE.");
	        System.out.println("Log: logs/mm1/sim1_log.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}
