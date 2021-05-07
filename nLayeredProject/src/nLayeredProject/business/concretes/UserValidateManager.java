package nLayeredProject.business.concretes;

import java.util.regex.Pattern;

import nLayeredProject.business.abstracts.UserValidationService;
import nLayeredProject.core.BusinessRules;
import nLayeredProject.entities.concretes.User;

public class UserValidateManager implements UserValidationService{

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	@Override
	public boolean userValidate(User user) {
		boolean result=BusinessRules.Run(ifPasswordCheckLength(user),
				ifFirstNameCheckLength(user),
				ifLastNameCheckLength(user),
				ifEmailFormatCheckValid(user));
		return result;
	}

	private boolean ifEmailFormatCheckValid(User email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email.getEmail()).find();
	}

	private boolean ifLastNameCheckLength(User user) {
		if (user.getLastName().length()<2) {
			System.out.println("Soyad en az 2 karakter olmalýdýr!");
			return false;
		}
		return true;
	}

	private boolean ifFirstNameCheckLength(User user) {
		if (user.getFirstName().length()<2) {
			System.out.println("Ýsim en az 2 karakter olmalýdýr!");
			return false;
		}
		return true;
	}

	private boolean ifPasswordCheckLength(User user) {
		if (user.getPassword().length()<6) {
			System.out.println("Parola en az 6 karakter olmalýdýr!");
			return false;
		}
		return true;
	}

	@Override
	public boolean login(User user) {
		boolean result=BusinessRules.Run(isFirstandLastNameEmpty(user));
		return result;
	}

	private boolean isFirstandLastNameEmpty(User user) {
		if (user.getEmail()==null || user.getPassword()==null) {
			System.out.println("Kullanıcı adı veya parola eksik!");
			return false;
		}
		System.out.println("Sisteme giriş yapıldı!");
		return true;
	}

}
