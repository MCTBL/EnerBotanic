package com.MCTBL.enerbotanic.core.staticenum;

import java.lang.reflect.Constructor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import com.MCTBL.enerbotanic.container.implementations.ContainerMeAltar;
import com.MCTBL.enerbotanic.tile.TileMeAltar;

import appeng.util.Platform;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;

/*
 * Author MCTBL
 * Time 2025-06-24 10:41:31
 */
public enum GuiBridge implements IGuiHandler {

    GUI_HANDLER(),

    GUIMEALTAR(ContainerMeAltar.class, TileMeAltar.class);

    private final Class<?> tileClass;
    private final Class<?> containerClass;
    private Class<?> guiClass;

    GuiBridge() {
        this.tileClass = null;
        this.guiClass = null;
        this.containerClass = null;
    }

    GuiBridge(Class<?> containerClz, Class<?> tileClz) {
        this.containerClass = containerClz;
        this.tileClass = tileClz;
        this.getGui();
    }

    private void getGui() {
        if (Platform.isClient()) {
            final String start = this.containerClass.getName();
            final String guiClass = start.replaceFirst("container.", "client.gui.")
                .replace(".Container", ".Gui");

            if (start.equals(guiClass)) {
                throw new IllegalStateException("Unable to find gui class");
            }
            this.guiClass = ReflectionHelper.getClass(
                this.getClass()
                    .getClassLoader(),
                guiClass);
            if (this.guiClass == null) {
                throw new IllegalStateException("Cannot Load class: " + guiClass);
            }
        }
    }

    @Override
    public Object getServerGuiElement(final int ordinal, final EntityPlayer player, final World world, final int x,
        final int y, final int z) {
        final GuiBridge ID = values()[ordinal];

        return ID.ConstructContainer(player.inventory, world.getTileEntity(x, y, z));
    }

    private Constructor findConstructor(final Constructor[] c, final InventoryPlayer inventory, final Object tE) {
        for (final Constructor con : c) {
            final Class[] types = con.getParameterTypes();
            if (types.length == 2) {
                if (types[0].isAssignableFrom(inventory.getClass()) && types[1].isAssignableFrom(tE.getClass())) {
                    return con;
                }
            }
        }
        return null;
    }

    private String typeName(final Object inventory) {
        if (inventory == null) {
            return "NULL";
        }

        return inventory.getClass()
            .getName();
    }

    public Object ConstructContainer(final InventoryPlayer inventory, final Object tE) {
        try {
            final Constructor[] c = this.containerClass.getConstructors();
            if (c.length == 0) {
                throw new IllegalStateException("Invalid Gui Class");
            }

            final Constructor target = this.findConstructor(c, inventory, tE);

            if (target == null) {
                throw new IllegalStateException(
                    "Cannot find " + this.containerClass
                        .getName() + "( " + this.typeName(inventory) + ", " + this.typeName(tE) + " )");
            }

            final Object o = target.newInstance(inventory, tE);

            return o;
        } catch (final Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    @Override
    public Object getClientGuiElement(final int ordinal, final EntityPlayer player, final World world, final int x,
        final int y, final int z) {
        final GuiBridge ID = values()[ordinal];

        return ID.ConstructGui(player.inventory, world.getTileEntity(x, y, z));
    }

    public Object ConstructGui(final InventoryPlayer inventory, final Object tE) {
        try {
            final Constructor[] c = this.guiClass.getConstructors();
            if (c.length == 0) {
                throw new Exception("Invalid Gui Class");
            }

            final Constructor target = this.findConstructor(c, inventory, tE);

            if (target == null) {
                throw new IllegalStateException(
                    "Cannot find " + this.containerClass
                        .getName() + "( " + this.typeName(inventory) + ", " + this.typeName(tE) + " )");
            }

            return target.newInstance(inventory, tE);
        } catch (final Throwable t) {
            throw new IllegalStateException(t);
        }
    }

}
