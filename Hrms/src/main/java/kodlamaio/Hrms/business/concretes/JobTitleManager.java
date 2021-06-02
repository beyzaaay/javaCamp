package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobTitleService;
import kodlamaio.Hrms.business.validation.JobTitle.isJobTitleConfirmed;
import kodlamaio.Hrms.core.utilities.result.DataResult;
import kodlamaio.Hrms.core.utilities.result.ErrorResult;
import kodlamaio.Hrms.core.utilities.result.Result;
import kodlamaio.Hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.result.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.Hrms.entities.concretes.JobTitle;


@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>
		(this.jobTitleDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		
		if(!isJobTitleConfirmed.isVerified(jobTitle)) {
			return new ErrorResult(isJobTitleConfirmed.getMessage());
		}
		if(this.jobTitleDao.findByTitle(jobTitle.getTitle()).stream().count()>0) {
			return new ErrorResult(jobTitle.getTitle()+ "İş Pozisyonu Sisteme Kayıtlı!");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş Pozisyonu Eklendi.");
	}

	
}
