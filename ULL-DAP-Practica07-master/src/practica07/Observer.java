package practica07;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Observer {
    private JSONObject obj;
    private ArrayList<Player> players;
    private Ranking ranking;

    public Observer() {
        getPlayersFromData();
        createScorersRaking();
    }

    public void getPlayersFromData() {
        ArrayList<Player> playersList = new ArrayList<>();
        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.setUrl("https://api.football-data.org/v4/competitions/WC/scorers?season=2022");
        this.obj = dataFetcher.getData();
        JSONArray scorers = obj.getJSONArray("scorers");
        for (int i = 0; i < scorers.length(); i++) {
            JSONObject playerInfo = scorers.getJSONObject(i);
            String playerName = playerInfo.getJSONObject("player").getString("name");
            String teamName = playerInfo.getJSONObject("team").getString("name");
            String teamUrl = playerInfo.getJSONObject("team").getString("crest");
            int goals = (int) playerInfo.get("goals");
            Player player = new Player(playerName, teamName, teamUrl, goals);
            playersList.add(player);
        }
        this.players = playersList;
    }

    public JPanel getRanking() throws IOException {
        return ranking.writeRanking();
    }

    public void createScorersRaking() {
        this.ranking = new ScorersRaking(players);
    }

    public void update() {
        this.ranking.update();
    }
}
