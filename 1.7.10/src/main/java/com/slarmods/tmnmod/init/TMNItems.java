package com.slarmods.tmnmod.init;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.armor.KangarooArmor;
import com.slarmods.tmnmod.item.ItemAcaciaDoor;
import com.slarmods.tmnmod.item.ItemBirchDoor;
import com.slarmods.tmnmod.item.ItemCherryDoor;
import com.slarmods.tmnmod.item.ItemDarkOakDoor;
import com.slarmods.tmnmod.item.ItemEnderGun;
import com.slarmods.tmnmod.item.ItemEnderaldRoadTiller;
import com.slarmods.tmnmod.item.ItemEnderstone;
import com.slarmods.tmnmod.item.ItemFlintAndEndstone;
import com.slarmods.tmnmod.item.ItemJungleDoor;
import com.slarmods.tmnmod.item.ItemSpruceDoor;
import com.slarmods.tmnmod.item.ItemTMNBucket;
import com.slarmods.tmnmod.item.ItemTMNReed;
import com.slarmods.tmnmod.item.ItemTMNSpawnEgg;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class TMNItems {

	/** Armor Materials */
	public static final ArmorMaterial KangarooArmorMaterial = EnumHelper.addArmorMaterial("KangarooArmorMaterial", 14,
			new int[] { 2, 5, 4, 2 }, 10);

	/** Tool Materials */
	public static final ToolMaterial ENDERALD = EnumHelper.addToolMaterial("ENDERALD", 3, 2261, 22, 7.0F, 30);

	// Food Items
	public static Item orange;
	public static Item cherry;
	public static Item raw_kangaroo;
	public static Item cooked_kangaroo;
	public static Item white_cherry;

	// Mob Drop Items
	public static Item kangaroo_skin;

	// Functional Items
	public static Item end_stone_and_steel;
	public static Item tmn_spawn_egg;

	// Basic Items
	public static Item ruby;
	public static Item sapphire;
	public static Item titanium_ingot;
	public static Item platinum_ingot;
	public static Item enderald;

	// Fluid Items
	public static Item ender_water_bucket;

	// Door Items
	public static Item item_cherry_door;
	public static Item item_spruce_door;
	public static Item item_birch_door;
	public static Item item_jungle_door;
	public static Item item_acacia_door;
	public static Item item_dark_oak_door;
	public static Item item_ender_door;

	// Crop Seeds
	public static Item cherry_seeds;

	// Circuit Item
	public static Item enderstone_dust;
	public static Item enderstone_repeater;
	public static Item enderstone_comparator;

	// Liquid Container Items
	public static Item enderald_bucket;

	// Armor Item
	public static Item kangaroo_helm;
	public static Item kangaroo_chest;
	public static Item kangaroo_leggings;
	public static Item kangaroo_boots;

	public static Item enderald_helm;
	public static Item enderald_chest;
	public static Item enderald_leggings;
	public static Item enderald_boots;

	// Armor ID
	public static int kangaroo_helm_ID;
	public static int kangaroo_chest_ID;
	public static int kangaroo_leggings_ID;
	public static int kangaroo_boots_ID;

	public static int enderald_helm_ID;
	public static int enderaldo_chest_ID;
	public static int enderald_leggings_ID;
	public static int enderald_boots_ID;

	// Shooting Weapons
	public static Item ender_pistol;

	// Melee Weapons
	public static Item enderald_sword;

	// Tools
	public static Item enderald_road_tiller;
	public static Item enderald_shovel;

	public static void init() {
		TMNItems.initItems();
		TMNItems.registerItems();
	}

	public static void initItems() {

		// Animal Items
		kangaroo_skin = new Item().setUnlocalizedName("kangaroo_skin")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "kangaroo_hide");

		// Door Items
		item_cherry_door = new ItemCherryDoor(Material.wood).setUnlocalizedName("cherry_door")
				.setCreativeTab(TooMuchNature.tabEnderstone).setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_spruce_door = new ItemSpruceDoor(Material.wood).setUnlocalizedName("spruce_door")
				.setCreativeTab(CreativeTabs.tabRedstone).setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_birch_door = new ItemBirchDoor(Material.wood).setUnlocalizedName("birch_door")
				.setCreativeTab(CreativeTabs.tabRedstone).setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_jungle_door = new ItemJungleDoor(Material.wood).setUnlocalizedName("jungle_door")
				.setCreativeTab(CreativeTabs.tabRedstone).setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_acacia_door = new ItemAcaciaDoor(Material.wood).setUnlocalizedName("acacia_door")
				.setCreativeTab(CreativeTabs.tabRedstone).setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_dark_oak_door = new ItemDarkOakDoor(Material.wood).setUnlocalizedName("dark_oak_door")
				.setCreativeTab(CreativeTabs.tabRedstone).setTextureName(TooMuchNature.modid + ":" + "cherry_door");

		// Dimension-Related Items
		end_stone_and_steel = new ItemFlintAndEndstone().setUnlocalizedName("flint_and_endstone")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureMisc)
				.setTextureName(TooMuchNature.modid + ":" + "end_stone_and_steel");

		// Items
		ruby = new Item().setUnlocalizedName("ruby").setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName("ruby");

		sapphire = new Item().setUnlocalizedName("sapphire").setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "sapphire");

		titanium_ingot = new Item().setUnlocalizedName("titanium_ingot")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "titanium_ingot");

		platinum_ingot = new Item().setUnlocalizedName("platinum_ingot")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "platinum_ingot");

		enderald = new Item().setUnlocalizedName("enderald").setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "enderald");

		// Circuit Items
		enderstone_dust = new ItemEnderstone().setUnlocalizedName("enderstone_dust")
				.setTextureName(TooMuchNature.modid + ":" + "enderstone_dust");

		// Shooting Weapons
		ender_pistol = new ItemEnderGun().setUnlocalizedName("ender_gun")
				.setTextureName(TooMuchNature.modid + ":" + "ender_pistol");

		// Melee Weapons
		enderald_sword = new ItemSword(ENDERALD).setUnlocalizedName("enderald_sword")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureMisc)
				.setTextureName(TooMuchNature.modid + ":" + "enderald_sword");

		// Tools
		enderald_road_tiller = new ItemEnderaldRoadTiller().setUnlocalizedName("enderald_road_tiller")
				.setTextureName(TooMuchNature.modid + ":" + "enderald_road_tiller");

		// Seeds
		cherry_seeds = new ItemSeeds(TMNBlocks.crops_cherry, Blocks.farmland).setUnlocalizedName("seeds_cherry")
				.setTextureName(TooMuchNature.modid + ":" + "seeds_cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems);

		// Reed Items
		enderstone_repeater = new ItemTMNReed(TMNBlocks.enderstone_repeater_unpowered)
				.setUnlocalizedName("enderstone_repeater").setCreativeTab(TooMuchNature.tabEnderstone)
				.setTextureName(TooMuchNature.modid + ":" + "enderstone_repeater");
		enderstone_comparator = new ItemTMNReed(TMNBlocks.enderstone_comparator_unpowered)
				.setUnlocalizedName("enderstone_comparator").setCreativeTab(TooMuchNature.tabEnderstone)
				.setTextureName(TooMuchNature.modid + ":" + "enderstone_comparator");

		// Bucket Items
		ender_water_bucket = new ItemTMNBucket(TMNBlocks.ender_water_dynamic).setUnlocalizedName("ender_water_bucket")
				.setTextureName(TooMuchNature.modid + ":" + "enderald_bucket_ender_water");
		enderald_bucket = new ItemTMNBucket(Blocks.air).setUnlocalizedName("enderald_bucket")
				.setTextureName(TooMuchNature.modid + ":" + "enderald_bucket");

		// Food
		orange = new ItemFood(4, 0.5F, false).setUnlocalizedName("orange")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "orange");
		cherry = new ItemFood(2, 0.4F, false).setUnlocalizedName("cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "cherry");
		raw_kangaroo = new ItemFood(5, 0.5F, true).setUnlocalizedName("raw_kangaroo")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "kangaroo_meat_raw");
		cooked_kangaroo = new ItemFood(12, 0.8F, true).setUnlocalizedName("cooked_kangaroo")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "kangaroo_meat_cooked");
		white_cherry = new ItemFood(2, 0.3F, false).setUnlocalizedName("white_cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "cherry_white");

		// Armor
		kangaroo_helm = new KangarooArmor(KangarooArmorMaterial, kangaroo_helm_ID, 0)
				.setUnlocalizedName("kangaroo_helmet");
		kangaroo_chest = new KangarooArmor(KangarooArmorMaterial, kangaroo_helm_ID, 1)
				.setUnlocalizedName("kangaroo_chestplate");
		kangaroo_leggings = new KangarooArmor(KangarooArmorMaterial, kangaroo_helm_ID, 2)
				.setUnlocalizedName("kangaroo_leggings");
		kangaroo_boots = new KangarooArmor(KangarooArmorMaterial, kangaroo_helm_ID, 3)
				.setUnlocalizedName("kangaroo_boots");

		// Spawn Eggs
		tmn_spawn_egg = new ItemTMNSpawnEgg().setUnlocalizedName("tmn_spawn_egg");
	}

	public static void registerItems() {

		GameRegistry.registerItem(orange, orange.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cherry, cherry.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(raw_kangaroo, raw_kangaroo.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cooked_kangaroo, cooked_kangaroo.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(white_cherry, white_cherry.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(kangaroo_skin, kangaroo_skin.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tmn_spawn_egg, tmn_spawn_egg.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(end_stone_and_steel, end_stone_and_steel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby, ruby.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sapphire, sapphire.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_ingot, titanium_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(platinum_ingot, platinum_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(enderald, enderald.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(kangaroo_helm, kangaroo_helm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(kangaroo_chest, kangaroo_chest.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(kangaroo_leggings, kangaroo_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(kangaroo_boots, kangaroo_boots.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(item_cherry_door, item_cherry_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_spruce_door, item_spruce_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_birch_door, item_birch_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_jungle_door, item_jungle_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_acacia_door, item_acacia_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_dark_oak_door, item_dark_oak_door.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(cherry_seeds, cherry_seeds.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(enderstone_dust, enderstone_dust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(enderstone_repeater, enderstone_repeater.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(enderstone_comparator, enderstone_comparator.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(enderald_bucket, enderald_bucket.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ender_water_bucket, ender_water_bucket.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(ender_pistol, ender_pistol.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(enderald_sword, enderald_sword.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(enderald_road_tiller, enderald_road_tiller.getUnlocalizedName().substring(5));

	}
}