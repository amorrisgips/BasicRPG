package com.example.sierra.basicrpg;

import android.content.Intent;

import java.util.Arrays;

import static com.example.sierra.basicrpg.R.drawable.chest;
import static com.example.sierra.basicrpg.R.drawable.enemy1;
import static com.example.sierra.basicrpg.R.drawable.enemy2;
import static com.example.sierra.basicrpg.R.drawable.enemy3;
import static com.example.sierra.basicrpg.R.drawable.enemy4;
import static com.example.sierra.basicrpg.R.drawable.merchant;
import static com.example.sierra.basicrpg.R.drawable.nullimage;
import static com.example.sierra.basicrpg.R.drawable.sign;
import static com.example.sierra.basicrpg.R.drawable.smith;
import static com.example.sierra.basicrpg.R.drawable.trainer;

/**
 * Created by aamorris on 12/5/2016.
 */

public class Screen
{

    Location blank = new Location(0, nullimage,null,true, true, true, true);
    Location l[] = new Location[9];


    public Screen(int x, int y)
    {


        for (int i = 0; i < l.length; i++) {
            double rando = (int) (16 * Math.random());
            int rand = (int) Math.round(rando);
            Location temp = new Location(0, nullimage, null, true, true, true, true);

            switch (rand) {

                case 1:
                    temp.id = 1;
                    temp.sprite = enemy1;
                    break;
                case 2:
                    temp.id = 2;
                    temp.sprite = enemy2;
                    break;
                case 3:
                    temp.id = 3;
                    temp.sprite = enemy3;
                    break;
                case 4:
                    temp.id = 4;
                    temp.sprite = enemy4;
                    break;
                case 5:
                    temp.id = 5;
                    temp.sprite = sign;
                    break;
                case 6:
                    temp.id = 6;
                    temp.sprite = chest;
                    break;
            }
            l[i] = temp;
        }
        if(x == 0 && y == 0)
        {
            l[0].id = 20;
            l[0].sprite = trainer;
            l[2].id = 21;
            l[2].sprite = smith;
            l[3].id = 22;
            l[3].sprite = merchant;
        }
    }

}
