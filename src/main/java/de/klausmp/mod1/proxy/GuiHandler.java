package de.klausmp.mod1.proxy;

import de.klausmp.mod1.blocks.blockblock.ContainerBlockBlock;
import de.klausmp.mod1.blocks.blockblock.GuiBlockBlock;
import de.klausmp.mod1.blocks.blockblock.TileBlockBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileBlockBlock) {
            return new ContainerBlockBlock(player.inventory, (TileBlockBlock) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileBlockBlock) {
            TileBlockBlock containerTileEntity = (TileBlockBlock) te;
            return new GuiBlockBlock(containerTileEntity, new ContainerBlockBlock(player.inventory, containerTileEntity));
        }
        return null;
    }
}
