package kodlamaio.Hrms.business.validation.Employer;

import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.entities.concretes.Employer;

public class isEmployerConfirmed {

	private static Result isVerified = null;
	private static String message;

	public static boolean isVerified(Employer employer) {
		isVerified = nullControl(employer);

		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}

		isVerified = isConfirmedEmail(employer.getEmail(), employer.getWebAddress());
		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}

		message = isVerified.getMessage();
		return true;
	}

	private static Result nullControl(Employer employer) {

		if (employer.getEmail().equals("")) {
			return new ErrorResult("Mail Adresi Boş Geçilemez!");
		}

		if (employer.getPassword().equals("")) {
			return new ErrorResult("Şifre Boş Geçilemez!");
		}

		if (employer.getCompanyName().equals("")) {
			return new ErrorResult("Şirket Adı Boş Geçilemez.");
		}

		if (employer.getWebAddress().equals("")) {
			return new ErrorResult("Web Adresi Boş Geçilemez!");
		}
		return new SuccessResult("Boş Alan Kontrolü Yapıldı.");
	}

	private static Result isConfirmedEmail(String email, String webAdress) {
		String[] emailArr = email.split("@");
		String[] webAdressArr = webAdress.split("www.");

		if (!emailArr[1].equals(webAdressArr[1])) {
			return new ErrorResult("Web Adresi Uygun Değildir!");
		}
		return new SuccessResult("e-Mail Kontrolü Yapıldı.");
	}

	public static Result getIsVerified() {
		return isVerified;
	}

	public static String getMessage() {
		return message;
	}
}
