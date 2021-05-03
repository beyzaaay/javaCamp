package Console;

import Business.CampaingManager;
import Business.GameCheckManager;
import Business.GameManager;
import Business.GameUserManager;
import Entities.Campaing;
import Entities.Game;
import Entities.GameUser;

public class Main {

	public static void main(String[] args) {
		GameUser gameuser1=new GameUser();
		gameuser1.setId(1);
		gameuser1.setFirstName("Beyza Nur");
		gameuser1.setLastName("AY");
		gameuser1.setDatetime("03.08.2000");
		gameuser1.setNationaltyIdentity("12345678912");
		
		
		Game game1 =new Game();
		game1.setId(1);
		game1.setGameName("Among Us");
		game1.setPrice(10.32);
		
		Game game2=new Game();
		game2.setId(2);
		game2.setGameName("Pubg");
		game2.setPrice(15.10);
		
		Campaing campaing=new Campaing();
		campaing.setId(1);
		campaing.setCampaingName("Yýlbaþý Ýndirimi");
		campaing.setDiscount(20);
		
		GameUserManager gameUserManager=new GameUserManager(new GameCheckManager());
		gameUserManager.add(gameuser1);
		System.out.println("-------------------------------");

		CampaingManager campaingManager=new CampaingManager();
		campaingManager.add(campaing);
		System.out.println("-------------------------------");
		
		GameManager gameManager= new GameManager();
		gameManager.add(game1);
		System.out.println("-------------------------------");
		
		gameManager.sale(gameuser1, game1);
		gameManager.sale(gameuser1, game1, campaing);
	}

}
