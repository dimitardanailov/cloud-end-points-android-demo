package cloudconfvarna.org;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cloudconfvarna.org.interfaces.iAppInterface;

import cloudconfvarna.org.libs.Request;
import cloudconfvarna.org.libs.StringResponse;

import android.net.ParseException;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CloudConfVarnaHomePageActivity extends ListActivity 
	implements iAppInterface {

	String[] tags = {TAG_BEERNAME, TAG_COUNTRY, TAG_LATITUDE, TAG_LONGITUDE, TAG_DESCRIPTION}; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cloud_conf_varna_home_page);
		
		Toast.makeText(getBaseContext(), "Loading", Toast.LENGTH_LONG).show();
		
		InputStream inputStream = null;
		String result = null;
		
		inputStream = Request.setHttpRequest("https://demos-biira.appspot.com/_ah/api/birra/v1/beer");
		
		if (inputStream != null) {
        	result = StringResponse.convertResponseToString(inputStream);
        	result = result.trim();
        }
		
		// Hashmap for ListView
		ArrayList<HashMap<String, String>> beerList = new ArrayList<HashMap<String, String>>();
        
        if (!result.equals("null") && result != null) {
        	
        	try {
        		//Toast.makeText(getBaseContext(), result ,Toast.LENGTH_LONG).show();
        		
        		JSONObject items = new JSONObject(result);
        		JSONArray arrayItems = items.getJSONArray("items");
        		
        		//Toast.makeText(getBaseContext(), arrayItems.length() + "",Toast.LENGTH_LONG).show();
        		JSONObject json_data = null;
	        	
	        	for(int i=0; i < arrayItems.length(); i++) {
	        		
	        		json_data = arrayItems.getJSONObject(i);
	        		
	        		try {
	        			//Toast.makeText(getBaseContext(),"Items",Toast.LENGTH_LONG).show();

	        			// creating new HashMap
	        			HashMap<String, String> map = new HashMap<String, String>();

	        			for (String tag : tags) {
	        				if (json_data.has(tag)) {
	        					//Log.d("Test", json_data.getString(tag));
	        					map.put(tag, json_data.getString(tag));
	        				} else {
	        					map.put(tag, "");
	        				}
	        			}

	        			beerList.add(map);
	        			
	        		} catch (ParseException e) {
	        			e.printStackTrace();
					}
	        	}
	        	
	        	
        	} catch(JSONException e1) {
	        	Toast.makeText(getBaseContext(),"ERROR",Toast.LENGTH_LONG).show();
	        } 
	        catch (ParseException e1) {
	        	Toast.makeText(getBaseContext(),"Error",Toast.LENGTH_LONG).show();
	        }
	        
	        /**
	         * Updating parsed JSON data into ListView
	         * */
	        ListAdapter adapter = new SimpleAdapter(this, beerList,
	                R.layout.beerlist,
	                new String[] { TAG_BEERNAME, TAG_COUNTRY, TAG_LATITUDE, TAG_LONGITUDE, TAG_DESCRIPTION}, 
	                	new int[] {
	        			R.id.name, R.id.countryField, R.id.latitudeField, R.id.longitudeField, R.id.descriptionField
	        		});
	        
	        setListAdapter(adapter);
	        
	        /**
	         * Selecting single ListView item
	         */
	        ListView listViewItem = getListView();
	        
	        listViewItem.setOnItemClickListener(new OnItemClickListener() {
	        	 
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view,
	                    int position, long id) {
	                // getting values from selected ListItem
	                String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
	                String country = ((TextView) view.findViewById(R.id.countryField)).getText().toString();
	                String latitude = ((TextView) view.findViewById(R.id.latitudeField)).getText().toString();
	                String longitude = ((TextView) view.findViewById(R.id.longitudeField)).getText().toString();
	                String description = ((TextView) view.findViewById(R.id.descriptionField)).getText().toString();
	                
	                // creating new HashMap
	                HashMap<String, String> beerHashmap = new HashMap<String, String>();
	                
	                // adding each child node to HashMap key => value
	                beerHashmap.put(TAG_BEERNAME, name);
	                beerHashmap.put(TAG_COUNTRY, country);
	                beerHashmap.put(TAG_LATITUDE, latitude);
	                beerHashmap.put(TAG_LONGITUDE, longitude);
	                beerHashmap.put(TAG_DESCRIPTION, description);
	                
	                // Starting new intent
	                Intent intent = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
	                intent.putExtra(TAG_HASH_MAP_INTENT_NAME, beerHashmap);
	                startActivity(intent);
	            }
	        });
        	
        } else {
        	Toast.makeText(getBaseContext(), "Invalid request",Toast.LENGTH_LONG).show();
			finish();
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cloud_conf_varna_home_page, menu);
		return true;
	}

}
