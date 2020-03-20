package andr.mxg167030_asg4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ScoreListAdapter extends ArrayAdapter<HighScore>{

    private Context context;
    private int item_resource;
    String pattern = "MM-dd-yyyy";

    public ScoreListAdapter(Context context, int item_layout, ArrayList highScores) {
        super(context, item_layout, highScores);
        this.context = context;
        item_resource = item_layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String name = getItem(position).getName();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(getItem(position).getDate());
        String score = Integer.toString(getItem(position).getScore());

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(item_resource, parent, false);

        TextView name_view = (TextView) convertView.findViewById(R.id.name_text_view);
        TextView date_view = (TextView) convertView.findViewById(R.id.date_text_view);
        TextView score_view = (TextView) convertView.findViewById(R.id.score_text_view);

        name_view.setText(name);
        date_view.setText(date);
        score_view.setText(score);

        return convertView;



    }
}