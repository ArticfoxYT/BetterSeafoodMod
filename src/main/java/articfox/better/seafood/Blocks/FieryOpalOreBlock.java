package articfox.better.seafood.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

@SuppressWarnings("ALL")
public class FieryOpalOreBlock extends Block {

    public FieryOpalOreBlock(Settings settings) {
        super(settings);
        // TOTO Auto-generated constructor stub
    }

    protected int getExperienceWhenMined(Random random) {
        return MathHelper.nextInt(random, 0, 1);
    }

    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            int i = this.getExperienceWhenMined(world.random);
            if (i > 0) {
                this.dropExperience(world, pos, i);
            }
        }
    }
}
