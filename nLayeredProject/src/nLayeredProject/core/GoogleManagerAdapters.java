package nLayeredProject.core;

import nLayeredProject.business.abstracts.UserValidationService;
import nLayeredProject.entities.concretes.User;
import nLayeredProject.jGoogleValid.RegisterGoogleManager;

public class GoogleManagerAdapters implements UserValidationService{

	RegisterGoogleManager registerGoogleManager=new RegisterGoogleManager();
	@Override
	public boolean userValidate(User user) {
		boolean result = false;

		result = registerGoogleManager.register(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getPassword());
		if (result != true) {
			return false;
		}
		System.out.println("Google ile kay�t olundu!");
		return true;
	}
	@Override
	public boolean login(User user) {
		boolean result=BusinessRules.Run(isFirstandLastNameEmpty(user));
		return result;
	
	}
	private boolean isFirstandLastNameEmpty(User user) {
		if (user.getEmail()==null || user.getPassword()==null) {
			System.out.println("Kullan�c� ad� veya parola eksik!");
			return false;
		}
		System.out.println("Sisteme giri� yap�ld�!");
		return true;
	}
	

}
