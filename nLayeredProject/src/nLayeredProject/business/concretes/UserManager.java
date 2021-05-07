package nLayeredProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import nLayeredProject.business.abstracts.EmailService;
import nLayeredProject.business.abstracts.UserService;
import nLayeredProject.business.abstracts.UserValidationService;
import nLayeredProject.dataAccess.abstracts.UserDao;
import nLayeredProject.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private UserValidationService validateService;
	private EmailService emailService;
	
	List<User> users=new ArrayList<User>();
	
	public UserManager() {
		super();
		users.add((User) this.getAll());
	}

	public UserManager(UserDao userDao, UserValidationService validateService, EmailService emailService,
			List<User> users) {
		super();
		this.userDao = userDao;
		this.validateService = validateService;
		this.emailService = emailService;
		this.users = users;
	}

	@Override
	public void add(User user) {
		if (userCheck(user.getEmail()) &&validateService.userValidate(user)) {
			userDao.add(user);
			System.out.println("Doðrulama Kodunuz Mail Olarak Gönderildi! Doðrulama Kodunuz: "+emailService.mailSend());
			System.out.print("Doðrulama Kodunu Giriniz: ");
			return;			
		}
		System.out.println("Kullanýcý Bilgilerini Kontrol Ediniz!");
		
	}

	private boolean userCheck(String email) {
		if (userDao.getByEmail(email)!=null) {
			System.out.println("Kullanýcý mevcut!");
			return false;
		}
		return true;
	}

	@Override
	public void update(User user) {
		this.userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
		
	}

	@Override
	public User getById(int id) {
		User result=this.userDao.getById(id);
		return result;
	}

	@Override
	public User getLoginInfos(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		List<User> result=this.userDao.getAll();
		return result;
	}

	@Override
	public void userVerify(User user, int verificationCode) {
		int result=emailService.mailSend();
		if (result==verificationCode) {
			
			System.out.println("Kullanýcý doðrulandý. Üyeliðiniz Tamamlandý!!! "+user.getFirstName());
		}
		else {
			System.out.println("Doðrulama kodunuz yanlýþ!");
		}
	}
	
}
