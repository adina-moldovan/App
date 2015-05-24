package com.secretariatupt;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.util.Log;

public class JSONParser
{

	public JSONParser()
    {
    super();
    }
	
	public boolean parseBoolean(JSONObject object)
    {     
		boolean userAtuh=false;
        try 
        {
             userAtuh= object.getBoolean("Value");
        }
        catch (JSONException e) 
        {
             Log.d("JSONParser => parseUserAuth", e.getMessage());
        }

        return userAtuh;
    }
	
	public String parseString(JSONObject object)
    {     
		String value = "";
        try 
        {
             value = object.getString("Value");
        }
        catch (JSONException e) 
        {
             Log.d("JSONParser => parseUserAuth", e.getMessage());
        }

        return value;
    }
	
	public int parseCreateAcount(JSONObject object)
    {    
		int registerState = 0;
		
		try 
		{
             registerState = object.getInt("Value");
        }
		catch (JSONException e) 
		{
             Log.d("JSONParser => parseCreateAcount", e.getMessage());
        }

        return registerState;
    }
	
	public boolean parseCreateCertificate(JSONObject object)
	{
		boolean userAtuh=false;
		
        try 
        {
             userAtuh= object.getBoolean("Value");
        }
        catch (JSONException e) 
        {
             Log.d("JSONParser => parseUserAuth", e.getMessage());
        }

        return userAtuh;
	}
	
	public StudentInfo parseStudentInfo(JSONObject object)
	{
		StudentInfo studentInfo = new StudentInfo();
		
		try 
		{
             JSONObject jsonObj=object.getJSONArray("Value").getJSONObject(0);
             
             studentInfo.setYearOfStudy(jsonObj.getString("yearOfStudy"));
             studentInfo.setLastName(jsonObj.getString("lastName"));
             studentInfo.setFistName(jsonObj.getString("firstName"));
             studentInfo.setDomain(jsonObj.getString("domain"));
             studentInfo.setSpecialty(jsonObj.getString("specialty"));
             studentInfo.setStatute(jsonObj.getString("statute"));
             studentInfo.setMark(jsonObj.getString("mark"));
             studentInfo.setFinancialSource(jsonObj.getString("financialSource"));

        } 
		catch (JSONException e) 
        {
             Log.d("JSONParser => parseUserDetails", e.getMessage());
        }

		return studentInfo;
	}
	
	public ArrayList<Marks> parseMarks(JSONObject object)
	{
		ArrayList<Marks> marks = new ArrayList<Marks>();
		
		try 
		{
            JSONArray jsonArray=object.getJSONArray("Value");
            JSONObject jsonObj=null;
            for(int i=0;i<jsonArray.length();i++)
            {
                  jsonObj=jsonArray.getJSONObject(i);
                  marks.add(new Marks(jsonObj.getString("subjectName"), jsonObj.getString("semester"), jsonObj.getString("attempt1"), jsonObj.getString("attempt2"), jsonObj.getString("attempt3"), jsonObj.getString("activityGrade"), jsonObj.getString("credits"), jsonObj.getString("department")));
            }

        }
		catch (JSONException e) 
		{
            Log.d("JSONParser => parseMarks", e.getMessage());
		}
		
		return marks;
	}
}
