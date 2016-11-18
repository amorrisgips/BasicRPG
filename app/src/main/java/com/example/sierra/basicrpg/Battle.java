package com.example.sierra.basicrpg;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.sierra.basicrpg.R.drawable.characterattack;

public class Battle extends AppCompatActivity {

    TextView chnm;
    TextView ennm;
    ImageView chara;
    ImageView enmy;
    ProgressBar charHp;
    ProgressBar enmyHp;
    Character go;
    Enemy bad;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        Intent intent = getIntent();
        go = (Character) intent.getSerializableExtra("Character");
        bad = (Enemy) intent.getSerializableExtra("Enemy");


        chnm = (TextView) this.findViewById(R.id.charName);
        chnm.setText(go.charName);

        charHp = (ProgressBar) findViewById(R.id.CharHp);
        charHp.setMax(go.maxHealth);
        charHp.setProgress(go.maxHealth);

        enmyHp = (ProgressBar) findViewById(R.id.EnmyHp);
        enmyHp.setMax(bad.hp);
        enmyHp.setProgress(bad.hp);

        chara = (ImageView) findViewById(R.id.CharSprite);
        enmy = (ImageView) findViewById(R.id.EnmySprite);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void setSprites()
    {
        chara.setImageResource(go.sprite);
        enmy.setImageResource(bad.sprite);
    }

    public void attackAnim(View view) {
        chara.setImageResource(go.atkSprite);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                chara.setImageResource(go.sprite);
            }
        }, 1000);

    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Battle Page")
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

        setSprites();

        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

}
