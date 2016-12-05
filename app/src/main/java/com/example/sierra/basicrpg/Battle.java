package com.example.sierra.basicrpg;

import android.content.Intent;
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

public class Battle extends AppCompatActivity {

    TextView chnm;
    TextView ennm;
    TextView HP;
    TextView EHP;
    ImageView chara;
    ImageView enmy;
    ProgressBar charHp;
    ProgressBar enmyHp;
    Character go;
    Enemy bad;
    int Chealth;
    int Ehealth;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        Intent intent = getIntent();
        go = (Character) intent.getSerializableExtra("Character");
        bad = (Enemy) intent.getSerializableExtra("Enemy");

        Chealth = go.maxHealth;
        Ehealth = bad.hp;

        chnm = (TextView) this.findViewById(R.id.CharaName);
        chnm.setText(go.charName + "  lvl" + go.getLevel());

        ennm = (TextView) this.findViewById(R.id.EnmyName);
        ennm.setText(bad.enemyName);

        charHp = (ProgressBar) findViewById(R.id.CharHp);
        charHp.setMax(go.maxHealth * 100);
        charHp.setProgress(Chealth * 100);

        enmyHp = (ProgressBar) findViewById(R.id.EnmyHp);
        enmyHp.setMax(bad.hp * 100);
        enmyHp.setProgress(Ehealth * 100);

        chara = (ImageView) findViewById(R.id.CharSprite);
        enmy = (ImageView) findViewById(R.id.EnmySprite);

        HP = (TextView) findViewById(R.id.HPnum);
        HP.setText("" + go.maxHealth);

        EHP = (TextView) findViewById(R.id.EHPnum);
        EHP.setText("" + bad.hp);

        //vvvvvvvvvvv
        go.attack = 5;
        go.defence = 3;
        //^^^^^^^^^^^

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void setSprites()
    {
        chara.setImageResource(go.sprite);
        enmy.setImageResource(bad.sprite);
    }

    public void attackAnim(View view) {
        int temp = Ehealth;
        chara.setImageResource(go.atkSprite);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                chara.setImageResource(go.sprite);
            }
        }, 1000);

        if(1 < (go.attack - bad.def))
            temp = temp - (go.attack - bad.def);
        else
            temp--;

        ProgressAnim(enmyHp, Ehealth, temp);
        Ehealth = temp;

        EHP.setText("" + Ehealth);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                enmy.setImageResource(bad.atkSprite);
            }
        }, 1500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                enmy.setImageResource(bad.sprite);

                int temp;
                temp = Chealth;
                if(1 < (bad.atk - go.defence))
                    temp = temp - (bad.atk - go.defence);
                else
                    temp--;

                ProgressAnim(charHp, Chealth, temp);
                Chealth = temp;

                HP.setText("" + Chealth);
            }
        }, 2000);


    }

    public void ProgressAnim(ProgressBar p, int from, int to) {
        ProgressBarAnimation anim = new ProgressBarAnimation(p, 100 * from, 100 * to);
        anim.setDuration(1000);
        p.startAnimation(anim);
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
