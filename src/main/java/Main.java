import netscape.javascript.JSObject;


import java.io.FileReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

    public static void main(String[] args) {

        //My API key ab246824-a21b-4aee-aeb6-af1f12e3e6f7
        //Get weather for Bristol http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/350612?res=daily&key=ab246824-a21b-4aee-aeb6-af1f12e3e6f7
        try {
            URL url = new URL("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/350612?res=daily&key=ab246824-a21b-4aee-aeb6-af1f12e3e6f7");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream in = conn.getInputStream();
            String encoding = conn.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            String body = IOUtils.toString(in, encoding);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(body);
            JSONObject siteRep = (JSONObject) json.get("SiteRep");
            JSONObject DV = (JSONObject) siteRep.get("DV");
            JSONObject Location = (JSONObject) DV.get("Location");


            String elevation = (String) Location.get("elevation");
            System.out.println(elevation);

            String LocationName = (String) Location.get("name");
            System.out.println(LocationName);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
