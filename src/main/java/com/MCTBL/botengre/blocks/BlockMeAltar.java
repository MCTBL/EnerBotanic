package com.MCTBL.botengre.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.MCTBL.botengre.core.staticenum.AllBlocks;
import com.MCTBL.botengre.core.staticenum.BlockTextureManager;
import com.MCTBL.botengre.tile.TileMeAltar;

/*
 * Author : MCTBL
 * Time : 2025-06-23 22:22:31
 */

public class BlockMeAltar extends BaseBlock {

    @Override
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX,
        float subY, float subZ) {
        // TODO Auto-generated method stub
        return super.onBlockActivated(worldIn, x, y, z, player, side, subX, subY, subZ);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (ForgeDirection.getOrientation(side) == ForgeDirection.UP
            || ForgeDirection.getOrientation(side) == ForgeDirection.DOWN) {
            return BlockTextureManager.BLOCKMEALTAR.getTexture(0);
        } else {
            return BlockTextureManager.BLOCKMEALTAR.getTexture(1);
        }
    }

    @Override
    public String getUnlocalizedName() {
        return AllBlocks.BLOCKMEALTAR.getUnlocalizedName();
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileMeAltar();
    }

}
