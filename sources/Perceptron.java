import java.util.*;
import java.util.Vector;


class Perceptron {

    private static final int x0=1; //Bias
    private static double n = 1; //useless if we use Jump Function
    private static double dw0,dw1,dw2;
    private static int count = 1;
    private static double code = 1;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Welche Funktion wollen Sie trainieren? \n(1) AND \n(2) OR \n(3) NAND \n(4) NOR      ");
        int r1 = sc.nextInt();
        System.out.println("Welche Lernrate wollen Sie nutzen (Double Wert von 0.1 bis 10.0)?");
        n = sc.nextDouble();
        System.out.println("Welche Funktion wollen Sie nutzen?  \n(1) Sprungfunktion \n(2)Heawiesite Funktion ");
        double r2 = sc.nextInt();
        //Neuron = new Neuron(args[0],args[1]);
        //Input via Args laters
        dw0 = 1;
        dw1 = 1;
        dw2 = 1;
        calculate();
    }

    static void calculate() {
        //if Output o differs from t
        if (code != 0) {
            if (count < 50) { //security hook
                System.out.println("----------- " +count +". Epoche " +"-----------");
                count += 1; code = 0;
                for (int i=0; i<2; i++) {
                    for (int j=0; j<2; j++) {
                        System.out.println("Anfang w-Vektor: " +dw0 +" " +dw1 +" " +dw2);
                        //System.out.println("Error Counter: " +code);
                        adjustment(i, j);
                    }
                }
                calculate();
            }
        }

    }

    static void adjustment(int x1, int x2) {
        int o = 0;
        double t=0;

        //set excpected values for t *** NAND-fucntion
        if (x1 == 0 && x2 == 0) {
            t=1;
        }
        if (x1 == 0 && x2 == 1) {
            t=1;
        }
        if (x1 == 1 && x2 == 0) {
            t=1;
        }
        if (x1 == 1 && x2 == 1) {
            t=0;
        }
        //System.out.println("t: " +t);
        System.out.print("x1: " +x1 +" x2: " +x2 +"\n");

        //calculate a
        int a = (int) ((dw0*x0) + (dw1*x1) + (dw2*x2));

        //calculate Output o with Jump Function
        if (a < 1) {
            o = 0;
        } else {
            o = 1;
        }

        //System.out.println("a: " +a);
        System.out.println("o: " +o);

        //calculate Error e
        double e = (t - o);
        System.out.println("e: " +e);

        code = code + Math.abs(e);

        //calculate delta w-Vector
        dw0 += n*e*x0;
        dw1 += n*e*x1;
        dw2 += n*e*x2;

    }

}
