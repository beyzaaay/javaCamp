package nLayeredProject.core;

public class BusinessRules {

	/*Burada arkada�lar�n projesinden destek ald�m!!!*/
	
	public static boolean Run(boolean... logics) {
		for (boolean logic : logics) {
			if (!logic) {
				return false;
			}
		}
		return true;
}
}
