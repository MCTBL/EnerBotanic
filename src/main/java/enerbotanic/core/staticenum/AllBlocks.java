package enerbotanic.core.staticenum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import enerbotanic.blocks.BlockMEPool;
import enerbotanic.blocks.BlockMeAltar;
import enerbotanic.blocks.BlockSparkBindingPoint;
import enerbotanic.core.CreativeTab;

/*
 * Author : MCTBL
 * Time : 2024-10-02 09:37:23
 */

public enum AllBlocks {

    BLOCKMEALTAR(EnerBotanicStrings.BLOCKMEALTAR, new BlockMeAltar()),
    BLOCKSPARKBINDINGPOINT(EnerBotanicStrings.BLOCKSPARKBINDINGPOINT, new BlockSparkBindingPoint()),
    BLOCKMEPOOL(EnerBotanicStrings.BLOCKMEPOOL, new BlockMEPool());

    public static final List<AllBlocks> VALUES = Collections.unmodifiableList(Arrays.asList(AllBlocks.values()));

    private final EnerBotanicStrings unlocalizedName;
    private final Block block;
    private final Class<? extends ItemBlock> itemclass;

    AllBlocks(final EnerBotanicStrings unlocalizedName, final Block block) {
        this(unlocalizedName, block, ItemBlock.class);
    }

    AllBlocks(final EnerBotanicStrings unlocalizedName, final Block block, final Class<? extends ItemBlock> itemclass) {
        this.block = block;
        this.unlocalizedName = unlocalizedName;

        this.block.setBlockName(this.unlocalizedName.getUnlocalized());

        this.itemclass = itemclass;
    }

    public Block getBlock() {
        return this.block;
    }

    public void registerBlock() {
        this.block.setCreativeTab(CreativeTab.instance);
        GameRegistry.registerBlock(this.block, this.itemclass, this.block.getUnlocalizedName());
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName.getUnlocalized();
    }

}
