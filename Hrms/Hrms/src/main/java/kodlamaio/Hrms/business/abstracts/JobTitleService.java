package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}
