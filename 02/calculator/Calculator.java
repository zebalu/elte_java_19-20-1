package calculator;

public class Calculator {

    public static void main(String[] args) {
        if(args.length < 2) {
            System.err.println("Túl kevés változó!");
            throw new IllegalArgumentException("Ennyi változóval nem megyek semmire!");
            //return ;
        }
        double sum = 1.0;
        String operator = args[0];
        if(!operator.equals("-")) {
            sum = Double.parseDouble(args[1]);
	} else {
	    sum = -Double.parseDouble(args[1]);
	}
	for(int i=2; i<args.length; ++i) {
	    System.out.println("args["+i+"]="+args[i]);
	    double j = Double.parseDouble(args[i]);
	    if(operator.equals("+")) {
	        sum = add(sum, j);
	    } else if("-".equals(operator)) {
	        sum = minus(sum, j);
	    } else if("*".equals(operator)) {
	        sum = mul(sum, j);
	    } else if("/".equals(operator)) {
	        sum = div(sum, j);
	    } else {
	        System.err.println("ismeretlen operator");
	    }
	}
	System.out.println("Szumma: "+sum);
    }
    
    private static double add(double sum, double num) {
        return sum + num;
    }
    
    private static double minus(double sum, double num) {
        return sum - num;
    }
    
    private static double mul(double sum, double num) {
        return sum * num;
    }
    
    private static double div(double sum, double num) {
        return sum / num;
    }
}
