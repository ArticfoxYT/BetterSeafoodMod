package articfox.better.seafood;

//import articfox.better.seafood.Blocks.FryerBlock.FryerBlock;
//import articfox.better.seafood.Blocks.FryerBlock.FryerBlockEntity;
import articfox.better.seafood.Blocks.OpalOreBlock;
import articfox.better.seafood.Enchantments.CrystalBaneEnchantment;
import articfox.better.seafood.Enchantments.CrystalSightEnchantment;
import articfox.better.seafood.Food.SeaFoodComponents;
import articfox.better.seafood.Tools.Materials.FieryOpal.ToolMaterialFieryOpal;
import articfox.better.seafood.Tools.Materials.Knife.KnifeBase;
import articfox.better.seafood.Tools.Materials.Knife.ToolMaterialKnife;
import articfox.better.seafood.Tools.Materials.Opal.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
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

	public static final Item OBSIDIAN_SCALED_SALMON = new Item(
			new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_FOOD).group(ItemGroup.FOOD).food(SeaFoodComponents.OBSIDIAN_SCALED_SALMON));

	// Items
	public static final Item OPAL = new Item(new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_ITEMS).group(ItemGroup.MISC));

	public static final Item KNIFE = new Item(new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_ITEMS).group(ItemGroup.TOOLS));

	public static final Item FIERY_OPAL = new Item(new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_ITEMS).group(ItemGroup.MISC));

	public static final Item FISH_SCALES = new Item(new Item.Settings().group(BetterSeafood.BETTER_SEAFOOD_ITEMS).group(ItemGroup.MISC));

	// Block Items
	public static final Block OPAL_ORE = new OpalOreBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES,3).requiresTool().strength(6.0F, 30.0F).materialColor(MapColor.GRAY));

	public static final Block FIERY_OPAL_ORE = new OpalOreBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES,4).requiresTool().strength(50.0F, 30.0F).materialColor(MapColor.DARK_RED));
	//public static BlockEntityType<FryerBlockEntity> FRYER_BLOCK_ENTITY;
	//public static final Block FRYER_BLOCK = new FryerBlock(FabricBlockSettings.of(Material.METAL));

	// World Generation
	private static final ConfiguredFeature<?, ?> OPAL_ORE_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, OPAL_ORE.getDefaultState(), 3))
			.range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(-64), YOffset.fixed(45))))
			.spreadHorizontally().repeat(12);

	private static final ConfiguredFeature<?, ?> FIERY_OPAL_ORE_NETHER = Feature.ORE
			.configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, FIERY_OPAL_ORE.getDefaultState(), 12))
			.range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(-64), YOffset.fixed(200))))
			.spreadHorizontally().repeat(20);

	//Item Groups
	public static final ItemGroup BETTER_SEAFOOD_ITEMS = FabricItemGroupBuilder.build(new Identifier("betterseafood", "items"), () -> new ItemStack(BetterSeafood.OPAL_ORE));

	public static final ItemGroup BETTER_SEAFOOD_FOOD = FabricItemGroupBuilder.build(new Identifier("betterseafood", "food"), () -> new ItemStack(BetterSeafood.OBSIDIAN_SCALED_SALMON));

	//Loot Tables
	private static final Identifier SQUID_LOOT_TABLE_ID = EntityType.SQUID.getLootTableId();

	private static final Identifier GLOW_SQUID_LOOT_TABLE_ID = EntityType.GLOW_SQUID.getLootTableId();

	private static final Identifier TROPICAL_FISH_LOOT_TABLE_ID = EntityType.TROPICAL_FISH.getLootTableId();

	@Override
		public void onInitialize() {

			// Block Items
			Registry.register(Registry.BLOCK, new Identifier("betterseafood", "opal_ore"), OPAL_ORE);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "opal_ore"),
					new BlockItem(OPAL_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
			RegistryKey<ConfiguredFeature<?, ?>> opalOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
					new Identifier("betterseafood", "opal_ore"));

			Registry.register(Registry.BLOCK, new Identifier("betterseafood", "fiery_opal_ore"), FIERY_OPAL_ORE);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "fiery_opal_ore"),
				new BlockItem(FIERY_OPAL_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
			RegistryKey<ConfiguredFeature<?, ?>> fieryopalOreNether = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("betterseafood", "fiery_opal_ore"));

			//FRYER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "betterseafood:demo", FabricBlockEntityTypeBuilder.create(FryerBlockEntity::new, FRYER_BLOCK).build());

			// Items
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "opal"), OPAL);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "fiery_opal"), FIERY_OPAL);
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "fish_scales"), FISH_SCALES);

			// World Generation
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, opalOreOverworld.getValue(), OPAL_ORE_OVERWORLD);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
					opalOreOverworld);
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, fieryopalOreNether.getValue(), FIERY_OPAL_ORE_NETHER);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				fieryopalOreNether);

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
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "obsidian_scaled_salmon"), OBSIDIAN_SCALED_SALMON);


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
			Registry.register(Registry.ITEM, new Identifier("betterseafood", "fiery_opal_pickaxe"),
				new PickaxeBase(new ToolMaterialFieryOpal()));

			//Enchantments
			Registry.register(Registry.ENCHANTMENT, new Identifier("betterseafood", "crystal_bane"), new CrystalBaneEnchantment());

			Registry.register(Registry.ENCHANTMENT, new Identifier("betterseafood", "crystal_sight"), new CrystalSightEnchantment());

			//Loot Tables
			LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
						if (SQUID_LOOT_TABLE_ID.equals(id)) {
							FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(2)).with(ItemEntry.builder(BetterSeafood.RAW_SQUID));

							table.pool(poolBuilder);
						}

						if (GLOW_SQUID_LOOT_TABLE_ID.equals(id)) {
								FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(3)).with(ItemEntry.builder(BetterSeafood.RAW_GLOW_SQUID));

								table.pool(poolBuilder);
						}

						if (TROPICAL_FISH_LOOT_TABLE_ID.equals(id)) {
								FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(3)).with(ItemEntry.builder(BetterSeafood.FISH_SCALES));

								table.pool(poolBuilder);
						}
					});
				}
			}