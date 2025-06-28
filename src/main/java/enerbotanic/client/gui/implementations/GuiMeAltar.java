package enerbotanic.client.gui.implementations;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import enerbotanic.client.gui.EnerBotanicBaseGuiContainer;
import enerbotanic.container.implementations.ContainerMeAltar;
import enerbotanic.tile.TileMeAltar;

/*
 * Author MCTBL
 * Time 2025-06-24 10:44:02
 */
public class GuiMeAltar extends EnerBotanicBaseGuiContainer {

    public GuiMeAltar(InventoryPlayer IP, TileMeAltar altar) {
        super(new ContainerMeAltar(IP, altar));
        this.ySize = 231;

    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        ItemStack temp = ((ContainerMeAltar) this.inventorySlots).selectRune;
        this.drawItem(80, 91, temp);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float f, final int mouseX, final int mouseY) {
        this.bindTexture("gui/meAltar.png");
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

}
