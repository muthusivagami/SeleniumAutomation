package DataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON {
	// For json execution, we need Simple JSON
			//Add the dependency of Simple JSON from  maven repository
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//Parse the JSON physical file into Java object using JSON parser class
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./Testdata/Data.json"));
		//convert the java object into JSON object(Typecasting)
		JSONObject obj1 = (JSONObject) obj;
		System.out.println(obj1.get("Browser"));
		System.out.println(obj1.get("Url"));
		System.out.println(obj1.get("Username"));
		System.out.println(obj1.get("Password"));
	}

}
