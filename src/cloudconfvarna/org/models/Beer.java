package cloudconfvarna.org.models;

public class Beer {

	private Long id;
	private String beerName;
	private String kindOfBeer;
	private String score;
	private String numberOfDrinks;
	private String country;
	private String description;
	private Double latitude;
	private Double longitude;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}
	
	public String getBeerName() {
		return beerName;
	}
	
	public void setKindOfBeer(String kindOfBeer) {
		this.kindOfBeer = kindOfBeer;
	}
	
	public String getKindOfBeer() {
		return kindOfBeer;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setNumberOfDrinks(String numberOfDrinks) {
		this.numberOfDrinks = numberOfDrinks;
	}
	
	public String getNumberOfDrinks() {
		return numberOfDrinks;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
}
