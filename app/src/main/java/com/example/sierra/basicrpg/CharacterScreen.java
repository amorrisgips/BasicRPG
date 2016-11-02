package com.example.sierra.basicrpg;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.sierra.basicrpg.MainActivity.FILENAME;
import static com.example.sierra.basicrpg.MainActivity.KVFILENAME;

public class CharacterScreen extends AppCompatActivity {

    public EditText charName;
    public Button save;
    public Switch swiil, swip;
    public boolean swipstate = false;
    public boolean swiilstate = false;
    public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);

        charName = (EditText) findViewById(R.id.charName);
        save = (Button) findViewById(R.id.save);
        swip = (Switch) findViewById(R.id.switchP);
        swiil = (Switch) findViewById(R.id.switchIL);
    }


    public void saveInfo(View view) throws IOException {
        message = charName.getText().toString();
        swip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    swipstate = true;
                }
            }
        });
        swiil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    swiilstate = true;
                }
            }
        });

        FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
        fos.write(message.getBytes());
        fos.close();

        SharedPreferences settings = getSharedPreferences(KVFILENAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("permadeath", swipstate);
        editor.putBoolean("iLeveling", swiilstate);

        editor.apply();

        charName.setText("");
        Toast.makeText(getApplicationContext(),R.string.saved, Toast.LENGTH_SHORT).show();
    }


}
