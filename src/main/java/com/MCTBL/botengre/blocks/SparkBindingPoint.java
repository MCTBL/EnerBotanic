package com.MCTBL.botengre.blocks;

import net.minecraft.util.IIcon;

import com.MCTBL.botengre.client.BlockTextureManager;

/*
 * Author : MCTBL
 * Time : 2024-10-02 09:26:31
 */

public class SparkBindingPoint extends BaseBlock {

    public SparkBindingPoint() {
        super();
        this.addToCreativeTab()
            .setHarvestLevel(1);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return BlockTextureManager.SPARKBINDINGPOINT.getTexture(0);
    }

    @Override
    public String getUnlocalizedName() {
        return AllBlocks.SPARKBINDINGPOINT.getUnlocalizedName();
    }
}
