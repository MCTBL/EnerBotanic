package com.MCTBL.enerbotanic.container.implementations;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

import com.MCTBL.enerbotanic.container.EnerBotanicBaseContainer;
import com.MCTBL.enerbotanic.tile.TileMeAltar;

/*
 * Author MCTBL
 * Time 2025-06-24 10:43:59
 */
public class ContainerMeAltar extends EnerBotanicBaseContainer {

    public ContainerMeAltar(InventoryPlayer IP, TileMeAltar tileAltar) {
        super(IP, tileAltar, 90);
        this.bindPlayerInventory(IP, 0, 166 - 82);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

}
