import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

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
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close scanner
                scanner.close();

                System.out.println(informationString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
