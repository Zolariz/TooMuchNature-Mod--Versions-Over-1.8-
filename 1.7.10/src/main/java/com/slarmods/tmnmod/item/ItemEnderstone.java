package com.slarmods.tmnmod.item;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.block.TMNBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEnderstone extends Item {

	public ItemEnderstone() {
		this.setCreativeTab(TooMuchNature.tabEnderstone);
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (world.getBlock(x, y, z) != Blocks.snow_layer) {
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

			if (!world.isAirBlock(x, y, z)) {
				return false;
			}
		}

		if (!player.canPlayerEdit(x, y, z, side, itemstack)) {
			return false;
		} else {
			if (TMNBlocks.enderstone_wire.canPlaceBlockAt(world, x, y, z)) {
				--itemstack.stackSize;
				world.setBlock(x, y, z, TMNBlocks.enderstone_wire);
			}

			return true;
		}
	}
}
