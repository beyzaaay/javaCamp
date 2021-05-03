package Business;

import Entities.Campaing;
import Entities.Game;
import Entities.GameUser;

public interface GameService extends BaseService<Game>{
	
	public void sale(GameUser gameuser, Game game);
	
	public void sale(GameUser gameuser, Game game, Campaing camgaing);
}
