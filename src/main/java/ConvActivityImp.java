
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.google.gson.stream.JsonToken;
//import java.util.HashMap;
//import java.util.Map;
//import org.json.*;

import java.io.*;
import java.net.*;

public class ConvActivityImp implements ConvActivity{
    public static float dollar = 0;

    @Override
    public float Convert_Activity(float USD) {
        try {
            // Http GET request
            URL url = new URL("https://api.fastforex.io/fetch-one?from=USD&to=EGP&api_key=c984d29663-b09bd5c48e-r4debt");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            InputStream responseStream = con.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputline;
            StringBuffer response = new StringBuffer();

            // appending response strings together
            while((inputline = in.readLine()) != null){
                response.append(inputline);
            }
            // Extracting EGP from the String Response
            String[] pairs = response.toString().split(",");
            Float EGP = Float.valueOf(pairs[1].split(":")[2].substring(0,pairs[1].split(":")[2].length()-1)) ;
            dollar = EGP/USD;
            return (EGP*USD);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

    }
}
