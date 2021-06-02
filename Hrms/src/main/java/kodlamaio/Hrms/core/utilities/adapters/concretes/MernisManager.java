package kodlamaio.Hrms.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.core.utilities.adapters.abstracts.MernisService;
import kodlamaio.Hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


@Service
public class MernisManager implements MernisService{

	@Override
	public Boolean checkIfCandidateRealPerson(Candidate candidate) {
		KPSPublicSoap soapClient = new KPSPublicSoapProxy();

		boolean result = false;

		try {
			result = soapClient.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalNumber()),
					candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
					candidate.getBirthdayDate().getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	

}
