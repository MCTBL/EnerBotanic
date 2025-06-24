package com.MCTBL.botengre.core.staticenum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.MCTBL.botengre.blocks.BlockMEPool;
import com.MCTBL.botengre.blocks.BlockMeAltar;
import com.MCTBL.botengre.blocks.BlockSparkBindingPoint;
import com.MCTBL.botengre.core.CreativeTab;

import cpw.mods.fml.common.registry.GameRegistry;

/*
 * Author : MCTBL
 * Time : 2024-10-02 09:37:23
 */

public enum AllBlocks {

    BLOCKMEALTAR(BotEngStrings.BLOCKMEALTAR, new BlockMeAltar()),
    BLOCKSPARKBINDINGPOINT(BotEngStrings.BLOCKSPARKBINDINGPOINT, new BlockSparkBindingPoint()),
    BLOCKMEPOOL(BotEngStrings.BLOCKMEPOOL, new BlockMEPool());

    public static final List<AllBlocks> VALUES = Collections.unmodifiableList(Arrays.asList(AllBlocks.values()));

    private final BotEngStrings unlocalizedName;
    private final Block block;
    private final Class<? extends ItemBlock> itemclass;

    AllBlocks(final BotEngStrings unlocalizedName, final Block block) {
        this(unlocalizedName, block, ItemBlock.class);
    }

    AllBlocks(final BotEngStrings unlocalizedName, final Block block, final Class<? extends ItemBlock> itemclass) {
        this.block = block;
        this.unlocalizedName = unlocalizedName;

        this.block.setBlockName(this.unlocalizedName.getUnlocalized());

        this.itemclass = itemclass;
    }

    public Block getBlock() {
        return this.block;
    }

    public void registerBlock() {
        this.block.setCreativeTab(CreativeTab.instance);
        GameRegistry.registerBlock(this.block, this.itemclass, this.block.getUnlocalizedName());
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName.getUnlocalized();
    }

}
