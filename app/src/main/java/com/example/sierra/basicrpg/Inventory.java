package com.example.sierra.basicrpg;

/**
 * Created by aamorris on 11/8/2016.
 */

public class Inventory
{
    public static Equipment PlayerInv[] = new Equipment[30];
    public static int openSlot = 0;

    public static void addEquipment(Equipment e)
    {
        PlayerInv[openSlot] = e;
        if(PlayerInv[openSlot + 1] == null)
        {
            openSlot++;
        }
    }

    public static void removeEquipment(int index)
    {
        PlayerInv[index] = null;
    }
}
