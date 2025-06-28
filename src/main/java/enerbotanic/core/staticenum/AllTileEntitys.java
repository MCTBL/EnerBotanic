package enerbotanic.core.staticenum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.tileentity.TileEntity;

import cpw.mods.fml.common.registry.GameRegistry;
import enerbotanic.core.EnerBotanic;
import enerbotanic.tile.TileMEPool;
import enerbotanic.tile.TileMeAltar;
import enerbotanic.tile.TileSparkBindingPoint;

/*
 * Author : MCTBL
 * Time : 2024-10-05 02:08:49
 */

public enum AllTileEntitys {

    TILEMEALTAR("TileMeAltar", TileMeAltar.class),
    TILESPARKBINDINGPOINT("TileSparkBindingPoint", TileSparkBindingPoint.class),
    TILEMEPOOL("TileMEPool", TileMEPool.class);

    public static final List<AllTileEntitys> VALUES = Collections
        .unmodifiableList(Arrays.asList(AllTileEntitys.values()));

    private final String ID;
    private final Class<? extends TileEntity> clazz;

    AllTileEntitys(final String ID, final Class<? extends TileEntity> clazz) {
        this.ID = ID;
        this.clazz = clazz;
    }

    public String getID() {
        return EnerBotanic.MODID + "." + this.ID;
    }

    public void registerTE() {
        GameRegistry.registerTileEntity(this.clazz, this.getID());
    }
}
