package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
    public static String readJson(String filename, String key) {
        JSONParser parser = new JSONParser();
        String value = null;

        try {
            // Read the JSON file
            File file = new File(filename);
            Object obj = parser.parse(new FileReader(file));

            // Convert the file to a JSON object
            JSONObject jsonObject = (JSONObject) obj;

            // Get the value of the specified key
            value = (String) jsonObject.get(key);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return value;
    }
}
