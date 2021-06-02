package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.business.validation.Employer.isEmployerConfirmed;
import kodlamaio.Hrms.core.utilities.adapters.abstracts.EmailVerificationService;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserDao userDao;
	private EmailVerificationService emailVerificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao,
			EmailVerificationService emailVerificationService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.emailVerificationService = emailVerificationService;
	}
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi");
	}
	@Override
	public Result add(Employer employer) {
		
		if(!isEmployerConfirmed.isVerified(employer)) {
			return new ErrorResult(isEmployerConfirmed.getMessage());
		}
		if(this.userDao.findByEmail(employer.getEmail()).stream().count()>0) {
			return new ErrorResult(employer.getEmail()+ "Adres Sistemde Kayıtlıdır. Lütfen Giriş Yapınız!");
		}
		if(this.emailVerificationService.emailVerify(employer.getEmail())) {
			this.employerDao.save(employer);
		}
		return new SuccessResult(employer.getEmail() + " Adres Doğrulaması Yapıldı! Kaydınız Tamamlanmıştır.");
	}
}
