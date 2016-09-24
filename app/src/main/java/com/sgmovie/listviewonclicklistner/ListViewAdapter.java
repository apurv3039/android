package com.sgmovie.listviewonclicklistner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static android.support.v7.widget.RecyclerView.ViewHolder;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    private int lastPosition = -1;

    ViewHolder holder;
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;

    HashMap<String, String> resultp = new HashMap<String, String>();
    int pointer;

    public ListViewAdapter(Context context,
                           ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;

        data = arraylist;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listview_item, parent, false);


            TextView theatreTitle;
            ImageView flag;
            lastPosition = position;
            // Get the position
            resultp = data.get(position);


            // Locate the TextViews in listview_item.xml
            theatreTitle = (TextView) itemView.findViewById(R.id.title);
            Button button1 = (Button) itemView.findViewById(R.id.button1);
            Button button2 = (Button) itemView.findViewById(R.id.button2);
            theatreTitle.setText(resultp.get("theatre_name"));
            final String thetre_name=resultp.get("theatre_name");




        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Get the position
                Toast.makeText(context, thetre_name + " Button1 Click", Toast.LENGTH_LONG).show();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Get the position
                Toast.makeText(context, thetre_name+" Button2 Click", Toast.LENGTH_LONG).show();

            }
        });
        return itemView;
    }
}
