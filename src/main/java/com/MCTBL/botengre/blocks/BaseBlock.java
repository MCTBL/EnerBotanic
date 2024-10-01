package com.MCTBL.botengre.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.MCTBL.botengre.core.CreativeTab;

/*
 * Author : MCTBL
 * Time : 2024-10-01 21:53:57
 */

public class BaseBlock extends Block {

    private BaseBlock() {
        super(Material.iron);
    }

    public BaseBlock getNewBlock() {
        return new BaseBlock();
    }

    public BaseBlock setHarvestLevel(final int level) {
        this.setHarvestLevel("pickaxe", level);
        return this;
    }

    public BaseBlock addToCreativeTab() {
        this.setCreativeTab(CreativeTab.instance);
        return this;
    }

    public BaseBlock setBlockNameAndTextureName(final String blockName, final String textureName) {
        this.setBlockName(blockName);
        this.setBlockTextureName(textureName);
        return this;
    }

}
