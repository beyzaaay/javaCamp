package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.business.validation.Candidate.isCandidateConfirmed;
import kodlamaio.Hrms.core.utilities.adapters.abstracts.EmailVerificationService;
import kodlamaio.Hrms.core.utilities.adapters.abstracts.MernisService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private MernisService mernisService;
	private UserDao userDao;
	private EmailVerificationService emailVerificationService;
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi");
	}
	@Override
	public Result add(Candidate candidate) {
		if (!isCandidateConfirmed.isVerified(candidate)) {
			return new ErrorResult(isCandidateConfirmed.getMessage());
		}

		if (this.userDao.findByEmail(candidate.getEmail()).stream().count() > 0) {
			return new ErrorResult(candidate.getEmail() + " Adres Sistemde Kayıtlıdır. Lütfen Giriş Yapınız!");
		}

		if (this.candidateDao.findByNationalNumber(candidate.getNationalNumber()).stream().count() > 0) {
			return new ErrorResult(
					candidate.getNationalNumber() + " Kimlik Numarası Sistemde Kayıtlıdır. Lütfen Giriş Yapınız!");
		}

		
		  if (!this.mernisService.checkIfCandidateRealPerson(candidate)) { 
			  return new ErrorResult("Mernis Doğrulaması Başarısız! Lütfen Kimlik Bilgilerinizi Kontrol Ediniz!"); 
			  }
		
		 

		if (this.emailVerificationService.emailVerify(candidate.getEmail())) {
			this.candidateDao.save(candidate);
		}
		return new SuccessResult(candidate.getEmail() + " Adresi Doğrulaması Yapıldı. Kaydınız Tamamlanmıştır..");
	}
}
