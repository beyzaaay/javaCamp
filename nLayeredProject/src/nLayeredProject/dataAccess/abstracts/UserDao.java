package nLayeredProject.dataAccess.abstracts;

import java.util.List;
import nLayeredProject.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	User getById(int id);
	User getByEmail(String email);
	User getLoginInfos(String email, String password);//emindeðilim
	List<User> getAll();
}
