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
        Queue queue1 = new Queue(lambda,ts,length); 
        
        //change the following comments to get the results from different runs
        
        
        
        
        /*
        //uncomment this block to get the result of a
        File file = new File("logs/mm1/simulation1_stat_log.txt"); 
        PrintWriter out;
		try {
			out = new PrintWriter(file);
			System.out.println("simulation -- 1: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length);
	    	out.println("simulation -- 1: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length + "\n");
	    	out.println("logging stats\n");
	        queue1.run(out);
	        System.out.println("Finished!!!!!!!");
	        System.out.println("Log: logs/mm1/simulation1_log.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		*/
        
        
        
		/*
		//b   uncomment this block to get the result of b
		lambda = 6.0;
        Queue queue2 = new Queue(lambda,ts,length);    
        
        File file2 = new File("logs/mm1/simulation2_stat_log.txt"); 
        PrintWriter out2;
		try {
			out2 = new PrintWriter(file2);
			System.out.println("simulation -- 2: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length);
	    	out2.println("simulation -- 2: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length + "\n");
	    	out2.println("logging stats\n");
	        queue2.run(out2);
	        System.out.println("Finished!!!!!!!");
	        System.out.println("Log: logs/mm1/simulation2_log.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		*/
		
		
        
        
		//c uncomment the block below to get the result of c
        
        
		///*  
		lambda = 6.0;
		ts = 0.2;
        Queue queue3 = new Queue(lambda,ts,length);    
        
        File file3 = new File("logs/mm1/simulation3_stat_log.txt"); 
        PrintWriter out3;
		try {
			out3 = new PrintWriter(file3);
			System.out.println("simulation -- 3: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length);
	    	out3.println("simulation -- 3: lambda = " + lambda + ", Ts = " + ts + ", Sim length = " + length + "\n");
	    	out3.println("logging stats\n");
	        queue3.run(out3);
	        System.out.println("Finished!!!!!!!");
	        System.out.println("Log: logs/mm1/simulation3_log.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//*/
	}

}
