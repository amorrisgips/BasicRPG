package com.example.sierra.basicrpg;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.sierra.basicrpg.MainActivity.FILENAME;


public class CharacterScreen extends AppCompatActivity {

    public EditText charName;
    public Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);

        charName = (EditText) findViewById(R.id.charName);
        save = (Button) findViewById(R.id.save);
    }


    public void saveInfo(View view) throws IOException {

        String message = charName.getText().toString();

        FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
        fos.write( message.getBytes());
        fos.close();
    }


}
