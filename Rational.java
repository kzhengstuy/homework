public class Rational {
    public int numerator;
    public int denominator;

    public Rational() {
	numerator = 0;
	denominator = 1;
    }

    public Rational( int n, int d ) {
        _numerator = n;
        if ( d == 0 ) {
            System.out.println( "Invalid number. " +
                                "Setting denominator to 1." );
            _denominator = 1;
        }
        else {
            _denominator = d;
        }
    }

    public String toString() {
	return numerator + "/" + denominator;
    }

    public long floatValue() {
    	return (double)(numerator/denominator);
    }
    
     public void multiply( Rational r ) {
        _numerator = this._numerator * r._numerator;
        _denominator = this._denominator + r._denominator;
    }


    public void divide( Rational r ) {
        if ( r._numerator != 0 ) {
            _numerator = _numerator * r._denominator;
            _denominator = _denominator * r._numerator;
        }
        else {
            System.out.println( "Div by 0 error. Values unchanged." );
        }
    }


    public void add( Rational r ) {
        _numerator = _numerator * r._denominator + r._numerator * _denominator;
        _denominator = _denominator * r._denominator;
    }


    public void subtract( Rational r ) {
        _numerator = _numerator * r._denominator - r._numerator * _denominator;
        _denominator = _denominator * r._denominator;
    }

   public int gcd() {

        int a, b, x;

        if ( _numerator > _denominator ) {
            a = _numerator;
            b = _denominator;
        }
        else {
            a = _denominator;
            b = _numerator;
        }

        while( a % b != 0 ) {
            x = a;
            a = b;
            b = x % b;
        }

        return b;
    }


    public void reduce() {
        int g = gcd();
        _numerator = _numerator / g;
        _denominator = _denominator / g;
    }


    public static int gcd( int n, int d ) {

        int a, b, x;

        if ( n > d ) {
            a = n;
            b = d;
        }
        else {
            a = d;
            b = n;
        }

        while( a % b != 0 ) {
            x = a;
            a = b;
            b = x % b;
        }

        return b;
    }


    public int compareTo( Rational other ) {

        int thisNumerator, otherNumerator;

        thisNumerator = _numerator * other._denominator;
        otherNumerator = _denominator * other._numerator;

        return thisNumerator - otherNumerator;

    }

}
