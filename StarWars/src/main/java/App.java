import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.web.client.RestTemplate;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class App {

    public static void main(String[] args) {

        // Use RestTemplate for request/response
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://swapi.dev/api/planets";
        String response = restTemplate.getForObject(url, String.class);

        // Use Gson to parse response
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(response, JsonObject.class);
        JsonArray results = json.getAsJsonArray("results");

        // Create list of planets
        List<Planet> planets = new ArrayList<>();
        for (JsonElement planet : results) {
            JsonObject planetObject = planet.getAsJsonObject();
            String name = planetObject.get("name").getAsString();
            int diameter = planetObject.get("diameter").getAsInt();
            String climate = planetObject.get("climate").getAsString();
            String gravity = planetObject.get("gravity").getAsString();
            String population = planetObject.get("population").getAsString();
            planets.add(new Planet(name, diameter, climate, gravity, population));
        }

        // Write to CSV file
        try {

            FileWriter writer = new FileWriter("planets.csv");
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            for (Planet planet : planets) {
                csvPrinter.printRecord(planet.toString());
            }

            csvPrinter.flush();
            csvPrinter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}