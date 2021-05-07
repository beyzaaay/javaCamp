package nLayeredProject.business.abstracts;

import nLayeredProject.entities.concretes.User;

public interface UserValidationService {

	boolean userValidate(User user);
	boolean login(User user);
}
