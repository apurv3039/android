package com.sgmovie.listviewonclicklistner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView list = (ListView) findViewById(R.id.theatre_list_view);
        String jsonObject="{\"status\":200,\"data\":[{\"id\":\"1\",\"theatre_name\":\"Shaw Theatres Lido\"},{\"id\":\"3\",\"theatre_name\":\"Shaw Theatres Seletar Lido\"},{\"id\":\"2\",\"theatre_name\":\"Shaw Theatres Seletar\"}]}";

        try {

            JSONObject jObj = new JSONObject(jsonObject);
            int status = Integer.parseInt(jObj.getString("status"));
            String get_data = jObj.getString("data");
            //JSONObject jObj1 = new JSONObject(get_data);
            if (status == 200) {
                JSONArray jarray = new JSONArray(get_data);
                ArrayList<HashMap<String, String>> titles = new ArrayList<>();
                for (int i = 0; i < jarray.length(); ++i) {
                    JSONObject rec = jarray.getJSONObject(i);
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("theatre_name", rec.getString("theatre_name"));

                    titles.add(map);

                }
                adapter = new ListViewAdapter(this, titles);
                list.setAdapter(adapter);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
