package enerbotanic.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import enerbotanic.core.staticenum.AllBlocks;
import enerbotanic.core.staticenum.BlockTextureManager;
import enerbotanic.tile.TileSparkBindingPoint;

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
