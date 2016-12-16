package com.example.sierra.basicrpg;

import android.content.Intent;

/**
 * Created by aamorris on 12/2/2016.
 */

public class Location
{
    int id;
    Intent loc;
    int sprite;
    boolean u;
    boolean l;
    boolean r;
    boolean d;

    public Location(int idi, int spritei, Intent loci, boolean up, boolean left, boolean right, boolean down)
    {
        id = idi;
        sprite = spritei;
        loc = loci;
        u = up;
        l = left;
        r = right;
        d = down;

    }
}
