package cloudconfvarna.org;

import java.util.HashMap;

import cloudconfvarna.org.interfaces.iAppInterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class SingleMenuItemActivity extends Activity implements iAppInterface {
	//Store data from previous activity
	private HashMap<String, String> beerHashmap;
	
	@Override
	@SuppressWarnings("unchecked")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.beerlist);
		
		// Get Layout Elements
        TextView fieldName = (TextView) findViewById(R.id.name);
        TextView fieldCountry = (TextView) findViewById(R.id.countryField);
        TextView fieldLatitude = (TextView) findViewById(R.id.latitudeField);
        TextView fieldLongitude = (TextView) findViewById(R.id.longitudeField);
        TextView fieldDescription = (TextView) findViewById(R.id.descriptionField);
        
        //Hidden Labels
        TextView labelDescription = (TextView) findViewById(R.id.labelDescription);
        
        // getting intent data
        Intent intent = getIntent();
        
        //Get Intent values from previous intent
        beerHashmap = (HashMap<String, String>)intent.getSerializableExtra(TAG_HASH_MAP_INTENT_NAME);
        
        // Set Intent variables to layout elements
        fieldName.setText(beerHashmap.get(TAG_BEERNAME));
        fieldCountry.setText(beerHashmap.get(TAG_COUNTRY));
        fieldLatitude.setText(beerHashmap.get(TAG_LATITUDE));
        fieldLongitude.setText(beerHashmap.get(TAG_LONGITUDE));
        fieldDescription.setText(beerHashmap.get(TAG_DESCRIPTION));
        
        // Show Hidden fields
        labelDescription.setVisibility(View.VISIBLE);
        fieldDescription.setVisibility(View.VISIBLE);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cloud_conf_varna_home_page, menu);
		return true;
	}
}
