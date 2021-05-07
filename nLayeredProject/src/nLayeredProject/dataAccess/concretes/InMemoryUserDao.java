package nLayeredProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import nLayeredProject.dataAccess.abstracts.UserDao;
import nLayeredProject.entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();
	
	public InMemoryUserDao() {
		super();
		System.out.println("*****Kullanýcýlar*****");
		User user1=new User(1,"Beyza Nur","Ay","Beyzaay34@gmail.com","123456");
		User user2=new User(2,"Engin", "Demirog","Engindemirog34@gmail.com","654321");
		User user3=new User(3,"Ceren", "Ay","Cerenay34@gmail.com","123123");
		User user4=new User(4, "Ahmet", "Yýlmaz", "Ahmetyýlmaz34@gmail.com", "456456");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}

	@Override
	public void add(User user) {
		System.out.println("Kullanýcý eklendi : "+ user.getFirstName()+ " "+ user.getLastName());
		users.add(user);
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanýcý güncellendi : "+ user.getFirstName()+ " "+ user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		users.removeIf(u -> u.getId() == user.getId());
		System.out.println("Kullanýcý silindi : "+ user.getFirstName()+ " "+ user.getLastName());
		
	}

	@Override
	public User getById(int id) {
		User user = users.stream()
				.filter(u -> u.getId() == id)
				.findFirst()
				.orElse(null);
		System.out.println("Kullanýcý adý: "+user.getFirstName());
		return user;
	}

	@Override
	public User getByEmail(String email) {
		
		User user = users.stream()
				.filter(u -> u.getEmail() == email)
				.findFirst()
				.orElse(null);
		
		return user;
	}

	@Override
	public User getLoginInfos(String email, String password) {
for (User user : users) {
			
			if (user.getEmail() == email && user.getPassword() == password) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public List<User> getAll() {
		for (User user : users) {
			System.out.println("Id : "+ user.getId() + "\nKullanýcý : "+ user.getFirstName()+ " "+
		user.getLastName()+"\nEMail : "+ user.getEmail());
		}
		System.out.println("*****************");
		return this.users;
	}
}
