package enerbotanic.tile;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import appeng.api.networking.GridFlags;
import appeng.api.networking.crafting.ICraftingPatternDetails;
import appeng.api.networking.crafting.ICraftingProvider;
import appeng.api.networking.crafting.ICraftingProviderHelper;
import appeng.api.networking.security.MachineSource;
import appeng.api.util.AECableType;
import appeng.api.util.DimensionalCoord;
import appeng.tile.TileEvent;
import appeng.tile.events.TileEventType;
import appeng.tile.grid.AENetworkInvTile;
import appeng.tile.inventory.AppEngInternalInventory;
import appeng.tile.inventory.InvOperation;

/**
 * @author MCTBL
 * @date 2025-06-23 10:53:14
 */
public class TileMeAltar extends AENetworkInvTile implements ICraftingProvider {

    private final MachineSource source;
    private final AppEngInternalInventory runeAndCraftingSlots = new AppEngInternalInventory(null, 36, 64, true);

    private final int[] sides = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

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

    @Override
    public AECableType getCableConnectionType(ForgeDirection dir) {
        return AECableType.SMART;
    }

    @Override
    public DimensionalCoord getLocation() {
        return new DimensionalCoord(this);
    }

    @Override
    public IInventory getInternalInventory() {
        return this.runeAndCraftingSlots;
    }

    @Override
    public void onChangeInventory(IInventory inv, int slot, InvOperation mc, ItemStack removed, ItemStack added) {

        this.markForUpdate();
    }

    @Override
    public int[] getAccessibleSlotsBySide(ForgeDirection whichSide) {
        return this.sides;
    }
}
