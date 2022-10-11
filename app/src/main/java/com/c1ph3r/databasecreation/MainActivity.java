package com.c1ph3r.databasecreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name,phone;
    Button add,display;

    long row;
    ContentValues values= new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.nameET);
        phone= findViewById(R.id.phoneET);
        add= findViewById(R.id.addbtn);
        display= findViewById(R.id.displaybtn);

        DbClass dbClass= new DbClass(this);
        SQLiteDatabase db1= dbClass.getWritableDatabase();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.length()!=0){
                    if(phone.length()!=0){
                        values.put("name",String.valueOf(name.getText()));
                        values.put("phone",String.valueOf(phone.getText()));
                        row=db1.insert("Interns",null,values);
                        name.setText(null);
                        phone.setText(null);
                    }
                }
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInt();
                }
        });
    }
    void getInt(){
        Intent i=new Intent(this,listActivity.class);
        startActivity(i);
    }
}