package de.klausmp.mod1.blocks;

import de.klausmp.mod1.blocks.blockblock.BlockBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    @GameRegistry.ObjectHolder("mod1:blockblock")
    public static BlockBlock blockBlock;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockBlock.initModel();
    }
}
