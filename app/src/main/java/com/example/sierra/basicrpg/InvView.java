package com.example.sierra.basicrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

import static com.example.sierra.basicrpg.R.drawable.characterstunned;

public class InvView extends AppCompatActivity {

    public Character go;
    public Inventory oth;
    public ScrollView s1;
    public ScrollView s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inv_view);

        Intent intent = getIntent();
        go = (Character) intent.getSerializableExtra("Character");
        oth = (Inventory) intent.getSerializableExtra("Other");

        s1 = (ScrollView) findViewById(R.id.playerInv);
        s2 = (ScrollView) findViewById(R.id.otherInv);

    }
    public void make(View view)
    {

    }
}
