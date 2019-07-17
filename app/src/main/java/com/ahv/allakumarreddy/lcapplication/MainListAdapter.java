package com.ahv.allakumarreddy.lcapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainListAdapter extends ArrayAdapter<Player> {

    private final MainListAdapterInterface mMainListAdapterInterface;
    private Player[] dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView score;
        TextView position;
        View mainView;
        View out;
    }

    public MainListAdapter(Player[] data, Context context, MainListAdapterInterface mainListAdapterInterface) {
        super(context, R.layout.row, data);
        this.dataSet = data;
        this.mContext = context;
        this.mMainListAdapterInterface = mainListAdapterInterface;
    }

    private int lastPosition = -1;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Player dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.score = (TextView) convertView.findViewById(R.id.score);
            viewHolder.position = (TextView) convertView.findViewById(R.id.position);
            viewHolder.mainView = (View) convertView.findViewById(R.id.mv);
            viewHolder.out = (View) convertView.findViewById(R.id.out);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        lastPosition = position;

        viewHolder.name.setText(dataModel.getName());
        viewHolder.score.setText("" + dataModel.getTotal());
        viewHolder.position.setText("" + dataModel.getPosition());
        if (dataModel.isOut())
            viewHolder.out.setVisibility(View.VISIBLE);
        viewHolder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("pavan", "pos -> " + position);
                mMainListAdapterInterface.clicked(position);
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
