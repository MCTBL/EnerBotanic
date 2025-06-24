package com.MCTBL.enerbotanic.client.gui.implementations;

import net.minecraft.entity.player.InventoryPlayer;

import com.MCTBL.enerbotanic.client.gui.EnerBotanicBaseGuiContainer;
import com.MCTBL.enerbotanic.container.implementations.ContainerMeAltar;
import com.MCTBL.enerbotanic.tile.TileMeAltar;

/*
 * Author MCTBL
 * Time 2025-06-24 10:44:02
 */
public class GuiMeAltar extends EnerBotanicBaseGuiContainer {

    public GuiMeAltar(InventoryPlayer IP, TileMeAltar altar) {
        super(new ContainerMeAltar(IP, altar));
    }

}
