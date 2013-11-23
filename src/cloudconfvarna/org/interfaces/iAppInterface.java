package cloudconfvarna.org.interfaces;

public interface iAppInterface {
	
	String LISTBEERURI = "https://demos-biira.appspot.com/_ah/api/birra/v1/beer?fields=items(beerName%2Ccountry%2Cdescription%2Cid%2CkindOfBeer%2Clatitude%2Clongitude%2CnumberOfDrinks%2Cscore)";

	String TAG_HASH_MAP_INTENT_NAME = "beer";
	
	String TAG_BEERNAME = "beerName";
	String TAG_COUNTRY = "country";
	String TAG_LATITUDE = "latitude";
	String TAG_LONGITUDE = "longitude";
	String TAG_DESCRIPTION = "description";
}
