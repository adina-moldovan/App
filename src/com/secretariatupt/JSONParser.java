package com.secretariatupt;

import org.json.JSONException;
import org.json.JSONObject;
 
import android.util.Log;

public class JSONParser {

	public JSONParser()
    {
    super();
    }
	
	public boolean parseUserAuth(JSONObject object)
    {     boolean userAtuh=false;
                try {
                      userAtuh= object.getBoolean("Value");
                } catch (JSONException e) {
                      // TODO Auto-generated catch block
                      Log.d("JSONParser => parseUserAuth", e.getMessage());
                }

                return userAtuh;
    }
	
	public int parseCreateAcount(JSONObject object)
    {    
		int registerState = 0;
		
                try {
                	registerState = object.getInt("Value");
                } catch (JSONException e) {
                      // TODO Auto-generated catch block
                      Log.d("JSONParser => parseCreateAcount", e.getMessage());
                }

                return registerState;
    }
	
}
