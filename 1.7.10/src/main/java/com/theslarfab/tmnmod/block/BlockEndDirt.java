package com.theslarfab.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.init.TMNBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEndDirt extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon field_150008_b;
	@SideOnly(Side.CLIENT)
	private IIcon field_150010_M;

	public BlockEndDirt(Material material) {
		super(Material.ground);
		this.setCreativeTab(TooMuchNatventure.tabTMNBlocks);
		this.setHarvestLevel("shovel", 0);
	}

	public int damageDropped(int damage) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
		int i1 = blockAccess.getBlockMetadata(x, y, z);

		if (i1 == 2) {
			if (side == 1) {
				return this.field_150008_b;
			}

			if (side != 0) {
				Material material = blockAccess.getBlock(x, y + 1, z).getMaterial();

				if (material == Material.snow || material == Material.craftedSnow) {
					return TMNBlocks.end_grass.getIcon(blockAccess, x, y, z,
							side);
				}

				Block block = blockAccess.getBlock(x, y + 1, z);

				if (block != TMNBlocks.end_dirt && block != TMNBlocks.end_grass) {
					return this.field_150010_M;
				}
			}
		}

		return this.blockIcon;
	}
}
