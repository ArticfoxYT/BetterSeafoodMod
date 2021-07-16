package articfox.better.seafood.Blocks.FryerBlock;

import articfox.better.seafood.BetterSeafood;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import static articfox.better.seafood.BetterSeafood.FRYER_BLOCK_ENTITY;

public class FryerBlockEntity extends BlockEntity implements FryerImplementedInventory {
    DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public FryerBlockEntity() {
        super(this);
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return new int[0];
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return false;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }
}
