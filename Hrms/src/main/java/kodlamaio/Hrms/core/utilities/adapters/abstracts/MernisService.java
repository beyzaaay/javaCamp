package kodlamaio.Hrms.core.utilities.adapters.abstracts;

import kodlamaio.Hrms.entities.concretes.Candidate;

public interface MernisService {

	Boolean checkIfCandidateRealPerson(Candidate candidate);
}
