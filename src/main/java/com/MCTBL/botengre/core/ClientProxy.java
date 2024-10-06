package com.MCTBL.botengre.core;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

import com.MCTBL.botengre.core.staticenum.BlockTextureManager;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.
    public ClientProxy() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerTextures(final TextureStitchEvent.Pre event) {
        // Register all block textures
        BlockTextureManager.ALLVALUES.forEach(texture -> texture.registerTexture(event.map));
    }

}
