package Resourcs;

import java.util.ArrayList;
import java.util.List;

import pojo_classes.Location;
import pojo_classes.getMapdetails;

public class TestDataBuild {

	getMapdetails p = new getMapdetails();
	 public getMapdetails addPlacePayload(String name, String language, String address) {
		 p.setAccuracy(50);
		    p.setAddress(address);
		    p.setLanguage(language);
		    p.setName(name);
		    p.setPhone_number("(+91) 983 893 3937");
		    p.setWebsite("http://google.com");
		    List<String>ty=new ArrayList<String>() ;
		    ty.add("Shoe");
		    ty.add("car");
		    p.setTypes(ty);
		    Location l = new Location();
		    l.setLat(-38.383494);
		    l.setLng(33.427362);
		    p.setLocation(l);
		    return p;
	 }

		public String deletePlacePayload(String place_id) {
			return "{\r\n    \"place_id\":\"" + place_id + "\"\r\n}";
		}
}