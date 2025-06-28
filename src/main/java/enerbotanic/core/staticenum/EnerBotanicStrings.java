package enerbotanic.core.staticenum;

import net.minecraft.util.StatCollector;

import enerbotanic.core.EnerBotanic;

/*
 * Author : MCTBL
 * Time : 2024-10-02 10:49:14
 */

public enum EnerBotanicStrings {

    BLOCKMEALTAR("block.mealtar", true),
    BLOCKSPARKBINDINGPOINT("block.sparkbindingpoint", true),
    BLOCKMEPOOL("block.mepool", true);

    private String unlocalized;
    private boolean needName;

    private EnerBotanicStrings(final String unloc, final boolean needName) {
        this.unlocalized = EnerBotanic.MODID + "." + unloc;
        this.needName = needName;
    }

    public String getLocalized() {
        if (this.needName) {
            return StatCollector.translateToLocal(this.unlocalized + ".name");
        }

        return StatCollector.translateToLocal(this.unlocalized);
    }

    public String getUnlocalized() {
        return this.unlocalized;
    }

}
