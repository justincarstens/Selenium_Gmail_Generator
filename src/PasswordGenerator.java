import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import java.util.logging.Logger;

public class PasswordGenerator {

    private static final Logger LOGGER = Logger.getLogger(PasswordGenerator.class.getName());
    public static String random_password;

    public String Generate() throws Exception {

        Gson gson = new Gson();

        HttpClient httpClient = HttpClient.newHttpClient();

        String apiKey = getApiKey();

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.api-ninjas.com/v1/passwordgenerator?length=16"))
                .headers("X-Api-Key", apiKey)
                .build();

        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        PasswordResponse passwordResponse = gson.fromJson(getResponse.body(), PasswordResponse.class);

        random_password = passwordResponse.getRandom_password();

        return random_password;
    }

    public static String getApiKey() {
        //Reading API Key from config.properties file to ensure API Key stays private
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            LOGGER.severe("Error reading configuration: " + e.getMessage());
        }
        return properties.getProperty("api.key");
    }
}
