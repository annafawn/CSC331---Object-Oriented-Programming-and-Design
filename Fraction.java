package assignment1;

/**
 * This class provides storage for the representation of and 
 * methods to manipulate fractions. A fraction consists of two 
 * integers: one for the numerator and one for the denominator.
 * Ex) 1/2
 * 
 * @author Anna Phan
 *
 */
public class Fraction {
	
	// Properties
	/**
	 * The integer value for numerator
	 */
	private int num;
	/**
	 * The integer value of denominator
	 */
	private int den;
	
	// Constructor
	/**
	 * This constructor catches the cases where two parameters of 
	 * type integer are given when instantiating a fraction object.
	 * @param num - the numerator value
	 * @param den - the denominator value
	 */
	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
		reduce();
	}
	
	// Overloaded Constructor
	/**
	 * This constructor catches the cases in which only one parameter 
	 * of type double is given when instantiating a fraction object.
	 * @param decimal - the decimal value that is converted to a fraction
	 */
	public Fraction (double decimal) {
		String s = String.valueOf(decimal);
		int digitsDec = s.length() - 1 - s.indexOf('.');
		int den = 1;
		for (int i = 0; i < digitsDec; i++) {
			decimal *= 10;
			den *= 10;
		}
		
		int num = (int) Math.round(decimal);
		this.num = num;
		this.den = den;
		reduce();
	}
	
	// Methods

	public String toString() {
		return num + "/" + den;
	}
	
	/**
	 * This method converts a fraction to it's equivalent 
	 * decimal value.
	 * @return - the decimal format of a fraction
	 */
	public double toDecimal() {
		double result;
		result = (double) num / den;
		return result;
	}

	/**
	 * This method reduces the fraction to it's simplest 
	 * form by calculating the greatest common factor (gcf) of 
	 * the object's numerator and denominator and dividing 
	 * the gcf from both the numerator and denominator.
	 */
	private void reduce() {
		int i = Math.min(Math.abs(num), Math.abs(den));
		if (i == 0)
			return;
		while ((num % i != 0) || (den % i != 0))
			i--;
		this.num = num / i;
		this.den = den / i;
	}

	/**
	 * This method adds two fraction objects.
	 * @param other - the other fraction object
	 * @return - the sum of two fractions
	 */
	public Fraction add(Fraction other) {
		int newNumerator = (num * other.den) + (den * other.num);
		int newDenominator = (den * other.den);
		return new Fraction(newNumerator, newDenominator);
	}

	/**
	 * This method multiplies two fraction objects.
	 * @param other - the other fraction object
	 * @return - the product of the two fractions
	 */
	public Fraction mult(Fraction other) {
		int newNumerator = (num * other.num);
		int newDenominator = (den * other.den);
		return new Fraction(newNumerator, newDenominator);
	}

	/**
	 * This method subtracts the parameter fraction object from 
	 * the recipient fraction object.
	 * @param other - the fraction object that is to be subtracted 
	 * from the recipient fraction object
	 * @return - the result of the difference between the two fractions
	 */
	public Fraction sub(Fraction other) {
		int newNumerator = (num * other.den) - (den * other.num);
		int newDenominator = den * other.den;
		return new Fraction(newNumerator, newDenominator);
	}
	
	/**
	 * This method divides the parameter fraction object from 
	 * the recipient fraction object by cross multiplication.
	 * @param other - the fraction object that is to be divided from 
	 * the recipient fraction object
	 * @return - the result of the division of two fractions
	 */
	public Fraction div(Fraction other) {
		int newNumerator = num * other.den;
		int newDenominator = den * other.num;
		return new Fraction(newNumerator, newDenominator);
	}

	/**
	 * This method compares two fraction objects and returns an integer value 
	 * which has a boolean meaning attached to it.
	 * The value "1" represents true, "0" represents equality, and "-1"
	 * represents false.
	 * @param other - the fraction object that will on the right of the 
	 * boolean operator
	 * @return - one of three integer values: "1" if true, "0" if equal, "-1" if false
	 */
	public int compareTo(Fraction other) {
		double f1;
		double f2;
		f1 = (double) num / den;
		f2 = (double) other.num / other.den;
		if (f1 > f2) {
			return 1;
		} else if (f1 == f2) {
			return 0;
		} else {
			return -1;
		}
	}

}
