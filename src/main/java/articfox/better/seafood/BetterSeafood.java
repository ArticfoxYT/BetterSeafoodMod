package articfox.better.seafood;

import articfox.better.seafood.Blocks.FryerBlock.FryerBlock;
import articfox.better.seafood.Blocks.FryerBlock.FryerBlockEntity;
import articfox.better.seafood.Blocks.OpalOreBlock;
import articfox.better.seafood.Enchantments.CrystalBaneEnchantment;
import articfox.better.seafood.Enchantments.CrystalSightEnchantment;
import articfox.better.seafood.Food.SeaFoodComponents;
import articfox.better.seafood.Tools.Materials.Knife.KnifeBase;
import articfox.better.seafood.Tools.Materials.Knife.ToolMaterialKnife;
import articfox.better.seafood.Tools.Materials.Opal.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;

@SuppressWarnings("ALL")
public class BetterSeafood implements ModInitializer {

	// Food Items
	public static final Item RAW_SQUID = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.RAW_SQUID));

	public static final Item CALAMARI = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.CALAMARI));


	public static final Item RAW_GLOW_SQUID = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.RAW_GLOW_SQUID));

	public static final Item GLOW_CALAMARI = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.GLOW_CALAMARI));

	public static final Item SASHIMI = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.SASHIMI));

	public static final Item LOBSTER = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.LOBSTER));

	public static final Item FISH_AND_CHIPS = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.FISH_AND_CHIPS));

	public static final Item SMOKED_SALMON = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.SMOKED_SALMON));

	public static final Item BUTTER = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.BUTTER));

	public static final Item SUSHI = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.SUSHI));

	public static final Item FRENCH_FRIES = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.FRENCH_FRIES));

	// Items
	public static final Item OPAL = new Item(new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_ITEMS).group(ItemGroup.MISC));

	public static final Item KNIFE = new Item(new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_ITEMS).group(ItemGroup.TOOLS));

	// Block Items
	public static final Block OPAL_ORE = new OpalOreBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES,3).requiresTool().strength(6.0F, 30.0F).materialColor(MapColor.GRAY));

	public static BlockEntityType<FryerBlockEntity> FRYER_BLOCK_ENTITY;
	public static final Block FRYER_BLOCK = new FryerBlock(FabricBlockSettings.of(Material.METAL));

	// World Generation
	private static final ConfiguredFeature<?, ?> OPAL_ORE_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, OPAL_ORE.getDefaultState(), 3))
			.range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(-64), YOffset.fixed(45))))
			.spreadHorizontally().repeat(12);

	//Groups
	public static final ItemGroup BETTER_SEAFOOD_ITEMS = FabricItemGroupBuilder.build(new Identifier("betterseafood", "items"), () -> new ItemStack(BetterSeafood.OPAL_ORE));


	public static final ItemGroup BETTER_SEAFOOD_FOOD = FabricItemGroupBuilder.build(new Identifier("betterseafood", "food"), () -> new ItemStack(Items.TROPICAL_FISH));

	//Loot Tables
	private static final Identifier COAL_ORE_LOOT_TABLE_ID = Blocks.COAL_ORE.getLootTableId();

		@Override
		public void onInitialize() {

			// Block Items
			Registry.register(Registry.BLOCK, new Identifier("betterseafood", "opal_ore"), OPAL_ORE);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "opal_ore"),
					new BlockItem(OPAL_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
			RegistryKey<ConfiguredFeature<?, ?>> opalOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
					new Identifier("betterseafood", "opal_ore"));

			FRYER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "betterseafood:demo", BlockEntityType.Builder.create(FryerBlockEntity::new, FRYER_BLOCK).build(null));

			// Items
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "opal"), OPAL);

			// World Generation
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, opalOreOverworld.getValue(), OPAL_ORE_OVERWORLD);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
					opalOreOverworld);

			// Food Items
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "raw_squid"), RAW_SQUID);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "calamari"), CALAMARI);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "raw_glow_squid"), RAW_GLOW_SQUID);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "glow_calamari"), GLOW_CALAMARI);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "sashimi"), SASHIMI);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "butter"), BUTTER);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "smoked_salmon"), SMOKED_SALMON);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "lobster"), LOBSTER);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "french_fries"), FRENCH_FRIES);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "fish_and_chips"), FISH_AND_CHIPS);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "sushi"), SUSHI);


			// Tool Items
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "opal_pickaxe"),
					new PickaxeBase(new ToolMaterialOpal()));
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "opal_axe"),
					new AxeBase(new ToolMaterialOpal()));
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "opal_shovel"),
					new ShovelBase(new ToolMaterialOpal()));
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "opal_hoe"),
					new HoeBase(new ToolMaterialOpal()));
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "opal_sword"),
					new SwordBase(new ToolMaterialOpal()));
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "knife"),
					new KnifeBase(new ToolMaterialKnife()));

			//Enchantments
			Registry.register(Registry.ENCHANTMENT, new Identifier("betterseafood", "crystal_bane"), new CrystalBaneEnchantment());

			Registry.register(Registry.ENCHANTMENT, new Identifier("betterseafood", "crystal_sight"), new CrystalSightEnchantment());
		}
	}

