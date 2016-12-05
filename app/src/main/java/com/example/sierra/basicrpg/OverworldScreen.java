package com.example.sierra.basicrpg;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Arrays;

import static com.example.sierra.basicrpg.R.drawable.nullimage2;

public class OverworldScreen extends AppCompatActivity {

    private GoogleApiClient client;
    public ImageView c1;
    public ImageView c2;
    public ImageView c3;
    public ImageView c4;
    public ImageView c5;
    public ImageView c6;
    public ImageView c7;
    public ImageView c8;
    public ImageView c9;

    public Location cl1;
    public Location cl2;
    public Location cl3;
    public Location cl4;
    public Location cl5;
    public Location cl6;
    public Location cl7;
    public Location cl8;
    public Location cl9;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overworld_screen);
        Intent intent = getIntent();

        Character go = (Character) intent.getSerializableExtra("Character");

        c1 = (ImageView) findViewById(R.id.cell1);
        c2 = (ImageView) findViewById(R.id.cell2);
        c3 = (ImageView) findViewById(R.id.cell3);
        c4 = (ImageView) findViewById(R.id.cell4);
        c5 = (ImageView) findViewById(R.id.cell5);
        c6 = (ImageView) findViewById(R.id.cell6);
        c7 = (ImageView) findViewById(R.id.cell7);
        c8 = (ImageView) findViewById(R.id.cell8);
        c9 = (ImageView) findViewById(R.id.cell9);

        Screen map[] = new Screen[9];
        Arrays.fill(map, new Screen());

        int temp = intent.getIntExtra("Location", 5);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void setScreen(Screen s)
    {
        cl1 = s.l1;
    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("OverworldScreen Page")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();


        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();


        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
