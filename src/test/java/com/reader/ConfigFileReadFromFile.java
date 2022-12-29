package com.reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;

public class ConfigFileReadFromFile {
	
	public void getJsonAmazonUrl() {
		JSONParser parser = new JSONParser();
		try {
	        Object obj = parser.parse(new FileReader("configFile.json"));
	        JSONObject jsonObject = (JSONObject) obj;
	        JSONArray urlList = (JSONArray) jsonObject.get("AMAZON_URL");
	        Iterator<JSONObject> iteratorURL = urlList.iterator();
	        System.out.println(iteratorURL.next());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public String getJsonValueOf(String URL) {
		String returnURL = null;
		JSONParser parser = new JSONParser();
		try {
	        Object obj = parser.parse(new FileReader("configFile.json"));
	        JSONObject jsonObject = (JSONObject) obj;
	        returnURL = (String) jsonObject.get(URL);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return returnURL;
	}
	
	 @SuppressWarnings("unchecked")
	    public static void main(String[] args) {
		 ConfigFileReadFromFile configFileReadFromFile = new ConfigFileReadFromFile();
		 String test = configFileReadFromFile.getJsonValueOf("AMAZON_URL");
		 System.out.println("El valor es: " + test);
	    }
}