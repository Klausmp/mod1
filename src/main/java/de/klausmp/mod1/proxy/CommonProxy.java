package de.klausmp.mod1.proxy;

import de.klausmp.mod1.Mod1;
import de.klausmp.mod1.blocks.blockblock.BlockBlock;
import de.klausmp.mod1.blocks.ModBlocks;
import de.klausmp.mod1.blocks.blockblock.TileBlockBlock;
import net.minecraft.block.Block;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Mod1.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockBlock());
        GameRegistry.registerTileEntity(TileBlockBlock.class, Mod1.MODID + "_blockblock");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockBlock).setRegistryName(new ResourceLocation(Mod1.MODID, "blockblock")));
    }
}
