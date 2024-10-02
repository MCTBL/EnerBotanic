package com.MCTBL.botengre.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;

import com.MCTBL.botengre.core.BotEngRe;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/*
 * Author : MCTBL
 * Time : 2024-10-02 10:23:57
 */

@SideOnly(Side.CLIENT)
public enum BlockTextureManager {

    SPARKBINDINGPOINT(new String[] { "sparkbindingpoint" });

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
            String header = BotEngRe.MODID + ":";

            for (int i = 0; i < this.textureNames.length; i++) {
                this.textures[i] = textureMap.registerIcon(header + this.textureNames[i]);
            }
        }
    }

}
