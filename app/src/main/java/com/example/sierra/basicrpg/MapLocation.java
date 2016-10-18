package com.example.sierra.basicrpg;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.R.id.message;

public class MapLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_location);
    }

    public void saveMess(View view) throws IOException {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message1 = editText.getText().toString();
        FileOutputStream fos = openFileOutput("RPG_saveData", Context.MODE_PRIVATE);
        fos.write(message1.getBytes());
        fos.close();
    }

    public void dispMess(View view) throws FileNotFoundException {
        FileOutputStream fos = openFileOutput("RPG_saveData", Context.MODE_PRIVATE);
        Byte b[] = new Byte[10];
        String message2 = fos.read(b);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message2);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_map_location);
        layout.addView(textView);
    }

}
