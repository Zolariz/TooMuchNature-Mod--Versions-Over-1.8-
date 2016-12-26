package com.slarmods.tmnmod.block;

import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockSmoothEndStone extends Block {

	public BlockSmoothEndStone() {
		super(Material.rock);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks);
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(Blocks.end_stone);
	}
}
