package com.MCTBL.botengre.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/*
 * Author : MCTBL
 * Time : 2024-10-01 21:59:45
 */

public final class CreativeTab extends CreativeTabs {

    public static CreativeTab instance = null;

    public CreativeTab() {
        super("botanicenergisticsre");
    }

    static void init() {
        instance = new CreativeTab();
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Blocks.crafting_table);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Blocks.crafting_table);
    }

}
