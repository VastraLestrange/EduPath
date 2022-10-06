import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Driver {
	public static void main(String [] args) {
		Polynomial p = new Polynomial();
		System.out.println(p.evaluate(3));
		double [] c1 = {6, 3};
        int [] e1 = {2, 5};
		Polynomial p1 = new Polynomial(c1, e1);
		double [] c2 = {8, 7, 16};
        int [] e2 = {3, 2, 5};
		Polynomial p2 = new Polynomial(c2, e2);

		Polynomial s = p1.add(p2);
		System.out.println("s(0.1) = " + s.evaluate(0.1));

        // for(int i = 0; i < 12; i++){
        //     System.out.println("coeff: " + s.arr_coeff[i] + "\n");
        //     System.out.println("exp: " + s.arr_exp[i] + "\n\n\n");
        // }

        Polynomial m = p1.multiply(p2);
        System.out.println("m(0.1) = " + m.evaluate(0.1) + "\n");
        for(int i = 0; i < 8; i++){
            System.out.println("coeff: " + m.arr_coeff[i]);
            System.out.println("exp: " + m.arr_exp[i] + "\n\n\n");
        }

        //File f = new File("Test.txt");
		  //Polynomial confusion = new Polynomial(f);


		// if(s.hasRoot(1))
		// 	System.out.println("1 is a root of s");
		// else
		// 	System.out.println("1 is not a root of s");

        // double [] c1 = {6, 7, 5};
        // int [] e1 = {5, 3, 2};
        // double [] c2 = {8, 2, 0, 7, 4};
        // int [] e2 = {0, 1, 0, 4, 2};
        // Polynomial p1 = new Polynomial(c1, e1);
        // Polynomial p2 = new Polynomial(c2, e2);

        // Polynomial s = p1.add(p2);
		// System.out.println("s(2.0) = " + s.evaluate(2.0));
	}
}