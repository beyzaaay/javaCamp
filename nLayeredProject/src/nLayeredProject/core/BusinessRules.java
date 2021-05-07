package nLayeredProject.core;

public class BusinessRules {

	/*Burada arkadaþlarýn projesinden destek aldým!!!*/
	
	public static boolean Run(boolean... logics) {
		for (boolean logic : logics) {
			if (!logic) {
				return false;
			}
		}
		return true;
}
}
