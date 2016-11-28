package com.example.sierra.basicrpg;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

import static com.example.sierra.basicrpg.R.drawable.enemy1;
import static com.example.sierra.basicrpg.R.drawable.enemy1atk;

/**
 * Created by aamorris on 11/8/2016.
 */

public class Enemy implements Serializable
{
    public int hp;
    public int def;
    public int atk;
    public String enemyName;
    public int sprite = enemy1;
    public int atkSprite = enemy1atk;

    public Enemy(String enmName, int hitp, int defen, int atak)
    {
        enemyName = enmName;
        hp = hitp;
        def = defen;
        atk = atak;
    }

    public int choice()
    {
        return (3);
    }
}
