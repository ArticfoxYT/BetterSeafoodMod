package articfox.better.seafood.Food;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class SeaFoodComponents {

        public static final FoodComponent CALAMARI = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.5F)
                        .snack().build();

        public static final FoodComponent RAW_SQUID = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.25F)
                        .snack().build();

        public static final FoodComponent RAW_GLOW_SQUID = (new FoodComponent.Builder()).hunger(3)
                        .saturationModifier(0.5F)
                        .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300, 0), 0.75F).snack().build();

        public static final FoodComponent GLOW_CALAMARI = (new FoodComponent.Builder()).hunger(5)
                        .saturationModifier(0.75F)
                        .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1800, 0), 1.0F).snack().build();

        public static final FoodComponent FISH_AND_CHIPS = (new FoodComponent.Builder()).hunger(5)
                .saturationModifier(0.75F).build();

        public static final FoodComponent FRENCH_FRIES = (new FoodComponent.Builder()).hunger(5)
                .saturationModifier(0.75F).build();

        public static final FoodComponent SUSHI = (new FoodComponent.Builder()).hunger(5)
                .saturationModifier(0.75F).build();

        public static final FoodComponent SASHIMI = (new FoodComponent.Builder()).hunger(5)
                .saturationModifier(0.75F).build();

        public static final FoodComponent BUTTER = (new FoodComponent.Builder()).hunger(5)
                .saturationModifier(0.75F).build();

        public static final FoodComponent LOBSTER = (new FoodComponent.Builder()).hunger(5)
                .saturationModifier(0.75F).build();

        public static final FoodComponent SMOKED_SALMON = (new FoodComponent.Builder()).hunger(5)
                .saturationModifier(0.75F).build();

}