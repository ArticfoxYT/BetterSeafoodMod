package articfox.better.seafood.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class opal extends Item {

    public opal (Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack ) {
        return true;
        }
    }
