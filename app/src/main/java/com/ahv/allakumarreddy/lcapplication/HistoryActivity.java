package com.ahv.allakumarreddy.lcapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        int index = getIntent().getIntExtra("playerIndex", -1);
        mListView = (ListView) findViewById(R.id.lv);
        ArrayList<Integer> scores = Utils.getPlayers()[index].getScores();
        String score[] = new String[scores.size()];
        for (int i = 0; i < score.length; i++) {
            score[i] = "Cycle [ "+(i+1)+" ] -> "+scores.get(i);
        }
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,score));
    }

    public void close(View view) {
        finish();
    }
}
