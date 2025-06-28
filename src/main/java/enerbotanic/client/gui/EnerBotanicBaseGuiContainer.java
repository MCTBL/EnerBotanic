package enerbotanic.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import enerbotanic.core.EnerBotanic;

/*
 * Author MCTBL
 * Time 2025-06-24 11:14:47
 */
public class EnerBotanicBaseGuiContainer extends GuiContainer {

    public EnerBotanicBaseGuiContainer(Container container) {
        super(container);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        // TODO Auto-generated method stub

    }

    public void bindTexture(final String file) {
        this.bindTexture(new ResourceLocation(EnerBotanic.MODID, "textures/" + file));
    }

    public void bindTexture(final ResourceLocation loc) {
        mc.getTextureManager()
            .bindTexture(loc);
    }

    public void drawItem(final int x, final int y, final ItemStack is) {
        this.zLevel = 100.0F;
        itemRender.zLevel = 100.0F;

        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glTranslatef(0.0f, 0.0f, 101.0f);
        RenderHelper.enableGUIStandardItemLighting();
        itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, is, x, y);
        GL11.glTranslatef(0.0f, 0.0f, -101.0f);
        GL11.glPopAttrib();

        itemRender.zLevel = 0.0F;
        this.zLevel = 0.0F;
    }
}
