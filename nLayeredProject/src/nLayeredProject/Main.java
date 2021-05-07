package nLayeredProject;

import java.util.Scanner;

import nLayeredProject.business.abstracts.UserService;
import nLayeredProject.business.abstracts.UserValidationService;
import nLayeredProject.business.concretes.EmailManager;
import nLayeredProject.business.concretes.UserManager;
import nLayeredProject.business.concretes.UserValidateManager;
import nLayeredProject.core.GoogleManagerAdapters;
import nLayeredProject.dataAccess.concretes.InMemoryUserDao;
import nLayeredProject.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//UserService userService=new UserManager(new InMemoryUserDao(),new AuthManager(),new EmailManager());
		UserValidationService googleManager=new GoogleManagerAdapters();
	
		User user=new User();
		user.setId(1);
		user.setFirstName("Beyza");
		user.setLastName("ay");
		user.setEmail("beyzaay34@gmail.com");
    	user.setPassword("000000");
		User user2=new User();
		user2.setId(2);
		user2.setFirstName("mehmet");
	    user2.setLastName("ay");
		user2.setEmail("mehmetay34@gmail.com");
    	user2.setPassword("000000");


		UserService userService=new UserManager(new InMemoryUserDao(),new UserValidateManager(),new EmailManager(), null);
		userService.getAll();
		
		userService.add(user);
		
		int verificationCode=scan.nextInt();
		userService.userVerify(user, verificationCode);



		userService.add(user2);
		userService.getById(1);


	}

}
