package articfox.better.seafood.ToolMaterials.FieryOpal;

import articfox.better.seafood.BetterSeafood;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolMaterialFieryOpal implements ToolMaterial {

    @Override
    public float getAttackDamage() {
        // TODO Auto-generated method stub
        return 5F;
    }

    @Override
    public int getDurability() {
        // TODO Auto-generated method stub
        return 2500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        // TODO Auto-generated method stub
        return 9.5F;
    }

    @Override
    public int getMiningLevel() {
        // TODO Auto-generated method stub
        return 9;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return Ingredient.ofItems(BetterSeafood.FIERY_OPAL);
    }
}
