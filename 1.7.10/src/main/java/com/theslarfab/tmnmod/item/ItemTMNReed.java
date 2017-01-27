package com.theslarfab.tmnmod.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTMNReed extends Item {
	private Block placeBlock;

	public ItemTMNReed(Block block) {
		this.placeBlock = block;
	}

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);

		if (block == Blocks.snow_layer && (world.getBlockMetadata(x, y, z) & 7) < 1) {
			side = 1;
		} else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush) {
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
		}

		if (!entityPlayer.canPlayerEdit(x, y, z, side, itemStack)) {
			return false;
		} else if (itemStack.stackSize == 0) {
			return false;
		} else {
			if (world.canPlaceEntityOnSide(this.placeBlock, x, y, z, false, side, (Entity) null, itemStack)) {
				int i1 = this.placeBlock.onBlockPlaced(world, x, y, z, side, hitX, hitY, hitZ, 0);

				if (world.setBlock(x, y, z, this.placeBlock, i1, 3)) {
					if (world.getBlock(x, y, z) == this.placeBlock) {
						this.placeBlock.onBlockPlacedBy(world, x, y, z, entityPlayer, itemStack);
						this.placeBlock.onPostBlockPlaced(world, x, y, z, i1);
					}

					world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
							(double) ((float) z + 0.5F), this.placeBlock.stepSound.func_150496_b(),
							(this.placeBlock.stepSound.getVolume() + 1.0F) / 2.0F,
							this.placeBlock.stepSound.getPitch() * 0.8F);
					--itemStack.stackSize;
				}
			}

			return true;
		}
	}
}
