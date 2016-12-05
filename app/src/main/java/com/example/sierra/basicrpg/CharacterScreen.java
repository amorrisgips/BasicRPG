package com.example.sierra.basicrpg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import java.io.IOException;
import java.io.Serializable;

import static com.example.sierra.basicrpg.MainActivity.KVFILENAME;
import static com.example.sierra.basicrpg.R.drawable.enemy1;

public class CharacterScreen extends AppCompatActivity {

    public EditText charName;
    public Button save;
    public Switch swiil, swip;
    public boolean swipstate = true;
    public boolean swiilstate = true;
    public String message;
    public Spinner classes;
    public String choice;
    public Button battle;
    Character Hero = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);

        battle = (Button) findViewById(R.id.tobattle);
        battle.setClickable(false);
        charName = (EditText) findViewById(R.id.charName);
        save = (Button) findViewById(R.id.save);
        swip = (Switch) findViewById(R.id.switchP);
        swip.setChecked(true);
        swiil = (Switch) findViewById(R.id.switchIL);
        swiil.setChecked(true);
        classes = (Spinner) findViewById(R.id.classes);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.classes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classes.setAdapter(adapter);

        swip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    swipstate = true;
                }
                else {
                    swipstate = false;
                }
            }
        });
        swiil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    swiilstate = true;
                }
                else {
                    swiilstate = false;
                }
            }
        });
    }

    public void blankName(View view){
        charName.setText("");
    }

    public void saveInfo(View view) throws IOException, InterruptedException {
        message = charName.getText().toString();
        choice = classes.getSelectedItem().toString();
        String CharName = message + " the " + choice;
        int hp;
        int mp;
        int armPref;
        int wepPref;

        switch(choice)
        {
            case "Warrior" :
                hp = 25;
                mp = 10;
                armPref = 2;
                wepPref = 3;
                break;
            case "Mage" :
                hp = 15;
                mp = 23;
                armPref = 1;
                wepPref = 1;
                break;
            case "Archer" :
                hp = 23;
                mp = 13;
                armPref = 2;
                wepPref = 2;
                break;
            case "Paladin" :
                hp = 30;
                mp = 5;
                armPref = 5;
                wepPref = 5;
                break;
            case "Thief" :
                hp = 20;
                mp = 15;
                armPref = 3;
                wepPref = 2;
                break;
            default:
                hp = 10;
                mp = 10;
                armPref = 10;
                wepPref = 10;
        }

        Hero = new Character(CharName, hp, mp, armPref, wepPref);


        SharedPreferences settings = getSharedPreferences(KVFILENAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("permadeath", swipstate);
        editor.putBoolean("iLeveling", swiilstate);
        editor.putString("charName", CharName);

        editor.apply();
        Toast.makeText(getApplicationContext(),R.string.saved, Toast.LENGTH_SHORT).show();

        battle.setClickable(true);
    }

    public void toMap(View view)
    {
        Intent intent = new Intent(this,OverworldScreen.class);
        intent.putExtra("Character", Hero);
        //intent.putExtra("Enemy", new Enemy("Grem", 10, 1, 1, 2));
        startActivity(intent);
    }

}
