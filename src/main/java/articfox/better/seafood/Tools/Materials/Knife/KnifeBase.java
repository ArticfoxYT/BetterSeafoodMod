package articfox.better.seafood.Tools.Materials.Knife;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

import net.minecraft.item.ToolMaterial;

public class KnifeBase extends SwordItem {

    public KnifeBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, -2, -3F, new Item.Settings().group(ItemGroup.COMBAT));
        // TODO Auto-generated constructor stub
    }
}
