package com.example.test.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SpecificationService {
	HashMap<String,Long> map = new HashMap<>();
	
	void addEntry(String key, Long value,long timeout) {
        //set timeout for the key-value pair to say 10 seconds
		
         map.put(key, value);
         Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            actionAfterTimeout(key);
        }
        }, timeout*1000);
    }
    
    void actionAfterTimeout(String key) {
        System.out.println("Inside after action");
        map.remove(key);
        System.out.println("map after remove:"+map);
    }
    
    List<String> getMapKeys()
    {
    	return new ArrayList<>(map.keySet());
    }
    
    boolean checkLimit(String clientName, String type,String specificationType,long typeLimit)
    {
    	if(typeLimit==0)
    		return true;
    	else
    	{
    		String key = clientName+"_"+specificationType+"_"+type;
    		if(map.containsKey(key))
    		{
    			if(map.get(key)==0)
    				return false;
    			else
    				map.put(key, map.get(key)-1);
    		}
    		else
    		{
    			addEntry(key,typeLimit-1,expiryTime(type));
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
