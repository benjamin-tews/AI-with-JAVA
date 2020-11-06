import java.util.*;
import java.util.Vector;


class Train {

    private static final int x0=1; //Bias
    private static final double n=1; //bei Sprungfunktion ziemlich useless
    private static double dw0,dw1,dw2,x1,x2;
    private static int count = 1;
    private static double code = 1;


    public static void main(String[] args) {

        //Neuron = new Neuron(args[0],args[1]);
        //Input via Args laters
        calculate();
    }

    static void calculate() {
        //if Output o differs from t
        if (code != 0) {
            System.out.println("----------- " +count +". Epoche " +"-----------");
            count += 1; code = 0;
            for (int i=0; i<2; i++) {
                for (int j=0; j<2; j++) {
                    System.out.println("Anfang w-Vektor: " +dw0 +" " +dw1 +" " +dw2);
                    System.out.println("Error Counter: " +code);
                    adjustment(i, j);
                }
            }
            calculate();
        }

    }

    static void adjustment(int x1, int x2) {
        double o = 0;
        double t=0;

        //set excpected values for t *** NAND-fucntion
        if (x1 == 0 && x2 == 0) {
            t=0;
        }
        if (x1 == 0 && x2 == 1) {
            t=1;
        }
        if (x1 == 1 && x2 == 0) {
            t=1;
        }
        if (x1 == 1 && x2 == 1) {
            t=1;
        }
        System.out.println("t: " +t);
        //System.out.println("x1: " +x1 +" x2: " +x2);

        //calculate a
        //int w0x0 = w0*x0; int w1x1 = w1*x1; int w2x2 = w2*x2;
        double a = (dw0*x0) + (dw1*x1) + (dw2*x2);

        //calculate Output o

        if (a == 0) {
            o = 0;
        } else {
            o = 1;
        }

        System.out.println("a: " +a);
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
