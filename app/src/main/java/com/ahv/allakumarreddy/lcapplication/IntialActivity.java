package com.ahv.allakumarreddy.lcapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class IntialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intial);
    }

    public void add(View view) {
        String s = ((EditText) findViewById(R.id.names)).getText().toString();
        String ar[] = s.split("\n");
        Player[] players = new Player[ar.length];
        for (int i = 0; i < ar.length; i++) {
            players[i] = new Player();
            players[i].setName(ar[i]);
            players[i].setTotal(0);
        }
        Utils.setPlayers(players);
        Utils.setOutScoreLimit(Integer.parseInt(((TextView)findViewById(R.id.score_limit)).getText().toString()));
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
