/**
 * Function1 extends from function, this will use a f(x) function to calculate 
 * local extrema based on the function. It will send strings for answer and word problem.
 * @author O_Flores96
 * Name: Odalis Flores
 * Class: CMSC 203
 * CRN: 202030
 * Assignment 6 LC
 * Professor: Robert Alexander
 *
 */
public class Function1 extends Function {
	@Override
	/**
	 * fnValue is a method that returns the optimal value of the function f(x)
	 * function is x/8 + ((1/3) * square root(x^2-12x+40))
	 * @param x is the x-value of local extrema
	 * @returns the minimum value, in this case time.
	 */
	public double fnValue(double x) {
		if (x==0.0) 
			return Double.MAX_VALUE;
		else 
			return (x/8.0) + ((1.0/3.0)* (Math.sqrt( (Math.pow(x, 2) - 12*x + 40) ) ) );
	}
	/**
	 * toString will display the word problem that we are minimizing
	 */
	public String toString() {
		return "Find the minimum amount of time it will take a person to get to an island"
				+" from the cabin, if they run at a speed of 8 mph and swim at a rate of 3 mph.";
	}
	/**
	 * AnswerString is the method that displays the local extrema and the coordinates
	 * @param optval the minimum time for f(x)
	 * @param x value represents the distance to run
	 * @param y value represents the distance to swim
	 * @param z value 
	 * @return the string of answers
	 */
	public String answerString(double optVal, double x, double y, double z) {
		String stg= "The minimum amount of time it will take to get"
				+" to an island from the cabin is " + String.format("%.2f",optVal) 
				+" hours, and it occurs when the person runs a distance of  "
				+String.format("%.2f",x )+" miles and swims a distance of "
				+String.format("%.2f",y )+" miles.";
		return stg;
	}
	/**
	 * getXValue is the getter for x value
	 * @param x is the x value 
	 * @return x
	 */
	public double getXVal(double x) {
		return x;
	}
	/**
	 * getYValue gets the y value
	 * @param x is the x value
	 * @return the value of square root(x^2-12x+40))
	 */
	public double getYVal(double x) {
		return (Math.sqrt( (Math.pow(x, 2) - 12*x + 40) ));
	}
	/**
	 * getZvalue is used to conform the function class
	 * this method is not relevent to the problem
	 * @param x the x value
	 * @return -1
	 */
	public double getZVal(double x) {
		return -1.0;
	}
}
