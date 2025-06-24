package com.MCTBL.enerbotanic.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.MCTBL.enerbotanic.core.EnerBotanic;
import com.MCTBL.enerbotanic.core.staticenum.AllBlocks;
import com.MCTBL.enerbotanic.core.staticenum.BlockTextureManager;
import com.MCTBL.enerbotanic.core.staticenum.GuiBridge;
import com.MCTBL.enerbotanic.tile.TileMeAltar;

/*
 * Author : MCTBL
 * Time : 2025-06-23 22:22:31
 */

public class BlockMeAltar extends BaseBlock {

    @Override
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player,
        final int side, final float subX, final float subY, final float subZ) {
        final TileEntity te = world.getTileEntity(x, y, z);
        if (te != null && te instanceof TileMeAltar) {
            player.openGui(EnerBotanic.INSTANCE, GuiBridge.GUIMEALTAR.ordinal(), player.getEntityWorld(), x, y, z);
            return true;
        }
        return false;
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
