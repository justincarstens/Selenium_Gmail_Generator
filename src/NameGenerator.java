import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameGenerator {

    public static String name;

    public String Generate() throws Exception {

        Gson gson = new Gson();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.namefake.com/english/"))
                .build();

        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        NameResponse nameResponse = gson.fromJson(getResponse.body(), NameResponse.class);

        name = nameResponse.getName();

        String[] titles = {"Dr.", "Mr.", "Mrs.", "Ms.", "Dr", "Mr", "Mrs", "Ms", "Miss"};
        String[] qualifications = {"PHD", "MD", "DDS"};

        String[] nameParts = name.split(" ");

        List<String> filteredNameParts = new ArrayList<>(Arrays.asList(nameParts));
        filteredNameParts.removeAll(Arrays.asList(titles));
        filteredNameParts.removeAll(Arrays.asList(qualifications));

        name = String.join(" ", filteredNameParts);

        return name;
    }

}

