package com.cognizant.microservice.demo;

import java.io.StringBufferInputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonValue;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valet")
public class HotelValetController {

	private final static Logger LOGGER = Logger.getLogger(HotelValetController.class.getName()); 
    private final static String CLASSNAME="HotelValetController";

    
    @RequestMapping(value="/process",method=RequestMethod.POST)
    public void process(@RequestBody String payload) {
    	String methodName="process";
    	LOGGER.entering(CLASSNAME, methodName);
    	System.out.println("Request body is:"+payload);
    	JsonReader reader=Json.createReader(new StringBufferInputStream(payload));
    	//JsonStructure structure=reader.read();
    	JsonObject structure=reader.readObject();
    	//JsonString stringValue=(JsonString)structure.get("text");
    	Set jsonStructure=structure.entrySet();
    	Iterator iterator=jsonStructure.iterator();
    	int newIndex=0;
    	while(iterator.hasNext()){
    		Entry<String,JsonValue> entry=(Entry<String,JsonValue>)iterator.next();
    		System.out.println("Index:"+newIndex);
    		System.out.println("Key is"+entry.getKey());
    		System.out.println("value is"+entry.getValue().toString());
    		newIndex++;
    	}
    	JsonArray result=structure.getJsonArray("result");
    	if(result!=null){
    		JsonObject messageObject=result.getJsonObject(0);
    		if(messageObject!=null){
    			JsonString stringText=messageObject.getJsonString("text");
            	System.out.println("Text value is::"+stringText.getString());	
    		}else{
    			System.out.println("Message object is null");
    		}
        		
    	}else{
    		System.out.println("Result array is null");
    	}
    	
    	/*Iterator< JsonValue> arrayContents=result.iterator();
    	while(arrayContents.hasNext()){
    		JsonValue value=arrayContents.next();
    		if(value.getValueType().equals(ValueType.OBJECT)){
    			value.
    			JsonObject object=(JsonValue)value.;
    		}
    	}*/
    //	JsonObject messageObject=result.getJsonObject("message");
    	//jsobject.getV
    	
    	//JsonArray array=reader.r
    	//structure.
    	/*ValueType vt=structure.getValueType();
    	System.out.println("Parent Name"+structure.getValueType().name());
    	System.out.println("Parent value type"+structure.toString());
    	System.out.println("String value for text is:"+stringValue.getString());
    	//JsonValue jv=structure.getValueType().;
    	int comparop=vt.compareTo(ValueType.ARRAY);
    	System.out.println("Output compared to array is:"+comparop);
    	//if(vt.valueOf("text"))
    	//ValueType text=vt.valueOf("text");
    	ValueType text=null;
    	ValueType[] elements=vt.values();
    	int index=0;
    	
    	for(ValueType values:elements){
    		//values.
    		//values.
    		//values.
    		System.out.println("Index:"+index);
    		System.out.println("Name:"+values.name());
    		System.out.println("Value:"+values.toString());
    		//values.
    		 
    		if(values.name().equalsIgnoreCase("STRING")){
    			//JsonString st=(JsonString)values.;
    		}
    		if("text".equalsIgnoreCase(values.name())){
    			text=values;
    			break;
    		}
    		index++;
    	}
    	
    	if(text!=null){
    		String inputtext=text.toString();
            System.out.println("Entered text is::"+inputtext);	
    	}else{
    		System.out.println("No valuetype for key text");
    		
    	}
    	*/
       // return null;
        
        
        
    }
   
    
}
