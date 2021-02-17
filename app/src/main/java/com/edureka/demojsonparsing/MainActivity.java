package com.edureka.demojsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = new ArrayList<String>();
        String jsonString = getResources().getString(R.string.jsondata);
        Log.i("myjson",jsonString);

        generateList(jsonString);


    }

    private void generateList(String jsonString) {
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray array = obj.getJSONArray("formulas");

            int i;
            for( i=0;i<array.length();i++){
                list.add(array.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("myerror",e.toString());
        }

        ListView lstJsonData = findViewById(R.id.lstJsonData);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                list
        );
        lstJsonData.setAdapter(adapter);
    }
}