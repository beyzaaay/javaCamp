package kodlamaio.Hrms.business.validation.Candidate;

import java.util.Date;

import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.entities.concretes.Candidate;

public class isCandidateConfirmed {

	private static Result isVerified = null;
	private static String message;

	public static boolean isVerified(Candidate candidate) {
		isVerified = nullControl(candidate);

		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}

		isVerified = birthdayDateControl(candidate.getBirthdayDate());
		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}
		message = isVerified.getMessage();
		return true;
	}

	private static Result nullControl(Candidate candidate) {

		if (candidate.getEmail().equals("")) {
			return new ErrorResult("Mail Adresi Boş Geçilemez!");
		}

		if (candidate.getPassword().equals("")) {
			return new ErrorResult("Şifre Boş Geçilemez!");
		}

		if (candidate.getFirstName().equals("")) {
			return new ErrorResult("Kullanıcı Adı Boş Geçilemez!");
		}

		if (candidate.getLastName().equals("")) {
			return new ErrorResult("Kullanıcı Soyadı Boş Geçilemez!");
		}

		if (candidate.getNationalNumber().equals("")) {
			return new ErrorResult("Kullanıcı T.C. Kimlik Numarası Boş Geçilemez!");
		}

		if (candidate.getBirthdayDate() == null) {
			return new ErrorResult("Kullanıcı Doğum Tarihi Boş Geçilemez.");
		}

		if (candidate.getNationalNumber().length() != 11) {
			return new ErrorResult("Kullanıcı T.C. Kimlik Numarası Hatalı! Lütfen 11 Karakterli T.C. Kimlik NUmarası Giriniz. ");
		}
		return new SuccessResult("Boş Alan Kontrolü Yapıldı.");
	}

	private static Result birthdayDateControl(Date birthDate) {
		Date currentDate = new Date();

		if (birthDate.after(currentDate)) {
			return new ErrorResult("Kullanıcı Doğum Tarihi Günün Tarihinden İleride Olamaz!");
		}
		return new SuccessResult("Doğum Tarihi Kontrolü Yapıldı.");
	}

	public static Result getIsVerified() {
		return isVerified;
	}

	public static String getMessage() {
		return message;
	}
}
