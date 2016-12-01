package com.example.sierra.basicrpg;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

import static com.example.sierra.basicrpg.R.drawable.enemy1;
import static com.example.sierra.basicrpg.R.drawable.enemy1atk;
import static com.example.sierra.basicrpg.R.drawable.enemy2;
import static com.example.sierra.basicrpg.R.drawable.enemy2atk;
import static com.example.sierra.basicrpg.R.drawable.enemy3;
import static com.example.sierra.basicrpg.R.drawable.enemy3atk;
import static com.example.sierra.basicrpg.R.drawable.enemy4;
import static com.example.sierra.basicrpg.R.drawable.enemy4atk;

/**
 * Created by aamorris on 11/8/2016.
 */

public class Enemy implements Serializable
{
    public int hp;
    public int def;
    public int atk;
    public String enemyName;
    public int sprite;
    public int atkSprite;
    int c;

    public Enemy(String enmName, int hitp, int defen, int atak, int draw)
    {
        enemyName = enmName;
        hp = hitp;
        def = defen;
        atk = atak;
        c = draw;

        switch(c)
        {
            case 1:
                sprite = enemy1;
                atkSprite = enemy1atk;
                break;
            case 2:
                sprite =enemy2;
                atkSprite = enemy2atk;
                break;
            case 3:
                sprite = enemy3;
                atkSprite = enemy3atk;
                break;
            case 4:
                sprite =enemy4;
                atkSprite = enemy4atk;
                break;

        }
    }



}
