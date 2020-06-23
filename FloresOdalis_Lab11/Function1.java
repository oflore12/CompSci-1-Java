




public class Function1 extends Function {

	@Override
	public double fnValue(double x) {
		if (x==0.0) 
			return Double.MAX_VALUE;
		else 
			return (0.8 * (Math.PI * (Math.pow(x, 2))) + (800/x));
		
	}
	
	public String toString() {
		return "Minimize the cost of a can that will hold 2 liters of liquid";
	}
	
	public String answerString(double cost, double radius, double height, double z) {
		String stg= "The minimun cost is "+ String.format("$%,.2f", cost)
		+ " with height of "+ String.format("%.2f",height)
				+" cm and radius is "+ String.format("%.2f",radius) +" cm";
		return stg;
	}
	
	public double getXVal(double x) {
		return x;
	}
	
	public double getYVal(double x) {
		return 2000 / ( Math.PI * (Math.pow(x,2)));
	}
	
	public double getZVal(double x) {
		return -1.0;
	}

}
