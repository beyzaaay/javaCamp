package kodlamaio.Hrms.business.validation.JobTitle;

import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.entities.concretes.JobTitle;

public class isJobTitleConfirmed {

	private static Result isVerified=null;
	private static String message;
	
	public static boolean isVerified(JobTitle jobTitle) {
		isVerified = nullControl(jobTitle);

		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}

		message = isVerified.getMessage();
		return true;
	}
	
	private static Result nullControl(JobTitle jobTitle) {

		if (jobTitle.getTitle().equals("")) {
			return new ErrorResult("İş Unvanı Boş Geçilemez!");
		}
		return new SuccessResult("Boş Alan Kontrolü Yapıldı.");
	}

	public static Result getIsVerified() {
		return isVerified;
	}

	public static String getMessage() {
		return message;
	}
}
