public class Polynomial{
	double[] arr_coeff = new double[100];

	public Polynomial(){
		for (int i = 0; i < 100; i++){
			arr_coeff[i] = 0;
		}
	}

	public Polynomial(double[] arr){
		int arr_size = arr.length;
		for (int i = 0; i < arr_size; i++){
			this.arr_coeff[i] = arr[i];
		}
		if (arr_size < 100){
			for (int i = 0; i < arr_size; i++){
				this.arr_coeff[i] = arr[i];
			}
		}
	}

	public Polynomial add(Polynomial arg){
		Polynomial temp = new Polynomial();
		for  (int i = 0; i < 100; i++){
			temp.arr_coeff[i] = this.arr_coeff[i] + arg.arr_coeff[i];
		}
		return temp;
	}

	public double evaluate (double x){
		double total = 0;
		double temp = 1;
		for (int i = 0; i < 100; i++){
			temp = 1;
			for (int j = 0; j < i; j++){temp *= x;}
			total += temp * this.arr_coeff[i];
		}
		return total;
	}

	public boolean hasRoot (double arg){
		double total = evaluate(arg);
		if (total == 0.0){return true;}
		else {return false;}
	}
}













