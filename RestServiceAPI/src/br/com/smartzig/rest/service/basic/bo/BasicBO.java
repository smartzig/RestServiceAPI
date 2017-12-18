package br.com.smartzig.rest.service.basic.bo;

import java.util.LinkedHashMap;
import java.util.Map;

public class BasicBO {



	public Map<String, Integer> fetchMockUpInfo() {
		// TODO create the DAO Factory and structure.
		
		Map<String, Integer> mockedUpInfoMap = new LinkedHashMap<String, Integer>();
		mockedUpInfoMap.put("Label1", 0 + (int)(Math.random() *182));
		mockedUpInfoMap.put("Label2", 0 + (int)(Math.random() *182));
		mockedUpInfoMap.put("Label3", 0 + (int)(Math.random() *182));
		return mockedUpInfoMap;
	}

}
