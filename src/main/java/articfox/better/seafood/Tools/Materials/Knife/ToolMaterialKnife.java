package articfox.better.seafood.Tools.Materials.Knife;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolMaterialKnife implements ToolMaterial {

    @Override
    public float getAttackDamage() {
        // TODO Auto-generated method stub
        return 3F;
    }

    @Override
    public int getDurability() {
        // TODO Auto-generated method stub
        return 2000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        // TODO Auto-generated method stub
        return 1.0F;
    }

    @Override
    public int getMiningLevel() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return Ingredient.ofItems(Items.IRON_INGOT);
    }
}
