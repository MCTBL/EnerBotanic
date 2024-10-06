package com.MCTBL.botengre.core.staticenum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.tileentity.TileEntity;

import com.MCTBL.botengre.core.BotEngRe;
import com.MCTBL.botengre.tile.TileMEPool;
import com.MCTBL.botengre.tile.TileSparkBindingPoint;

import cpw.mods.fml.common.registry.GameRegistry;

/*
 * Author : MCTBL
 * Time : 2024-10-05 02:08:49
 */

public enum AllTileEntitys {

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
        return BotEngRe.MODID + "." + this.ID;
    }

    public void registerTE() {
        GameRegistry.registerTileEntity(this.clazz, this.getID());
    }
}
