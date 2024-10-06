package com.MCTBL.botengre.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.MCTBL.botengre.core.staticenum.AllBlocks;
import com.MCTBL.botengre.core.staticenum.BlockTextureManager;
import com.MCTBL.botengre.tile.TileSparkBindingPoint;

/*
 * Author : MCTBL
 * Time : 2024-10-02 09:26:31
 */

public class BlockSparkBindingPoint extends BaseBlock {

    @Override
    public IIcon getIcon(int side, int meta) {
        return BlockTextureManager.BLOCKSPARKBINDINGPOINT.getTexture(0);
    }

    @Override
    public String getUnlocalizedName() {
        return AllBlocks.BLOCKSPARKBINDINGPOINT.getUnlocalizedName();
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileSparkBindingPoint();
    }
}
