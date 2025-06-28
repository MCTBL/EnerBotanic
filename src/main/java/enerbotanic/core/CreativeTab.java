package enerbotanic.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import enerbotanic.core.staticenum.AllBlocks;

/*
 * Author : MCTBL
 * Time : 2024-10-01 21:59:45
 */

public final class CreativeTab extends CreativeTabs {

    public static CreativeTab instance = null;

    public CreativeTab() {
        super("enerbotanic");
    }

    static void init() {
        instance = new CreativeTab();
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(AllBlocks.BLOCKSPARKBINDINGPOINT.getBlock());
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(AllBlocks.BLOCKSPARKBINDINGPOINT.getBlock());
    }

}
