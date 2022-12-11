import java.text.DecimalFormat;

public class GoldenSection {
    public static int terms;
    public static String equation;
    public static String finalValue;
    public static double[] coefficients;
    public static int[] exponents;
    public static double interval1;
    public static double interval2;
    public static int iteration;

    public static void main(String[] args) {
        UserInterface.userInput();
    }

    public static void start(String function, int lower, int upper, int iterations){
        functionValue(function);
        interval1 = lower;
        interval2 = upper;
        iteration = iterations;
        equation = function;
        compute();
    }

     /**
     * Method for computation following golden-section search algorithm
     */
    public static void compute() {
        double xl, xu;
        double d = 0;
        double x1 = 0, x2 = 0;
        double fx1 = 0, fx2 = 0;
        String storage = "";

        storage += "\nEquation: "+ equation;
        storage += "\nInterval: ("+ (int) interval1 +", "+ (int) interval2 +")";

        storage += String.format("\n%5s %10s %10s %10s %10s %10s %11s %10s\n","iter", "xl", "xu", "d", "x1", "x2", "f(x1)", "f(x2)");

        for (int x = 1; x < iteration+1; x++) {
            xl = interval1;
            xu = interval2;
            d = (0.6180339887) * (xu - xl);
            x1 = xl + d;
            x2 = xu - d;

            System.out.println("xu: " +xu);
            fx1 = 0;
            for (int i = 0; i < coefficients.length; i++) {
                fx1 += coefficients[i] * Math.pow(x1, exponents[i]);
            }
            fx2 = 0;
            for (int j = 0; j < coefficients.length; j++) {
                fx2 += coefficients[j] * Math.pow(x2, exponents[j]);
            }

            storage += String.format("%4d %13.4f %10.4f %10.4f %10.4f %10.4f %10.4f %10.4f\n", x, xl, xu, d, x1, x2, fx1, fx2);

            if (fx1 > fx2) {
                interval1 = x2;
            } else {
                interval2 = x1;
            }
        } // end of for loop

        storage +="\n------------------------------------------------------";
        storage += "\n --> Therefore, the optimum point is ";
        if (fx1 > fx2) {
            storage += String.format("%s %2.2f %s %2.2f %s","(", x1, ",", fx1, ")");
        } else {
            storage += String.format("%s %2.2f %s %2.2f %s","(", x2, ",", fx2, ")");
        }
        storage += "\n------------------------------------------------------\n";

        finalValue = storage;
    } // end of compute method

    
    private static void functionValue(String function){
        String[] storage = function.split("[/]");
        coefficients = new double[storage.length];
        exponents = new int[storage.length];


        for(int i = 0; i < storage.length; i++){
            String[] test = storage[i].split("[x^]");
            if(test.length > 1) {
                coefficients[i] = Double.parseDouble(test[0]);
                exponents[i] = Integer.parseInt(test[2]);
            } else {
                coefficients[i] = Double.parseDouble(test[0]);
                exponents[i] = 1;
            }
        }
    }
}
