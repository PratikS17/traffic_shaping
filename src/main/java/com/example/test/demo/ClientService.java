package com.example.test.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ClientService {

	HashMap<String,Integer> map = new HashMap<>();
	
	HashMap<String,Integer> clientLimit = new HashMap<>();
	
	ClientService()
	{
		clientLimit.put("SEC", 0);
		clientLimit.put("MIN", 50);
		clientLimit.put("HOUR", 100);
		clientLimit.put("WEEK", 900);
		clientLimit.put("MONTH", 10000);
	}
	
	
	void addEntry(String key, Integer value,long timeout) {
        //set timeout for the key-value pair to say 10 seconds
		
         map.put(key, value);
         Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            actionAfterTimeout(key);
        }
        }, timeout * 1000 );
    }
    
    void actionAfterTimeout(String key) {
        System.out.println("Inside after action");
        map.remove(key);
        System.out.println("map after remove:"+map);
    }
    

    boolean checkLimit(String clientName, String type)
    {
    	if(clientLimit.get(type)==0)  // If Limit is set to zero that indicates this type should not be checked for its limit
    		return true;
    	else
    	{
    		String key = clientName+"_"+type;
    		if(map.containsKey(key)) 
    		{
    			if(map.get(key)==0) //If key is present and limit = 0 that indicates any new request after this will be prevented due to limit reached
    				return false;
    			else
    				map.put(key, map.get(key)-1);
    		}
    		else
    		{
    			addEntry(key,clientLimit.get(type)-1,expiryTime(type)); //This indicated first request and a timer will be triggered based on the type.
    		}
    		
    	}
    	return true;
    		
    }
    
    public static Integer expiryTime(String type){

        if (type.equals("SEC"))
        {
        	return 1;
        }else if (type.equals("MIN"))
        {
            return 60;
        }else if (type.equals("HOUR"))
        {
            return 60*60;
        }else if (type.equals("WEEK"))
        {
            return 7*24*3600;
        }else if (type.equals("MONTH"))
        {
            return 30*24*3600;
        }

        return 0;
    }
    
    
}
