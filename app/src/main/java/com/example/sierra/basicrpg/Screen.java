package com.example.sierra.basicrpg;

import static com.example.sierra.basicrpg.R.drawable.nullimage;

/**
 * Created by aamorris on 12/5/2016.
 */

public class Screen
{

    Location l1;
    Location l2;
    Location l3;
    Location l4;
    Location l5;
    Location l6;
    Location l7;
    Location l8;
    Location l9;

    int pos = 5;

    Location blank = new Location(0, nullimage, true, true, true, true);

    public Screen(Location a1, Location a2, Location a3, Location a4, Location a5, Location a6, Location a7, Location a8, Location a9)
    {
        l1 = a1;
        l2 = a2;
        l3 = a3;
        l4 = a4;
        l5 = a5;
        l6 = a6;
        l7 = a7;
        l8 = a8;
        l9 = a9;
    }

    public Screen()
    {

    }

}
