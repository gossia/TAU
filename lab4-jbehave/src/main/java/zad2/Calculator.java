package zad2;

public class Calculator {
	
	private double a;
	private double b;
	
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
	public double add(){
		return a + b;
	}
	
	public double sub(){
		return a - b;
	}
	
	public double multi(){
		return a * b;
	}
	
	public double div(){
		try {
			return a / b;
		}
		catch (ArithmeticException e) {
			return Double.POSITIVE_INFINITY;
		}
	}
	
	public boolean greater(){
		if (a > b)
			return true;
		else
			return false;
	}

}
