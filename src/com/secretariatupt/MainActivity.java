package com.secretariatupt;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String listItem []={"Logare","Creare Utilizator"};
        ListView lvMain=(ListView)findViewById(R.id.lv_main);
        lvMain.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listItem));
 
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() 
        {
 
                  @Override
                  public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
                  {
 
                        if(arg2==0)
                        {
                              Intent i=new Intent(MainActivity.this,LoginActivity.class);
                              startActivity(i);
                        }
                        else if(arg2==1)
                        {
                              Intent i=new Intent(MainActivity.this,CreateUserActivity.class);
                              startActivity(i);
                        }
                  }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
