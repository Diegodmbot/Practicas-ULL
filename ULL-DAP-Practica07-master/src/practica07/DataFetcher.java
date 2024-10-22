package practica07;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class DataFetcher {
    final String TOKEN_NAME = "X-Auth-Token";
    final String TOKEN_VALUE = "95c1609b64c845689d0f9db0de4fe44a";
    JSONObject obj;
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    String url;

    // url : "https://api.football-data.org/v4/competitions/WC/scorers?season=2022"
    // name : "X-Auth-Token"
    // value : "95c1609b64c845689d0f9db0de4fe44a"

    public void setUrl(String url) {
        this.url = url;
    }
    private void setHTTPSRequest(String name, String value) {
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header(name , value)
                .build();
    }
    public String getHTTPSResponse() throws IOException, InterruptedException {
        this.client = HttpClient.newHttpClient();
        setHTTPSRequest(TOKEN_NAME, TOKEN_VALUE);
        try {
            this.response = this.client.send(this.request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Status: " + this.response.statusCode());
        return this.response.body();
    }

    public JSONObject getData() {
        try {
            obj = new JSONObject(getHTTPSResponse());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
