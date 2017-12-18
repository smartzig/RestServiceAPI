package br.com.smartzig.rest.service.basic.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Test {

	private static String hostLocation = "localhost:8081";

	public static void main(String[] args) {


		String nameParam = "param=Candy";

		String greetingUrl = "http://"+ hostLocation + "/rest-service/rest/basicservice/greeting?";
		String greetingFullLink = greetingUrl+nameParam;

		String basicChartUrl = "http://"+ hostLocation + "/rest-service/rest/basicservice/basicchart?";
		String basicChartFullLink = basicChartUrl;
		
		

		//Greeting
		try {

			String jsonStr;

			jsonStr = readUrl(greetingFullLink);
			System.out.println("Getting From: " + greetingFullLink);
			System.out.println("Response from url: " + jsonStr);

			Thread.sleep(2000);	
		} catch (Exception e1) {
			
			System.out.println("Json parsing error: " + e1.getMessage());
		}

		//basicChartUrl
		try {

			String jsonStr;

			jsonStr = readUrl(basicChartFullLink);
			System.out.println("Getting From: " + basicChartFullLink);
			System.out.println("Response from url: " + jsonStr);
			if (jsonStr != null) {

				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(jsonStr);
				JsonObject obj = element.getAsJsonObject(); //since you know it's a JsonObject

				Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();//will return members of your object
				for (Map.Entry<String, JsonElement> entry: entries) {
					System.out.println("KEY: "+entry.getKey() +" Value: "+ entry.getValue());
				}

			}

			Thread.sleep(2000);	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Json parsing error: " + e1.getMessage());
		}



	}

	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read); 

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

}
