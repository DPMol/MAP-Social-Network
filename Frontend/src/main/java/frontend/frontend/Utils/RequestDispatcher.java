package frontend.frontend.Utils;

import frontend.frontend.Requests.AbstractRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RequestDispatcher {

    public static <Response> Response Post(AbstractRequest<Response> request, Class<Response> responseClass, String URL) throws IOException {
        URL url;
        try {
            url = new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        var json = JsonConverter.ToJson(request);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return JsonConverter.FromJson(response.toString(), responseClass);
        }
    }
}
