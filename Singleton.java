package freshworks;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Singleton {
	static File file = new File("./employee.json");   
	static Map<String, JSONObject> dataStore = null;

	private static Singleton instance = null;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	protected void performFileOperation(String operation, String key, JSONObject obj) {
		if (operation.equals("CREATE")) {
			createOperation(key, obj);
		} else if (operation.equals("READ")) {
			readOperation(key);
		} else if (operation.equals("DELETE")) {
			deleteOperation(key);
		}
	}

	private static void createOperation(String key, JSONObject obj) {
		dataStore = new HashMap<String, JSONObject>();

		try {
			ObjectMapper mapper = new ObjectMapper();
			if (!file.exists()) {
				dataStore.put(key, obj);
				mapper.writeValue(file, dataStore);
			} else {
				dataStore = mapper.readValue(new File("C:\\Users\\Cherry\\employee.json"), Map.class);
				if(dataStore.containsKey(key))
				{
					System.out.print("The Key already exists in the JSON file. Enter a different key");
				}
				else
				{
					dataStore.put(key, obj);
					mapper.writeValue(new File("C:\\Users\\Cherry\\employee.json"), dataStore);
				}
			}

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readOperation(String key) {

		dataStore = new HashMap<String, JSONObject>();

		try {
			ObjectMapper mapper = new ObjectMapper();
			if (!file.exists()) {
				// Exception  if file not exists
				System.out.println("The File does not exist. First create a file");
			} else {
				dataStore = (Map<String, JSONObject>) mapper.readValue(file, Map.class);
				// Exception: input key does not match with json file content
				String json = mapper.writeValueAsString(dataStore.get(key));
				if ("".equals(json) || "null".equals(json)) {
					// Exception 2: if key is invalid/ no data found
					System.out.println("No value found for Key:" + key);
					System.out.println("Enter a valid key or create a new key using CREATE operation");
				} else {
					System.out.println("Value is " + json);
				}

			}

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void deleteOperation(String key) {

		dataStore = new HashMap<String, JSONObject>();

		try {
			ObjectMapper mapper = new ObjectMapper();
			if (!file.exists()) {
				// Exception if file does not exist
				System.out.println("The File does not exist. First create a file");
			} else {
				dataStore = mapper.readValue(file, new TypeReference<Map<String, Object>>() {
				});
				if(dataStore.containsKey(key))
				{
				dataStore.remove(key);
				mapper.writeValue(new File("C:\\Users\\Cherry\\employee.json"), dataStore);
				}
				else
				{
					System.out.println("Key does not exist. Enter a valid key or create a new key using CREATE Opeartion");
				}

			}

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
