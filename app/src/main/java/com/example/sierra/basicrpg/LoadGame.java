package com.example.sierra.basicrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.sierra.basicrpg.MainActivity.FILENAME;

public class LoadGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
    }

    public void dispmess(View view) throws IOException {
        int se;
        FileInputStream fis = openFileInput(FILENAME);
        se = fis.read();

        TextView textView = (TextView) findViewById(R.id.messplay);
        textView.setText(se);
    }
}
