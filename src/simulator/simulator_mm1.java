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
        double lambda = 5.0;
        double ts = 0.15;
        double length = 1000;        
        Queue queue = new Queue(lambda,ts,length); 
        
        //change the following comments to get the results from different runs
        
        
        
        
        
        //uncomment this block to get the result of a
        File file = new File("logs/mm1/simulation1_stat_log.txt"); 
        PrintWriter out;
		try {
			out = new PrintWriter(file);
			System.out.println("simulation -- 1: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length);
	    	out.println("simulation -- 1: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length + "\n");
	    	out.println("logging stats\n");
	        queue.run(out);
	        System.out.println("Finished!!!!!!!");
	        System.out.println("Log: logs/mm1/simulation1_log.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
        
        
        
		
		//b   uncomment this block to get the result of b
		lambda = 6.0;
        queue = new Queue(lambda,ts,length);    
        
        file = new File("logs/mm1/simulation2_stat_log.txt"); 
		try {
			out = new PrintWriter(file);
			System.out.println("simulation -- 2: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length);
	    	out.println("simulation -- 2: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length + "\n");
	    	out.println("logging stats\n");
	        queue.run(out);
	        System.out.println("Finished!!!!!!!");
	        System.out.println("Log: logs/mm1/simulation2_log.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	
		
		
        
        
		
        
        
		//c
		lambda = 6.0;
		ts = 0.2;
        queue = new Queue(lambda,ts,length);    
        
        File file3 = new File("logs/mm1/simulation3_stat_log.txt"); 
		try {
			out = new PrintWriter(file3);
			System.out.println("simulation -- 3: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length);
	    	out.println("simulation -- 3: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length + "\n");
	    	out.println("logging stats\n");
	        queue.run(out);
	        System.out.println("Finished!!!!!!!");
	        System.out.println("Log: logs/mm1/simulation3_log.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	
	}

}
