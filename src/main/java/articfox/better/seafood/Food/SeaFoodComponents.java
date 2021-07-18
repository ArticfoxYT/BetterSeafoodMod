package articfox.better.seafood.Food;

import articfox.better.seafood.BetterSeafood;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class SeaFoodComponents {

        public static final FoodComponent CALAMARI = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.5F)
                        .snack().build();

        public static final FoodComponent RAW_SQUID = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.25F)
                        .snack().build();

        public static final FoodComponent RAW_GLOW_SQUID = (new FoodComponent.Builder()).hunger(3)
                        .saturationModifier(0.6F)
                        .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1000, 0), 0.75F).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1050, 0), 0.25F).snack().build();

        public static final FoodComponent GLOW_CALAMARI = (new FoodComponent.Builder()).hunger(4)
                        .saturationModifier(0.75F)
                        .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 3000, 0), 1.0F).snack().build();

        public static final FoodComponent FISH_AND_CHIPS = (new FoodComponent.Builder()).hunger(4)
                .saturationModifier(0.4F).build();

        public static final FoodComponent FRENCH_FRIES = (new FoodComponent.Builder()).hunger(2)
                .saturationModifier(0.2F).snack().build();

        public static final FoodComponent SUSHI = (new FoodComponent.Builder()).hunger(3)
                .saturationModifier(0.45F).snack().build();

        public static final FoodComponent SASHIMI = (new FoodComponent.Builder()).hunger(4)
                .saturationModifier(0.9F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 0.25F).build();

        public static final FoodComponent BUTTER = (new FoodComponent.Builder()).hunger(2)
                .saturationModifier(0.4F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 0), 1F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 0),0.5F).snack().build();

        public static final FoodComponent LOBSTER = (new FoodComponent.Builder()).hunger(4)
                .saturationModifier(0.8F).build();

        public static final FoodComponent SMOKED_SALMON = (new FoodComponent.Builder()).hunger(3)
                .saturationModifier(0.6F).build();
        public static final FoodComponent OBSIDIAN_SCALED_SALMON = (new FoodComponent.Builder()).hunger(5)
                .saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1F).build();

}