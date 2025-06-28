package enerbotanic.tile;

import java.util.EnumSet;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

import appeng.api.networking.GridFlags;
import appeng.api.networking.events.MENetworkChannelsChanged;
import appeng.api.networking.events.MENetworkEventSubscribe;
import appeng.api.networking.events.MENetworkPowerStatusChange;
import appeng.tile.TileEvent;
import appeng.tile.events.TileEventType;
import appeng.tile.grid.AENetworkTile;
import vazkii.botania.api.mana.spark.ISparkAttachable;
import vazkii.botania.api.mana.spark.ISparkEntity;

/*
 * Author : MCTBL
 * Time : 2024-10-02 13:16:05
 */

public class TileSparkBindingPoint extends AENetworkTile implements ISparkAttachable {

    private int mana = 0;

    private static int MAX_MANA = 100_000_000;

    private static final String NBT_KEY_MANA = "MANA";

    public TileSparkBindingPoint() {
        this.getProxy()
            .setIdlePowerUsage(50d);
        this.getProxy()
            .setFlags(GridFlags.REQUIRE_CHANNEL);
        this.getProxy()
            .setValidSides(EnumSet.allOf(ForgeDirection.class));
    }

    @TileEvent(TileEventType.WORLD_NBT_WRITE)
    public void writeToNBT_SparkBindingPoint(final NBTTagCompound data) {
        data.setInteger(NBT_KEY_MANA, this.mana);
    }

    @TileEvent(TileEventType.WORLD_NBT_READ)
    public void readFromNBT_SparkBindingPoint(final NBTTagCompound data) {
        this.mana = data.getInteger(NBT_KEY_MANA);
    }

    @MENetworkEventSubscribe
    public void stateChange(final MENetworkChannelsChanged c) {
        markForUpdate();
    }

    @MENetworkEventSubscribe
    public void stateChange(final MENetworkPowerStatusChange c) {
        markForUpdate();
    }

    @Override
    public boolean isFull() {
        return MAX_MANA == this.mana;
    }

    @Override
    public void recieveMana(int mana) {
        this.mana = Math.max(0, Math.min(getCurrentMana() + mana, MAX_MANA));
        worldObj.func_147453_f(xCoord, yCoord, zCoord, worldObj.getBlock(xCoord, yCoord, zCoord));
        this.markDirty();
    }

    @Override
    public boolean canRecieveManaFromBursts() {
        return true;
    }

    @Override
    public int getCurrentMana() {
        return this.mana;
    }

    @Override
    public boolean canAttachSpark(ItemStack stack) {
        return true;
    }

    @Override
    public void attachSpark(ISparkEntity entity) {

    }

    @Override
    public int getAvailableSpaceForMana() {
        return Math.max(0, MAX_MANA - getCurrentMana());
    }

    @Override
    public ISparkEntity getAttachedSpark() {
        List<ISparkEntity> sparks = worldObj.getEntitiesWithinAABB(
            ISparkEntity.class,
            AxisAlignedBB.getBoundingBox(xCoord, yCoord + 1, zCoord, xCoord + 1, yCoord + 2, zCoord + 1));
        if (sparks.size() == 1) {
            Entity e = (Entity) sparks.get(0);
            return (ISparkEntity) e;
        }

        return null;
    }

    @Override
    public boolean areIncomingTranfersDone() {
        return false;
    }

}
