package com.slarmods.tmnmod.item;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.block.TMNBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFlintAndEndstone extends Item {

	public ItemFlintAndEndstone() {
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureItems);
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (side == 0) {
			--y;
		}

		if (side == 1) {
			++y;
		}

		if (side == 2) {
			--z;
		}

		if (side == 3) {
			++z;
		}

		if (side == 4) {
			--x;
		}

		if (side == 5) {
			++x;
		}

		if (!player.canPlayerEdit(x, y, z, side, itemstack)) {
			return false;
		} else {
			if (world.isAirBlock(x, y, z)) {
				world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "fire.ignite", 1.0F,
						itemRand.nextFloat() * 0.4F + 0.8F);
				world.setBlock(x, y, z, TMNBlocks.end_fire);
			}

			itemstack.damageItem(1, player);
			return true;
		}
	}
}
