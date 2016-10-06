package simulator;
import java.util.Random;
public class Exp_random {
	public static double exp_gen(double lambda){
		Random randgen = new Random(); //init the normal random generator
		return  Math.log(1-randgen.nextDouble())/(-lambda);
	}

}
