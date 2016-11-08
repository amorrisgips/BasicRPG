package com.example.sierra.basicrpg;

/**
 * Created by aamorris on 11/7/2016.
 */

public class Weapon extends Equipment
{

    public int pref;
    public int atkMod;

    public Weapon(int atk, int prf)
    {
        atkMod = atk;
        pref = prf;
    }

    public int retAtk()
    {
        return atkMod;
    }

    public int retPref()
    {
        return pref;
    }

}
