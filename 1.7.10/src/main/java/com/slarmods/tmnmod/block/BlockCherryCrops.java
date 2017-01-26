package com.slarmods.tmnmod.block;

import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.init.TMNItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCherryCrops extends BlockCrops {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconArray = new IIcon[4];

		for (int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = iconRegister
					.registerIcon(TooMuchNature.modid + ":" + this.getUnlocalizedName().substring(5) + "_stage_" + i);
		}
	}

	protected boolean canPlaceBlockOn(Block block) {
		return block == Blocks.farmland;
	}

	public IIcon getIcon(int side, int metadata) {
		if (metadata < 7) {
			if (metadata == 6) {
				metadata = 5;
			}

			return this.iconArray[metadata >> 1];
		}

		return this.iconArray[3];
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	protected Item func_149866_i() {
		return TMNItems.cherry_seeds;
	}

	protected Item func_149865_P() {
		return TMNItems.cherry;
	}

	public int getRenderType() {
		return 6;
	}
}
