package practica07;

import java.io.FileWriter;
import java.io.IOException;


import org.json.JSONArray;
import org.json.JSONObject;

public class Test {
    public static void main(String[] args) throws IOException {
        //test1();
        test2();
    }


    public static void test1() throws IOException {
        String url = "https://api.football-data.org/v4/competitions/WC/scorers?season=2022";
        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.setUrl(url);
        JSONObject obj = dataFetcher.getData();
        FileWriter file = new FileWriter("json/output.json");
        file.write(obj.toString(4));
        file.close();
    }
    private static void test2() {
        String url = "https://api.football-data.org/v4/competitions/WC/scorers?season=2022";
        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.setUrl(url);
        JSONObject obj = dataFetcher.getData();
        JSONArray scorers = obj.getJSONArray("scorers");
        for (int i = 0; i < scorers.length(); i++) {
            JSONObject scorer = scorers.getJSONObject(i);
            String playerName = scorer.getJSONObject("player").getString("name");
            String teamName = scorer.getJSONObject("team").getString("name");
            String teamUrl = scorer.getJSONObject("team").getString("crest");
            int goals = (int) scorer.get("goals");
            System.out.println(i+1 + ". "
                    + playerName + " "
                    + teamName + " "
                    + teamUrl + " "
                    + goals);
        }
    }
}
