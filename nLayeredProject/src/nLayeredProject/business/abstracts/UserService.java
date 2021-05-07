package nLayeredProject.business.abstracts;

import java.util.List;

import nLayeredProject.entities.concretes.User;

public interface UserService {
	
	void add(User user);
	void update(User user);
	void delete(User user);

	User getById(int id);
	User getLoginInfos(String email, String password);
	List<User> getAll();
	void userVerify(User user, int verificationCode);
}
