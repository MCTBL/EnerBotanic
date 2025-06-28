package enerbotanic.container.implementations;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import appeng.container.slot.SlotFake;
import enerbotanic.container.EnerBotanicBaseContainer;
import enerbotanic.core.EnerBotanic;
import enerbotanic.tile.TileMeAltar;
import vazkii.botania.common.item.ModItems;

/*
 * Author MCTBL
 * Time 2025-06-24 10:43:59
 */
public class ContainerMeAltar extends EnerBotanicBaseContainer {

    final static int slotWH = 18;
    public ItemStack selectRune = new ItemStack(ModItems.rune, 1, 0);
    private final SlotFake[] craftingInput = new SlotFake[20];
    private final int MIDDLE_X_BIAS = 80;
    private final int MIDDLE_Y_BIAS = 91;

    public ContainerMeAltar(InventoryPlayer IP, TileMeAltar tileAltar) {
        super(IP, tileAltar);
        this.initRuneSlot(tileAltar);
        this.bindPlayerInventory(IP, 0, 133);
    }

    private void initRuneSlot(TileMeAltar tileAltar) {
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 8; x++) {
                SlotFake tempSlot = new SlotFake(tileAltar, x + y * 8, 17 + x * slotWH, 17 + y * slotWH);
                tempSlot.putStack(new ItemStack(ModItems.rune, 1, x + y * 8));
                this.addSlotToContainer(tempSlot);
            }
        }

        for (int index = 16; index < 36; index++) {
            this.addSlotToContainer(craftingInput[index - 16] = new SlotFake(tileAltar, index, 9999, 9999));
        }
        this.updateSlotPos(2);
    }

    @Override
    public ItemStack slotClick(int slotId, int clickedButton, int mode, EntityPlayer player) {

        EnerBotanic.LOG.info(
            String.format(
                "%d is %s",
                slotId,
                this.getInventory()
                    .get(slotId)
                    .getDisplayName()));

        if (slotId < 16) {
            this.selectRune = this.getInventory()
                .get(slotId);
            this.updateSlotPos(slotId + 2);
        }

        return super.slotClick(slotId, clickedButton, mode, player);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    private void updateSlotPos(int splitNum) {
        List<int[]> cords = this.calcCoordinate(splitNum, 40);
        for (int index = 0; index < 20; index++) {
            SlotFake temp = craftingInput[index];
            if (index < splitNum) {
                int[] cord = cords.get(index);
                temp.xDisplayPosition = MIDDLE_X_BIAS + cord[0];
                temp.yDisplayPosition = MIDDLE_Y_BIAS - cord[1];
                temp.putStack(new ItemStack(ModItems.rune, 1, index % 16));
                // EnerBotanic.LOG.info(String.format("%d %d", MIDDLE_X_BIAS + cord[0], MIDDLE_Y_BIAS - cord[1]));
            } else {
                temp.xDisplayPosition = 9999;
                temp.yDisplayPosition = 9999;
            }
        }
    }

    public List<int[]> calcCoordinate(int splitNum, double radius) {
        List<int[]> list = new ArrayList<>();
        if (splitNum >= 1) {
            double radians = Math.toRadians(360.0d / splitNum);
            for (int i = 0; i < splitNum; i++) {
                int x = (int) (radius * Math.sin(radians * i));
                int y = (int) (radius * Math.cos(radians * i));
                list.add(new int[] { x, y });
            }
        }
        return list;
    }

}
