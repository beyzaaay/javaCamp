package nLayeredProject.business.concretes;

import java.util.Random;

import nLayeredProject.business.abstracts.EmailService;

public class EmailManager implements EmailService{

	int verificationCode;
	public EmailManager() {
		Random a=new Random();
		this.verificationCode= a.nextInt(1000)*10;
	}
	@Override
	public int mailSend() {
		return this.verificationCode;
	}

}
