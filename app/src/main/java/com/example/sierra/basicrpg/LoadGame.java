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
        byte[] se = new byte[20];
        int re;
        String s = "";
        FileInputStream fis = openFileInput(FILENAME);
        re = fis.read(se);
        for(int i = 0; i < re; i++)
        {
            s = s + (char) se[i];
        }
        TextView textView = (TextView) findViewById(R.id.messplay);
        textView.setText(s);
    }
}
