package br.gov.serpro.adventure;

import com.google.gson.Gson;

public class AdventureService extends BaseService {

	public Event[] findAllEvents() {
		
		String json = this.executeService("http://adventure-demo2.rhcloud.com/api/event");
		
		Gson gson = new Gson();
		
		Event[] listEvent = gson.fromJson(json, Event[].class);
		
		return listEvent;
		
	}
	
}

