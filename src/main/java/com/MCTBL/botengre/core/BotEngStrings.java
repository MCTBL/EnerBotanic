package com.MCTBL.botengre.core;

import net.minecraft.util.StatCollector;

/*
 * Author : MCTBL
 * Time : 2024-10-02 10:49:14
 */

public enum BotEngStrings {

    SPARKBINDINGPOINT("block.sparkbindingpoint", true);

    private String unlocalized;
    private boolean needName;

    private BotEngStrings(final String unloc, final boolean needName) {
        this.unlocalized = BotEngRe.MODID + "." + unloc;
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
