package articfox.better.seafood.ToolMaterials.Opal;

import articfox.better.seafood.BetterSeafood;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolMaterialOpal implements ToolMaterial {

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
        return 8.5F;
    }

    @Override
    public int getMiningLevel() {
        // TODO Auto-generated method stub
        return 7;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return Ingredient.ofItems(BetterSeafood.OPAL);
    }
}
