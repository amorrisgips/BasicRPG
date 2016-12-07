package com.example.sierra.basicrpg;

import java.util.Arrays;

import static com.example.sierra.basicrpg.R.drawable.nullimage;

/**
 * Created by aamorris on 12/5/2016.
 */

public class Screen
{

    Location l[] = new Location[9];
    Location blank = new Location(0, nullimage,0,true, true, true, true);

    public Screen(Location a[])
    {
        for(int j = 0; j < l.length; j++ )
            l[j] = blank;

        for(int i = 0; i < a.length; i++ )
            l[i] = a[i];
    }

    public Screen()
    {

    }

}
