package com.example.sierra.basicrpg;

/**
 * Created by aamorris on 11/8/2016.
 */

public class Enemy
{
    public int hp;
    public int def;
    public int atk;
    public String enemyName;

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
