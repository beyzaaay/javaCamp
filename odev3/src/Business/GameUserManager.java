package Business;

import Entities.GameUser;

public class GameUserManager implements GameUserService{

	private GameCheckService _gamerCheckService;
	
	public GameUserManager(GameCheckService gamerCheckService) {
		super();
		this._gamerCheckService = gamerCheckService;
	}

	@Override
	public void add(GameUser entity) {
		
		if(_gamerCheckService.checkIfRealPerson(entity)) {
			System.out.println("Oyuncu sisteme E-devlet do�rulamas� ile eklendi: "+entity.getFirstName()+" "+entity.getLastName());
		}
		else {
			System.out.println("OYUNCU EKLENEMEDI... E-DEVLET DOGRULAMA HATASI.");
		}
		
	}

	@Override
	public void delete(GameUser entity) {
		
		System.out.println(entity.getFirstName()+" adl� oyuncu silindi.");
		
	}

	@Override
	public void update(GameUser entity) {
		System.out.println(entity.getFirstName()+" adl� oyuncu g�ncellendi.");
		
	}

}
