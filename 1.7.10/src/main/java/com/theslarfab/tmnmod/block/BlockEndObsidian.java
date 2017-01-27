package com.theslarfab.tmnmod.block;

import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.init.TMNBlocks;

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
		this.setHarvestLevel("pickaxe", 3);
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(TMNBlocks.end_obsidian);
	}

	public MapColor getMapColor(int color) {
		return MapColor.sandColor;
	}
}
