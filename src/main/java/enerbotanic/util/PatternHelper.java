package enerbotanic.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class PatternHelper {

    private static final String NBTKEY_AE_IN = "in", NBTKEY_AE_OUT = "out", NBTKEY_AE_ISCRAFTING = "crafting",
        NBTKEY_AE_CAN_SUB = "substitute", NBTKEY_MANA_REQUIRE = "mana";

    public static void writeBotaniaPattern(final int mana, final ItemStack input, final ItemStack output,
        final ItemStack pattern) {
        writePattern(input, output, pattern);
        NBTTagCompound tagCompound = pattern.getTagCompound();
        tagCompound.setInteger(NBTKEY_MANA_REQUIRE, mana);
    }

    public static void writePattern(final ItemStack input, final ItemStack output, final ItemStack pattern) {
        // Create a new tag
        NBTTagCompound data = new NBTTagCompound();

        // Write the input
        NBTTagList inTags = new NBTTagList();
        inTags.appendTag(input.writeToNBT(new NBTTagCompound()));

        // Write the outputs
        NBTTagList outTags = new NBTTagList();
        outTags.appendTag(output.writeToNBT(new NBTTagCompound()));

        // Write the basics
        data.setBoolean(NBTKEY_AE_CAN_SUB, false);
        data.setBoolean(NBTKEY_AE_ISCRAFTING, false);

        // Write the lists
        data.setTag(NBTKEY_AE_IN, inTags);
        data.setTag(NBTKEY_AE_OUT, outTags);

        // Save into the item
        pattern.setTagCompound(data);
    }

    public static void clearPattern(final ItemStack pattern) {
        pattern.setTagCompound(null);
    }
}
