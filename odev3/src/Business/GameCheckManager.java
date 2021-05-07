package Business;

import Entities.GameUser;

public class GameCheckManager implements GameCheckService{

	public boolean checkIfRealPerson(GameUser gameuser) {
		
		if((!gameuser.getNationaltyIdentity().isEmpty()) && (gameuser.getNationaltyIdentity().length()==11)) {
					
					return true;
				}
				else {
					return false;
				}
		
	}

}
