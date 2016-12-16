package com.example.sierra.basicrpg;

import java.io.Serializable;

/**
 * Created by aamorris on 11/8/2016.
 */

public class Inventory implements Serializable
{
    public static Equipment Inv[] = new Equipment[10];
    public static int openSlot = 0;

    public Inventory()
    {

    }

    public static void addEquipment(Equipment e)
    {
        Inv[openSlot] = e;
        if(Inv[openSlot + 1] == null)
        {
            openSlot++;
        }
    }

    public static void randEquip()
    {
        addEquipment(new Armor(2,2,0));
        addEquipment(new Armor(2,1,0));
        addEquipment(new Weapon(5,0));
    }

    public static void removeEquipment(int index)
    {
        Inv[index] = null;
    }
}
