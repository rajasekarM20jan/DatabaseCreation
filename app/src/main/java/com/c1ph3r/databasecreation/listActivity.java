package com.c1ph3r.databasecreation;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listActivity extends AppCompatActivity {
    ListView listOfData;
    String[] data = {"name", "phone"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listOfData = findViewById(R.id.listView);
        DbClass dbClass = new DbClass(this);
        SQLiteDatabase db2 = dbClass.getReadableDatabase();
        Cursor c = db2.query("Interns", data, null, null, null, null, null);
        ArrayList list = new ArrayList<>();
        while (c.moveToNext()) {
            list.add(c.getString(0));
            list.add(c.getString(1));
            System.out.println(list);
            ListAdapter adapter = new ArrayAdapter<>(listActivity.this, android.R.layout.simple_list_item_1, list);
            listOfData.setAdapter(adapter);
        }
    }
}
