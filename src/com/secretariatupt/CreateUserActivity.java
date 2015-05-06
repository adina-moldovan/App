package com.secretariatupt;

import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class CreateUserActivity extends Activity {
	 
    EditText etCnp, etEmail, etPassword;
    Button btnCreateUser;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_create_user);
          // Show the Up button in the action bar.
         /* try{
          setupActionBar();
          }catch(Exception e)
          {
        	  Log.d("AsyncLogin", e.getMessage());
          }*/
          etCnp = (EditText) findViewById(R.id.et_cnp);
          etEmail = (EditText) findViewById(R.id.et_email);
          etPassword = (EditText) findViewById(R.id.et_cu_password);
          btnCreateUser=(Button) findViewById(R.id.btn_createuser);

          btnCreateUser.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                      // TODO Auto-generated method stub

                      String cnp, email, password;

                      cnp = etCnp.getText().toString();
                      email = etEmail.getText().toString();
                      password = etPassword.getText().toString();

                      new AsyncCreateUser().execute(cnp,email,password);

                }
          });

    }

    protected class AsyncCreateUser extends AsyncTask<String, JSONObject, Integer> 
    {
    	@Override
    	protected Integer doInBackground(String... params) 
    	{
    		RestAPI api = new RestAPI();
    		int regsteredState = 0;

    		try 
    		{

            	     // Call the Create User Method in API
             	     JSONObject jsonObj = api.CreateNewAccount(params[0], params[1], params[2]);
    	    
             	     //Parse the JSON Object to int
              	    JSONParser parser = new JSONParser();	
    	 	        regsteredState =  parser.parseCreateAcount(jsonObj);
    		} 
    		catch (Exception e) 
    		{
    			// TODO Auto-generated catch block
                Log.d("AsyncCreateUser", e.getMessage());

            }
    		
            return regsteredState;
        }
    	
        
    	@Override
        protected void onPostExecute(Integer result) 
    	{
             // TODO Auto-generated method stub

             //Check user validity
    		 if (result == 2) 
    		 {
                 Intent i = new Intent(CreateUserActivity.this, LoginActivity.class);
                 startActivity(i);
             }
             else
             {
    		  	 if(result == 0)
    			 {
               	 	Toast.makeText(context, "Not valid CNP/password ",Toast.LENGTH_SHORT).show();
    			 }
    			 else
    			 {
    				 Toast.makeText(context, "User already exists in the database",Toast.LENGTH_SHORT).show();
    			 }
             }
        }

     }


    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                getActionBar().setDisplayHomeAsUpEnabled(true);
          }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
          // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater().inflate(R.menu.create_user, menu);
          return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          switch (item.getItemId()) {
          case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(this);
                return true;
          }
          return super.onOptionsItemSelected(item);
    }

}