package com.example.sierra.basicrpg;

import java.util.Arrays;

import static com.example.sierra.basicrpg.R.drawable.chest;
import static com.example.sierra.basicrpg.R.drawable.enemy1;
import static com.example.sierra.basicrpg.R.drawable.enemy2;
import static com.example.sierra.basicrpg.R.drawable.enemy3;
import static com.example.sierra.basicrpg.R.drawable.enemy4;
import static com.example.sierra.basicrpg.R.drawable.nullimage;
import static com.example.sierra.basicrpg.R.drawable.sign;

/**
 * Created by aamorris on 12/5/2016.
 */

public class Screen
{

    Location l[] = new Location[9];
    Location blank = new Location(0, nullimage,null,true, true, true, true);

    public Screen(Location a[])
    {
        for(int j = 0; j < l.length; j++ )
            l[j] = blank;

        for(int i = 0; i < a.length; i++ )
            l[i] = a[i];
    }

    public Screen()
    {

        for(int i = 0; i < l.length; i++)
        {
            double rando = (int) (8 * Math.random());
            int rand = (int) Math.round(rando);
            Location temp = new Location(0, nullimage, null, true, true, true, true);

            switch (rand)
            {
                case 1&2:
                    temp.id = 1;
                    rando =  (4 * Math.random());
                    rand = (int)Math.round(rando);
                    switch (rand)
                    {
                        case 1:
                            temp.sprite = enemy1;
                            break;
                        case 2:
                            temp.sprite = enemy2;
                            break;
                        case 3:
                            temp.sprite = enemy3;
                            break;
                        case 4:
                            temp.sprite = enemy4;
                            break;
                    }
                    break;
                case 3:
                    temp.id = 2;
                    temp.sprite = sign;
                    break;
                case 4:
                    temp.id = 3;
                    temp.sprite = chest;
                    break;
            }
            l[i] = temp;
        }
    }

}
