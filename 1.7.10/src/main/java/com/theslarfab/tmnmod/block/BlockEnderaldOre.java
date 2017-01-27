package com.theslarfab.tmnmod.block;

import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.init.TMNItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

public class BlockEnderaldOre extends Block {

	private Random rand = new Random();
	
	public BlockEnderaldOre(Material material) {
		super(Material.rock);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks);
		this.setHarvestLevel("pickaxe", 2);
	}

	public Item getItemDropped(int metadata, Random random, int fortune) {
		return TMNItems.enderald;
	}

	public int quantityDropped(Random random) {
		return 1 + random.nextInt(3);
	}

	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
    {
        return 0;
    }
}
