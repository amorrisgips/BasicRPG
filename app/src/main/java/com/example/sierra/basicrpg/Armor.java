package com.example.sierra.basicrpg;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aamorris on 11/7/2016.
 */

public class Armor extends Equipment
{
    public int armType;
    //head = 1, chest = 2, arms = 3, legs = 4, feet = 5;
    public int def;
    public int pref;

    public Armor(int dfns, int type, int preference)
    {
        def = dfns;
        armType = type;
        pref = preference;
    }

    public int retType()
    {
        return armType;
    }

    public int retDef()
    {
        return def;
    }


}
