package com.example.administrator.databasehelo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private DbHelper dbHelper;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);
        dbHelper = new DbHelper(this);
        initData();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("class", null, null, null, null, null, null);
        String[] from = {"_id", "name", "number"};
        listView = findViewById(R.id.listView1);
        int[] to = {R.id.textView1, R.id.textView2, R.id.textView3};
        adapter = new SimpleCursorAdapter(this, R.layout.my, cursor, from, to);
        listView.setAdapter(adapter);
    }

    public void initData() {
        dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "梨花");
        values.put("number", "123456");
        db.insert("class", null, values);
        values.put("name", "翠花");
        values.put("number", "654321");
        db.insert("class", null, values);
        values.clear();
    }
}
