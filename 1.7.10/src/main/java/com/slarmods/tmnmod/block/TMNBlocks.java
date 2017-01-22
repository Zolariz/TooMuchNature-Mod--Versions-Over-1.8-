package com.slarmods.tmnmod.block;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.item.ItemBlockCherryLeaf;
import com.slarmods.tmnmod.item.ItemBlockCherryLog;
import com.slarmods.tmnmod.item.ItemBlockCherryPlanks;
import com.slarmods.tmnmod.item.ItemBlockCherrySapling;
import com.slarmods.tmnmod.item.ItemBlockCherrySlab;
import com.slarmods.tmnmod.item.ItemBlockEndStoneBrick;
import com.slarmods.tmnmod.item.ItemBlockEndStoneSlab;
import com.slarmods.tmnmod.item.ItemBlockEndWoodPlanks;
import com.slarmods.tmnmod.item.ItemBlockTMNLeaf1;
import com.slarmods.tmnmod.item.ItemBlockTMNLog1;
import com.slarmods.tmnmod.item.ItemBlockTMNSapling1;
import com.slarmods.tmnmod.item.ItemEndWoodTable;
import com.slarmods.tmnmod.item.ItemEnderPiston;
import com.slarmods.tmnmod.item.ItemWoodTable;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressed;
import net.minecraft.block.BlockCompressedPowered;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class TMNBlocks {

	// Ore Blocks
	public static Block enderald_ore;
	public static Block ruby_ore;
	public static Block sapphire_ore;

	// Basic Blocks
	public static Block enderald_block;
	public static Block ruby_block;

	// Tree Blocks
	public static Block cherry_log;
	public static Block cherry_leaf;
	public static Block cherry_sapling;

	// Cherry Wood Blocks
	public static Block cherry_planks;
	public static Block cherry_double_slab;
	public static Block cherry_slab;
	public static Block cherry_stairs;
	public static Block cherry_fence;
	public static Block cherry_fence_gate;
	public static Block cherry_door_block;

	// Fence | Fence Gate Blocks
	public static Block spruce_fence;
	public static Block birch_fence;
	public static Block jungle_fence;
	public static Block acacia_fence;
	public static Block dark_oak_fence;
	public static Block spruce_fence_gate;
	public static Block birch_fence_gate;
	public static Block jungle_fence_gate;
	public static Block acacia_fence_gate;
	public static Block dark_oak_fence_gate;

	// Door Blocks
	public static Block spruce_door;
	public static Block birch_door;
	public static Block jungle_door;
	public static Block acacia_door;
	public static Block dark_oak_door;

	// Crop Blocks
	public static Block crops_cherry;

	// Enderlands Dimension Blocks
	public static Block cherry_grass;
	public static Block end_obsidian;
	public static Block end_stone_smooth;
	public static Block end_fire;
	public static BlockLowerEndPortal lower_end_portal;
	public static Block end_grass;
	public static Block end_dirt;
	public static BlockEnderWaterLiquid ender_water_dynamic;
	public static BlockEnderWaterLiquid ender_water_static;
	public static Block end_stone_double_slab;
	public static Block end_stone_slab;
	public static Block end_stone_bricks;
	public static Block end_stone_brick_stairs;
	public static Block mossy_end_stone_brick_stairs;
	public static Block end_wood_table;
	public static Block end_wood_planks;
	public static Block end_dirt_path;

	// Circuit Blocks
	public static BlockEnderstoneWire enderstone_wire;
	public static Block enderstone_block;
	public static Block unlit_enderstone_torch;
	public static Block lit_enderstone_torch;
	public static Block end_lever;
	public static Block enderstone_repeater_unpowered;
	public static Block enderstone_repeater_powered;
	public static BlockEnderstoneComparator enderstone_comparator_unpowered;
	public static BlockEnderstoneComparator enderstone_comparator_powered;

	// Machine Blocks
	public static BlockEnderPistonBase ender_piston_sticky;
	public static BlockEnderPistonBase ender_piston_normal;
	public static BlockEnderPistonExtension ender_piston_head;
	public static BlockEnderPistonMoving ender_piston_extension;

	public static Block ender_dispenser;

	// Decoration Blocks
	public static Block wood_table;
	public static Block cherry_wood_table;

	// Container Blocks
	public static Block end_wood_chest;

	// Workbenches
	public static Block ender_workbench;

	// Wood Blocks
	public static Block tmn_log_1;
	public static Block tmn_leaf_1;
	public static Block tmn_sapling_1;
	public static Block tmn_planks_1;
	public static Block tmn_planks_double_slab_1;
	public static Block tmn_planks_slab_1;

	public static void init() {
		TMNBlocks.initBlocks();
		TMNBlocks.registerBlocks();
	}

	public static void initBlocks() {
		// Trees
		cherry_log = new BlockCherryLog(Material.wood).setBlockName("log_cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "log");
		cherry_leaf = new BlockCherryLeaf(Material.leaves).setBlockName("cherry_leaf")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "leaves");
		cherry_sapling = new BlockCherrySapling().setBlockName("cherry_sapling")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks).setStepSound(Block.soundTypeGrass)
				.setBlockTextureName(TooMuchNature.modid + ":" + "sapling");

		tmn_log_1 = new BlockTMNLog1(Material.wood).setBlockName("tmn_log_1")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "log");
		tmn_leaf_1 = new BlockTMNLeaf1(Material.leaves).setBlockName("tmn_leaf_1")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "leaves");
		tmn_sapling_1 = new BlockTMNSapling1().setBlockName("tmn_sapling_1")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks).setStepSound(Block.soundTypeGrass)
				.setBlockTextureName(TooMuchNature.modid + ":" + "sapling");

		// Wood Blocks
		cherry_planks = new BlockCherryWood(Material.wood).setBlockName("cherry_planks")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks").setStepSound(Block.soundTypeWood);
		cherry_double_slab = new BlockCherrySlab(Material.wood, true).setBlockName("double_cherry_slab")
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks").setStepSound(Block.soundTypeWood);
		cherry_slab = new BlockCherrySlab(Material.wood, false).setBlockName("cherry_slab")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks").setStepSound(Block.soundTypeWood);
		cherry_fence = new BlockCherryFence(TooMuchNature.modid + ":" + "planks_cherry", Material.wood)
				.setHardness(2.0F).setResistance(5.0F).setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setStepSound(Block.soundTypeWood).setBlockName("cherry_fence");
		cherry_fence_gate = new BlockCherryFenceGate().setHardness(2.0F).setResistance(5.0F)
				.setStepSound(Block.soundTypeWood).setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setBlockName("cherry_fence_gate").setBlockTextureName(TooMuchNature.modid + ":" + "planks");
		cherry_stairs = new BlockCherryStairs(cherry_planks, 0).setBlockName("cherry_stairs")
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks");

		wood_table = new BlockWoodTable(Material.wood).setBlockName("wood_table").setBlockTextureName("planks")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks);

		// Door Blocks
		cherry_door_block = new BlockCherryDoor(Material.wood).setBlockName("door_cherry")
				.setStepSound(Block.soundTypeWood).setHardness(3.0F)
				.setBlockTextureName(TooMuchNature.modid + ":" + "door_cherry");

		// Crops
		crops_cherry = new BlockCherryCrops().setBlockName("cherries").setStepSound(Block.soundTypeGrass);

		// Dimension-Related Blocks
		cherry_grass = new BlockCherryGrass(Material.grass).setBlockName("cherry_flower_grass").setHardness(0.6F)
				.setStepSound(Block.soundTypeGrass)
				.setBlockTextureName(TooMuchNature.modid + ":" + "cherry_flower_grass");
		end_obsidian = new BlockEndObsidian(Material.rock).setBlockName("end_obsidian").setHardness(50.0F)
				.setResistance(2000.0F).setStepSound(Block.soundTypePiston)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_obsidian");
		end_stone_smooth = new BlockSmoothEndStone().setBlockName("smooth_end_stone").setHardness(1.5F)
				.setResistance(10.0F).setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_smooth");
		end_fire = new BlockEndFire(Material.fire).setBlockName("end_fire")
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_fire");
		lower_end_portal = (BlockLowerEndPortal) new BlockLowerEndPortal().setBlockName("lower_end_portal")
				.setBlockUnbreakable().setLightLevel(0.75F).setStepSound(Block.soundTypeGlass)
				.setBlockTextureName(TooMuchNature.modid + ":" + "lower_end_portal");
		end_grass = new BlockEndGrass(Material.grass).setBlockName("end_grass").setHardness(0.6F)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks).setStepSound(Block.soundTypeGrass)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_grass");
		end_dirt = new BlockEndDirt(Material.ground).setBlockName("end_dirt").setHardness(0.5F)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks).setStepSound(Block.soundTypeGravel)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_dirt");
		end_stone_double_slab = new BlockEndStoneSlab(true).setBlockName("end_stone_double_slab").setHardness(1.5F)
				.setResistance(10.0F).setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_smooth_slab");
		end_stone_slab = new BlockEndStoneSlab(false).setBlockName("end_stone_slab").setHardness(1.5F)
				.setResistance(10.0F).setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_smooth_slab");
		end_stone_bricks = new BlockEndStoneBrick().setBlockName("end_stone_brick").setHardness(1.5F)
				.setResistance(10.0F).setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_bricks");
		end_stone_brick_stairs = new BlockEndStoneBrickStairs(end_stone_bricks, 0)
				.setBlockName("end_stone_brick_stairs")
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_bricks");
		end_wood_table = new BlockEndWoodTable(Material.wood).setBlockName("end_wood_table")
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks");
		end_wood_planks = new BlockEndWood(Material.wood).setBlockName("end_wood_planks")
				.setStepSound(Block.soundTypeWood).setBlockTextureName(TooMuchNature.modid + ":" + "planks");
		end_dirt_path = new BlockEndDirtPath().setBlockName("end_dirt_path").setStepSound(Block.soundTypeGravel)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_dirt_path");

		// Blocks
		enderald_block = new BlockCompressed(MapColor.cyanColor).setBlockName("enderald_block").setHardness(5.0F)
				.setResistance(10.0F).setStepSound(Block.soundTypeMetal)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderald_block");

		enderald_ore = new BlockEnderaldOre(Material.rock).setBlockName("enderald_ore").setHardness(3.0F)
				.setResistance(5.0F).setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderald_ore");

		// Liquid Blocks
		ender_water_dynamic = (BlockEnderWaterLiquid) new BlockEnderWaterDynamic(Material.water)
				.setBlockName("ender_water_flow").setBlockTextureName(TooMuchNature.modid + ":" + "ender_water_flow");
		ender_water_static = (BlockEnderWaterLiquid) new BlockEnderWaterStatic(Material.water)
				.setBlockName("ender_water_still").setBlockTextureName(TooMuchNature.modid + ":" + "ender_water_still");

		// Circuit Blocks
		enderstone_wire = (BlockEnderstoneWire) new BlockEnderstoneWire().setBlockName("enderstone_wire")
				.setBlockTextureName("redstone_dust").setHardness(0.0F).setResistance(0.0F);
		enderstone_repeater_unpowered = new BlockEnderstoneRepeater(false).setBlockName("enderstone_repeater_unlit")
				.setStepSound(Block.soundTypeWood)
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderstone_repeater_off");
		enderstone_repeater_powered = new BlockEnderstoneRepeater(true).setBlockName("enderstone_repeater_lit")
				.setStepSound(Block.soundTypeWood)
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderstone_repeater_on");
		enderstone_comparator_unpowered = (BlockEnderstoneComparator) new BlockEnderstoneComparator(false)
				.setBlockName("enderstone_comparator_unlit").setStepSound(Block.soundTypeWood)
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderstone_comparator_off");
		enderstone_comparator_powered = (BlockEnderstoneComparator) new BlockEnderstoneComparator(true)
				.setBlockName("enderstone_comparator_lit").setStepSound(Block.soundTypeWood)
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderstone_comparator_on");
		unlit_enderstone_torch = new BlockEnderstoneTorch(false).setBlockName("enderstone_torch_unlit")
				.setLightLevel(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderstone_torch_off");
		lit_enderstone_torch = new BlockEnderstoneTorch(true).setBlockName("enderstone_torch_lit").setLightLevel(0.5F)
				.setStepSound(Block.soundTypeWood).setCreativeTab(TooMuchNature.tabEnderstone)
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderstone_torch_on");
		end_lever = new BlockEndLever().setBlockName("end_lever").setHardness(0.5F).setStepSound(Block.soundTypeWood)
				.setCreativeTab(TooMuchNature.tabEnderstone)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_lever");

		// Container Blocks
		end_wood_chest = new BlockEndWoodChest(0).setBlockName("end_wood_chest").setStepSound(Block.soundTypeWood)
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks_end_oak");
		ender_workbench = new BlockEnderWorkbench().setBlockName("ender_workbench").setStepSound(Block.soundTypeWood)
				.setHardness(2.5F).setStepSound(Block.soundTypeWood)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks);

		// Mechanical Blocks
		ender_piston_sticky = (BlockEnderPistonBase) new BlockEnderPistonBase(true).setBlockName("sticky_ender_piston")
				.setStepSound(Block.soundTypePiston).setCreativeTab(TooMuchNature.tabEnderstone);
		ender_piston_normal = (BlockEnderPistonBase) new BlockEnderPistonBase(false).setBlockName("ender_piston")
				.setStepSound(Block.soundTypePiston).setCreativeTab(TooMuchNature.tabEnderstone);
		ender_piston_head = (BlockEnderPistonExtension) new BlockEnderPistonExtension()
				.setBlockName("ender_piston_head").setStepSound(Block.soundTypePiston);
		ender_piston_extension = (BlockEnderPistonMoving) new BlockEnderPistonMoving()
				.setBlockName("ender_piston_extension").setStepSound(Block.soundTypePiston);

		ender_dispenser = new BlockEnderDispenser().setBlockName("ender_dispenser")
				.setCreativeTab(TooMuchNature.tabEnderstone).setHardness(3.0F).setResistance(5.0F)
				.setStepSound(Block.soundTypePiston).setBlockTextureName(TooMuchNature.modid + ":" + "ender_dispenser");

		// Power Provider Block
		enderstone_block = new BlockCompressedPowered(MapColor.cyanColor).setBlockName("enderstone_block")
				.setCreativeTab(TooMuchNature.tabEnderstone).setHardness(5.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeMetal).setBlockTextureName(TooMuchNature.modid + ":" + "enderstone_block");

	}

	public static void registerBlocks() {
		GameRegistry.registerBlock(enderald_ore, enderald_ore.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(enderald_block, enderald_block.getUnlocalizedName().substring(5));

		// Wood Block Registers
		GameRegistry.registerBlock(cherry_log, ItemBlockCherryLog.class, cherry_log.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_leaf, ItemBlockCherryLeaf.class,
				cherry_leaf.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_sapling, ItemBlockCherrySapling.class,
				cherry_sapling.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_planks, ItemBlockCherryPlanks.class,
				cherry_planks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_double_slab, ItemBlockCherrySlab.class,
				cherry_double_slab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_slab, ItemBlockCherrySlab.class,
				cherry_slab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_fence, cherry_fence.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_fence_gate, cherry_fence_gate.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_door_block, cherry_door_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_stairs, cherry_stairs.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(wood_table, ItemWoodTable.class, wood_table.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(tmn_log_1, ItemBlockTMNLog1.class, tmn_log_1.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tmn_leaf_1, ItemBlockTMNLeaf1.class, tmn_leaf_1.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tmn_sapling_1, ItemBlockTMNSapling1.class,
				tmn_sapling_1.getUnlocalizedName().substring(5));

		// Crops Registers
		GameRegistry.registerBlock(crops_cherry, crops_cherry.getUnlocalizedName().substring(5));

		// Enderlands Dimension Block Registers
		GameRegistry.registerBlock(cherry_grass, cherry_grass.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_obsidian, end_obsidian.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_smooth, end_stone_smooth.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_fire, end_fire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(lower_end_portal, lower_end_portal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_grass, end_grass.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_dirt, end_dirt.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_double_slab, ItemBlockEndStoneSlab.class,
				end_stone_double_slab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_slab, ItemBlockEndStoneSlab.class,
				end_stone_slab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_bricks, ItemBlockEndStoneBrick.class,
				end_stone_bricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_brick_stairs, end_stone_brick_stairs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_wood_table, ItemEndWoodTable.class,
				end_wood_table.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ender_water_dynamic, ender_water_dynamic.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ender_water_static, ender_water_static.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_wood_planks, ItemBlockEndWoodPlanks.class,
				end_wood_planks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_dirt_path, end_dirt_path.getUnlocalizedName().substring(5));

		// Circuit Block Registers
		GameRegistry.registerBlock(enderstone_wire, enderstone_wire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(enderstone_repeater_unpowered,
				enderstone_repeater_unpowered.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(enderstone_repeater_powered,
				enderstone_repeater_powered.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(enderstone_comparator_unpowered,
				enderstone_comparator_unpowered.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(enderstone_comparator_powered,
				enderstone_comparator_powered.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(unlit_enderstone_torch, unlit_enderstone_torch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(lit_enderstone_torch, lit_enderstone_torch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_lever, end_lever.getUnlocalizedName().substring(5));

		// Container Block Registers
		GameRegistry.registerBlock(end_wood_chest, end_wood_chest.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ender_workbench, ender_workbench.getUnlocalizedName().substring(5));

		// Machine Block Registers
		GameRegistry.registerBlock(ender_piston_sticky, ItemEnderPiston.class,
				ender_piston_sticky.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ender_piston_normal, ItemEnderPiston.class,
				ender_piston_normal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ender_piston_head, ender_piston_head.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ender_piston_extension, ender_piston_extension.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(ender_dispenser, ender_dispenser.getUnlocalizedName().substring(5));

		// Powered Block Registers
		GameRegistry.registerBlock(enderstone_block, enderstone_block.getUnlocalizedName().substring(5));
	}
}
