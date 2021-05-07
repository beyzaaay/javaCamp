package Business;

import Entities.Campaing;
import Entities.Game;
import Entities.GameUser;

public class GameManager implements GameService{

	@Override
	public void add(Game entity) {
		System.out.println("Oyun sisteme eklendi. : "+ entity.getGameName());
		
	}

	@Override
	public void delete(Game entity) {
		System.out.println("Oyun sistemden silindi. : "+ entity.getGameName());
		
	}

	@Override
	public void update(Game entity) {
		System.out.println("Oyun g�ncellendi. : "+ entity.getGameName());
		
	}

	@Override
	public void sale(GameUser gameuser, Game game) {
		System.out.println(game.getGameName()+" adl� oyun "+game.getPrice()+ " TL'ye sat�ld�. Sat�n alan oyuncu : "+gameuser.getFirstName()+" "+gameuser.getLastName());
		
	}

	@Override
	public void sale(GameUser gameuser, Game game, Campaing camgaing) {
		double newPrice= game.getPrice() - (game.getPrice() *(camgaing.getDiscount()/ 100));
		
		System.out.println(game.getGameName()+" adl� oyun "+camgaing.getCampaingName()+"  ile "+
		newPrice+ " TL'ye sat�ld�. Sat�n alan oyuncu : "+gameuser.getFirstName()+" "+gameuser.getLastName());
		
	}

}
