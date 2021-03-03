package Utils;

public class Redondear {
	public static float Redondeo(float numero,int digitos){
		int cifras =(int) Math.pow(10, digitos);
		return  (float) (Math.rint(numero*cifras)/cifras);
	}

}
