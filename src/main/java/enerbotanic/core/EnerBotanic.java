package enerbotanic.core;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import enerbotanic.core.staticenum.GuiBridge;

@Mod(
    modid = EnerBotanic.MODID,
    version = EnerBotanic.VERSION,
    name = "EnerBotanic",
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = "required-after:appliedenergistics2;required-after:Botania")
public class EnerBotanic {

    public static final String MODID = "enerbotanic";
    public static final String VERSION = "GRADLETOKEN_VERSION";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @Nonnull
    @Instance(value = EnerBotanic.MODID)
    public static EnerBotanic INSTANCE;

    @SidedProxy(clientSide = "enerbotanic.core.ClientProxy", serverSide = "enerbotanic.core.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);

        CreativeTab.init();

        proxy.registerBlocks();
        proxy.registerTiles();
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, GuiBridge.GUI_HANDLER);
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
