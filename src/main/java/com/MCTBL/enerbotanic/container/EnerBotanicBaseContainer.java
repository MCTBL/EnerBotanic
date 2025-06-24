package com.MCTBL.enerbotanic.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

import appeng.container.slot.SlotPlayerHotBar;
import appeng.container.slot.SlotPlayerInv;
import appeng.tile.inventory.AppEngInternalInventory;

/*
 * Author MCTBL
 * Time 2025-06-24 11:16:30
 */
public class EnerBotanicBaseContainer extends Container {

    private InventoryPlayer invPlayer;
    private AppEngInternalInventory inv;
    private TileEntity myTile;

    public EnerBotanicBaseContainer(final InventoryPlayer invPlayer, final TileEntity myTile) {
        this(invPlayer, myTile, 1);
    }

    public EnerBotanicBaseContainer(final InventoryPlayer invPlayer, final TileEntity myTile, final int invSize) {
        this.invPlayer = invPlayer;
        this.myTile = myTile;
        this.inv = new AppEngInternalInventory(null, invSize);
    }

    protected void bindPlayerInventory(final InventoryPlayer inventoryPlayer, final int offsetX, final int offsetY) {
        // bind player inventory
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {

                this.addSlotToContainer(
                    new SlotPlayerInv(inventoryPlayer, j + i * 9 + 9, 8 + j * 18 + offsetX, offsetY + i * 18));

            }
        }
        // bind player hotbar
        for (int i = 0; i < 9; i++) {

            this.addSlotToContainer(new SlotPlayerHotBar(inventoryPlayer, i, 8 + i * 18 + offsetX, 58 + offsetY));

        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        // TODO Auto-generated method stub
        return false;
    }

}
