import netscape.javascript.JSObject;


import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

    public static void main(String[] args) {

        //Public API
        //My API key ab246824-a21b-4aee-aeb6-af1f12e3e6f7
        //Get weather for Bristol http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/350612?res=3hourly&key=ab246824-a21b-4aee-aeb6-af1f12e3e6f7

        try {

            URL url = new URL("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/350612?res=3hourly&key=ab246824-a21b-4aee-aeb6-af1f12e3e6f7");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connection is made
            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }

                scanner.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
