package com.MCTBL.botengre.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.MCTBL.botengre.core.staticenum.BlockTextureManager;
import com.MCTBL.botengre.core.staticenum.BotEngStrings;
import com.MCTBL.botengre.tile.TileMEPool;

/*
 * Author : MCTBL
 * Time : 2024-10-06 10:37:54
 */

public class BlockMEPool extends BaseBlock {

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side <= 1) {
            return BlockTextureManager.BLOCKMEPOOL.getTexture(1);
        } else {
            return BlockTextureManager.BLOCKMEPOOL.getTexture(0);
        }
    }

    @Override
    public String getUnlocalizedName() {
        return BotEngStrings.BLOCKMEPOOL.getUnlocalized();
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileMEPool();
    }

}
