import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Polynomial{
	double[] arr_coeff = new double[100];   //coefficients
    int[] arr_exp = new int[100];           //exponents or power

	public Polynomial(){
		for (int i = 0; i < 100; i++){
			arr_coeff[i] = 0;
            arr_exp[i] = 0;
		}
	}

	public Polynomial(double[] c, int[] e){
		int coeff_size = c.length;
		for (int i = 0; i < coeff_size; i++){
			this.arr_coeff[i] = c[i];
		}
		if (coeff_size < 100){
			for (int i = coeff_size; i < 100; i++){
				this.arr_coeff[i] = 0;
			}
		}

        int exp_size = e.length;
		for (int i = 0; i < exp_size; i++){
			this.arr_exp[i] = e[i];
		}
		if (exp_size < 100){
			for (int i = exp_size; i < 100; i++){
				this.arr_exp[i] = 0;
			}
		}
	}

	// public Polynomial(File f){
	// 	BufferedReader br = new BufferedReader(f);
	// 	Scanner
 	// 	String str = br.readLine();
    //     System.out.println(str);
    // }

	public Polynomial add (Polynomial arg){
		Polynomial temp = new Polynomial();
        boolean found = false;
        int space = 0;
        
        for (int i = 0; i < 100; i++){  //copy values to temp
            if (this.arr_coeff[i] != 0){
                temp.arr_coeff[space] = this.arr_coeff[i];
                temp.arr_exp[space] = this.arr_exp[i];
                space++;
            }
        }

        for (int i = 0; i < 100; i++){  //add to temp is exp is in temp
            found = false;
            if(temp.arr_coeff[i] != 0){
                // System.out.println("here\n");
                for (int j = 0; j < 100; j++){
                    if ((found == false) & (temp.arr_exp[i] == arg.arr_exp[j])){
                        // System.out.println("b\n");
                        found = true;
                        temp.arr_coeff[i] += arg.arr_coeff[j];
                        // System.out.println("c\t" + temp.arr_coeff[i] + "\n");
                    }
                }
            }
        }

        for(int i = 0; i < 100; i++){       //loop through arg, if exp is not in temp, add into temp
            found = false;
            if(arg.arr_coeff[i] != 0){
                for (int j = 0; j < 100; j++){
                    if((found == false) & (arg.arr_exp[i] == temp.arr_exp[j])){found = true;}
                }

                if (found == false){
                    temp.arr_coeff[space] = arg.arr_coeff[i];
                    temp.arr_exp[space] = arg.arr_exp[i];
                    space++;
                }
            }
        }

		return temp;
	}

	public double evaluate (double x){
		double total = 0;
		double temp = 1;
		for (int i = 0; i < 100; i++){
			temp = 1;
			for (int j = 0; j < this.arr_exp[i]; j++){temp *= x;}     //power function
			total += temp * this.arr_coeff[i];
		}
		return total;
	}

	public boolean hasRoot (double arg){
		double total = evaluate(arg);
		if (total == 0.0){return true;}
		else {return false;}
	}

    public Polynomial multiply (Polynomial arg){
        int temp = 0;       //storage for the current exponent of total Polynomial
        Polynomial total = new Polynomial();
        boolean found = false;      //for if exp is found or empty space is found
        int counter = 0;
        int space = 0;

        for  (int i = 0; i < 100; i++){         //loops this
            if(this.arr_coeff[i] != 0){
                for  (int j = 0; j < 100; j++){         //loops arg
                    if(arg.arr_coeff[j] != 0){
                        temp = this.arr_exp[i] + arg.arr_exp[j];        //temporary or current exp
                        found = false;

                        //multiplication
                        counter = 0;
                        while ((found == false) & (counter < 100)){     //checks if there are redundant exponents
                            if ((total.arr_exp[counter] == temp) & (total.arr_coeff[counter] != 0)){     //if there is a redundant exponent
                                System.out.println("here\n");
                                total.arr_coeff[counter] += this.arr_coeff[i] * arg.arr_coeff[j];
                                found = true;
                            }
                            counter++;
                        }

                        //add new exponent
                        if (found == false){        //exponent is not in total
                            total.arr_coeff[space] = this.arr_coeff[i] * arg.arr_coeff[j];
                            total.arr_exp[space] = this.arr_exp[i] + arg.arr_exp[j];
                            space++;
                        }
                    }
                }
            }
        }
        return total;
    }

    public String saveToFile (String str){
        String fin = "";
        int i = 0;

        fin = fin + Double.toString(this.arr_coeff[i]) + "x" + Integer.toString(this.arr_exp[i]); i++;
        while ((this.arr_coeff[i] != 0) && (this.arr_coeff[i + 1] != 0) && ((this.arr_exp[i] != 0) && (this.arr_exp[i + 1] != 0))){
            if (this.arr_coeff[i] < 0){fin = fin + "+";}
            fin = fin + Double.toString(this.arr_coeff[i]) + "x" + Integer.toString(this.arr_exp[i]);
            i++;
        }

        // FileWriter output = new FileWriter(str, false); //use true for appending
		return fin;
    }
}