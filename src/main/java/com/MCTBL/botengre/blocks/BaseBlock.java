package com.MCTBL.botengre.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

/*
 * Author : MCTBL
 * Time : 2024-10-01 21:53:57
 */

public abstract class BaseBlock extends BlockContainer {

    protected BaseBlock(final Material mat) {
        super(mat);

        if (mat == Material.glass) {
            this.setStepSound(Block.soundTypeGlass);
        } else if (mat == Material.rock) {
            this.setStepSound(Block.soundTypeStone);
        } else if (mat == Material.wood) {
            this.setStepSound(Block.soundTypeWood);
        } else {
            this.setStepSound(Block.soundTypeMetal);
        }

    }

    protected BaseBlock() {
        this(Material.iron);
        this.setHarvestLevel("pickaxe", 1);
    }

}
