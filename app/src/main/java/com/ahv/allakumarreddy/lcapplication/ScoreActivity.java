package com.ahv.allakumarreddy.lcapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        init();
    }

    private void init() {

        StringBuilder sb = new StringBuilder();
        for (String s : Utils.getNames())
            sb.append(s + "\n");
        ((TextView) findViewById(R.id.names)).setText(sb.toString().substring(0, sb.toString().length() - 1));
    }


    public void addScores(View view) {
        String ar[] = ((EditText) findViewById(R.id.score)).getText().toString().split("\n");
        Player[] players = Utils.getPlayers();
        String[] names = Utils.getNames();
        final int len = players.length;
        for (int i = 0; i < ar.length; i++) {
            String name = names[i];
            for (int j = 0; j < players.length; j++) {
                if (name.compareToIgnoreCase(players[j].getName()) == 0) {
                    players[j].add(Integer.parseInt(ar[i]));
                    break;
                }
            }
        }

        // sorting

        final int plen = players.length;
        for (int i = 0; i < plen; i++) {
            for (int j = i + 1; j < plen; j++) {
                if (players[i].getTotal() > players[j].getTotal()) {
                    Player temp = new Player();
                    temp.setName(players[i].getName());
                    temp.setTotal(players[i].getTotal());
                    temp.setPosition(players[i].getPosition());
                    temp.setScores(players[i].getScores());
                    temp.setOut(players[i].isOut());

                    players[i] = players[j];
                    players[j] = temp;
                }
            }
        }
        for (int i = 0; i < plen; i++) {
            players[i].setPosition(i + 1);
            if (players[i].getTotal() >= Utils.getmScoreLimit())
                players[i].setOut(true);
        }
        finish();
    }
}
