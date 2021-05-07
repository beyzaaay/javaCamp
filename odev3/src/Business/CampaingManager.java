package Business;

import Entities.Campaing;

public class CampaingManager implements CampaingService{

	@Override
	public void add(Campaing entity) {
		System.out.println("Kampanya sisteme eklendi. : "+ entity.getCampaingName());
		
	}

	@Override
	public void delete(Campaing entity) {
		System.out.println("Kampanya sistemden sislindi. : "+ entity.getCampaingName());
		
	}

	@Override
	public void update(Campaing entity) {
		System.out.println("Kmapanya güncellendi. : "+ entity.getCampaingName());
		
	}

	

}
