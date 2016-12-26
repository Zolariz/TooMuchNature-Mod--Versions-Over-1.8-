package com.slarmods.tmnmod.block;

import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.BlockStone;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockEndObsidian extends BlockStone {

	public BlockEndObsidian(Material material) {
		super();
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks);
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(TooMuchNature.end_obsidian);
	}

	public MapColor getMapColor(int color) {
		return MapColor.sandColor;
	}
}
