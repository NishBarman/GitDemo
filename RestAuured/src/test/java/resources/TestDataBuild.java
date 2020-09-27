package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.addPlace;

public class TestDataBuild {

	public addPlace addPlacePayLoad(String name, String language, String address)
	{
		  addPlace p=new addPlace();
		   p.setAccuracy(40);
		   p.setAddress(address);
		   p.setLanguage(language);
		   p.setName(name);
		   p.setPhone_number("(+91) 703 893 3937");
		   p.setWebsite("http://google.com");
		   List<String> mylist=new ArrayList<String>();
		   mylist.add("sho park");
		   mylist.add("she");
		   p.setTypes(mylist);
		   Location loc=new Location();
		   loc.setLat(-48.383494);
		   loc.setLng(41.427362);
		   p.setLocation(loc);
		   return p;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}
