package com.example.sierra.basicrpg;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.sierra.basicrpg.R.drawable.buttonf;
import static com.example.sierra.basicrpg.R.drawable.nullimage;

public class OverworldScreen extends AppCompatActivity {

    private GoogleApiClient client;

    public ImageView c[] = new ImageView[9];
    public Location cl[] = new Location[9];
    Location blank = new Location(0, nullimage,null,true, true, true, true);

    public int curscreen;
    public int curlocation = 4;
    public int prevLoc = curlocation;

    int x;
    int y;


    Character go;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overworld_screen);
        Intent intent = getIntent();

        go = (Character) intent.getSerializableExtra("Character");


        c[0] = (ImageView) findViewById(R.id.cell1);
        c[1] = (ImageView) findViewById(R.id.cell2);
        c[2] = (ImageView) findViewById(R.id.cell3);
        c[3] = (ImageView) findViewById(R.id.cell4);
        c[4] = (ImageView) findViewById(R.id.cell5);
        c[5] = (ImageView) findViewById(R.id.cell6);
        c[6] = (ImageView) findViewById(R.id.cell7);
        c[7] = (ImageView) findViewById(R.id.cell8);
        c[8] = (ImageView) findViewById(R.id.cell9);


        setScreen(new Screen());

        moveChar(1);
        moveChar(4);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void setScreen(Screen s)
    {
        for(int i = 0; i < s.l.length; i++ )
            cl[i] = s.l[i];
        cl[curlocation] = blank;

        c[0].setImageResource(cl[0].sprite);
        c[1].setImageResource(cl[1].sprite);
        c[2].setImageResource(cl[2].sprite);
        c[3].setImageResource(cl[3].sprite);
        c[4].setImageResource(cl[4].sprite);
        c[5].setImageResource(cl[5].sprite);
        c[6].setImageResource(cl[6].sprite);
        c[7].setImageResource(cl[7].sprite);
        c[8].setImageResource(cl[8].sprite);
    }

    public void setCharLoc()
    {
        c[curlocation].setImageResource(go.sprite);
        c[prevLoc].setImageResource(cl[prevLoc].sprite);
        prevLoc = curlocation;
    }

    public void moveChar(int dir)
    {
        switch(dir)
        {
            case 1:
            {
                if (curlocation > 2){
                    curlocation = curlocation - 3;
                    setCharLoc();
                }
                break;
            }

            case 2:
            {
                if(!(curlocation == 0) && !(curlocation == 3) && !(curlocation == 6)){
                    curlocation--;
                    setCharLoc();
                }
                break;
            }
            case 3:
            {
                if(!(curlocation == 2) && !(curlocation == 5) && !(curlocation == 8)){
                    curlocation++;
                    setCharLoc();
                }
                break;
            }
            case 4:
            {
                if(curlocation <6){
                    curlocation = curlocation + 3;
                    setCharLoc();
                }
                break;
            }
        }
        if(curlocation == 8)
        {

        }
    }

    public void moveUp(View view)
    {
        moveChar(1);
    }

    public void moveLeft(View view)
    {
        moveChar(2);
    }

    public void moveRight(View view)
    {
        moveChar(3);
    }

    public void moveDown(View view)
    {
        moveChar(4);
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
