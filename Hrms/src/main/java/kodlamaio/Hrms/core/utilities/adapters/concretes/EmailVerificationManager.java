package kodlamaio.Hrms.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.core.utilities.adapters.abstracts.EmailVerificationService;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Boolean emailVerify(String email) {
		
		return true;
	}

}
