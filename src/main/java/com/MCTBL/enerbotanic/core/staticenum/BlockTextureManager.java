package com.MCTBL.enerbotanic.core.staticenum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.MCTBL.enerbotanic.core.EnerBotanic;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/*
 * Author : MCTBL
 * Time : 2024-10-02 10:23:57
 */

@SideOnly(Side.CLIENT)
public enum BlockTextureManager {

    BLOCKMEALTAR(new String[] { "blockMeAltarUp", "blockMeAltarSide" }),
    BLOCKSPARKBINDINGPOINT(new String[] { "sparkbindingpoint" }),
    BLOCKMEPOOL(new String[] { "blockmepool1", "blockmepool2" });

    private String[] textureNames;

    private IIcon[] textures;

    public static final List<BlockTextureManager> ALLVALUES = Collections
        .unmodifiableList(Arrays.asList(BlockTextureManager.values()));

    BlockTextureManager(final String[] textureNames) {
        this.textureNames = textureNames;
        this.textures = new IIcon[textureNames.length];
    }

    public IIcon[] getAllTextures() {
        return this.textures;
    }

    public IIcon getTexture(final int index) {
        if (index < 0 || index >= this.textures.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.textures[index];
    }

    public void registerTexture(final TextureMap textureMap) {
        if (textureMap.getTextureType() == 0) {
            String header = EnerBotanic.MODID + ":";

            for (int i = 0; i < this.textureNames.length; i++) {
                this.textures[i] = textureMap.registerIcon(header + this.textureNames[i]);
            }
        }
    }

}
