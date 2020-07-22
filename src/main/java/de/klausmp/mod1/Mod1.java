package de.klausmp.mod1;

import de.klausmp.mod1.blocks.ModBlocks;
import de.klausmp.mod1.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Mod1.MODID, name = Mod1.NAME, version = Mod1.VERSION)
public class Mod1 {
    public static final String MODID = "mod1";
    public static final String NAME = "MOD1";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "de.klausmp.mod1.proxy.ClientProxy", serverSide = "de.klausmp.mod1.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Mod1 instance;

    private static Logger logger;

    public static CreativeTabs creativeTab = new CreativeTabs("MOD 1") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.blockBlock);
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
