package de.klausmp.mod1.blocks.blockblock;

import de.klausmp.mod1.Mod1;
import net.minecraft.client.gui.inventory.GuiContainer;

import net.minecraft.util.ResourceLocation;

public class GuiBlockBlock extends GuiContainer {
    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(Mod1.MODID, "textures/gui/guiblockblock.png");

    public GuiBlockBlock(TileBlockBlock tileEntity, ContainerBlockBlock container) {
        super(container);
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}
