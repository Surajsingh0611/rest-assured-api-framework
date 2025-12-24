package Resourcs;
// Enum to manage API resource paths
// Each enum constant represents a specific API endpoint
//what is enum: An enum (short for "enumeration") 
//is a special data type in Java that enables a variable to be a set of predefined constants.
public enum ApiResources {
	
	AddPlaceAPI("/maps/api/place/add/json"), 
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");

	private String resource;

	ApiResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
