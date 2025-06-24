/**
 * @author MCTBL
 * @date 2025-06-23 10:53:14
 */
package com.MCTBL.botengre.tile;

import net.minecraft.inventory.InventoryCrafting;

import appeng.api.networking.GridFlags;
import appeng.api.networking.crafting.ICraftingPatternDetails;
import appeng.api.networking.crafting.ICraftingProvider;
import appeng.api.networking.crafting.ICraftingProviderHelper;
import appeng.api.networking.security.MachineSource;
import appeng.tile.TileEvent;
import appeng.tile.events.TileEventType;
import appeng.tile.grid.AENetworkTile;

/**
 * @author MCTBL
 * @date 2025-06-23 10:53:14
 */
public class TileMeAltar extends AENetworkTile implements ICraftingProvider {

    private final MachineSource source;

    public TileMeAltar() {
        this.getProxy()
            .setFlags(GridFlags.REQUIRE_CHANNEL);
        this.getProxy()
            .setIdlePowerUsage(80d);
        this.source = new MachineSource(this);
    }

    @Override
    public boolean pushPattern(ICraftingPatternDetails patternDetails, InventoryCrafting table) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isBusy() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void provideCrafting(ICraftingProviderHelper craftingTracker) {
        // TODO Auto-generated method stub

    }

    @TileEvent(TileEventType.TICK)
    public void onTick() {

    }

}
