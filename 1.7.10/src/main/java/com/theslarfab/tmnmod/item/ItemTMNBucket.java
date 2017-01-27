package com.theslarfab.tmnmod.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.init.TMNBlocks;
import com.theslarfab.tmnmod.init.TMNItems;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ItemTMNBucket extends Item {
	private Block isFull;

	public ItemTMNBucket(Block block) {
		this.maxStackSize = 1;
		this.isFull = block;
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureMisc);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		boolean flag = this.isFull == Blocks.air;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, flag);

		if (movingobjectposition == null) {
			return itemstack;
		} else {
			FillBucketEvent event = new FillBucketEvent(player, itemstack, world, movingobjectposition);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return itemstack;
			}

			if (event.getResult() == Event.Result.ALLOW) {
				if (player.capabilities.isCreativeMode) {
					return itemstack;
				}

				if (--itemstack.stackSize <= 0) {
					return event.result;
				}

				if (!player.inventory.addItemStackToInventory(event.result)) {
					player.dropPlayerItemWithRandomChoice(event.result, false);
				}

				return itemstack;
			}
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;

				if (!world.canMineBlock(player, i, j, k)) {
					return itemstack;
				}

				if (flag) {
					if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemstack)) {
						return itemstack;
					}

					Material material = world.getBlock(i, j, k).getMaterial();
					int l = world.getBlockMetadata(i, j, k);

					if (material == Material.water && l == 0) {
						world.setBlockToAir(i, j, k);
						return this.func_150910_a(itemstack, player, TMNItems.ender_water_bucket);
					}
				} else {
					if (this.isFull == Blocks.air) {
						return new ItemStack(TMNItems.enderald_bucket);
					}

					if (movingobjectposition.sideHit == 0) {
						--j;
					}

					if (movingobjectposition.sideHit == 1) {
						++j;
					}

					if (movingobjectposition.sideHit == 2) {
						--k;
					}

					if (movingobjectposition.sideHit == 3) {
						++k;
					}

					if (movingobjectposition.sideHit == 4) {
						--i;
					}

					if (movingobjectposition.sideHit == 5) {
						++i;
					}

					if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemstack)) {
						return itemstack;
					}

					if (this.tryPlaceContainedLiquid(world, i, j, k) && !player.capabilities.isCreativeMode) {
						return new ItemStack(TMNItems.enderald_bucket);
					}
				}
			}

			return itemstack;
		}
	}

	private ItemStack func_150910_a(ItemStack itemstack, EntityPlayer player, Item item) {
		if (player.capabilities.isCreativeMode) {
			return itemstack;
		} else if (--itemstack.stackSize <= 0) {
			return new ItemStack(item);
		} else {
			if (!player.inventory.addItemStackToInventory(new ItemStack(item))) {
				player.dropPlayerItemWithRandomChoice(new ItemStack(item, 1, 0), false);
			}

			return itemstack;
		}
	}

	public boolean tryPlaceContainedLiquid(World world, int x, int y, int z) {
		if (this.isFull == Blocks.air) {
			return false;
		} else {
			Material material = world.getBlock(x, y, z).getMaterial();
			boolean flag = !material.isSolid();

			if (!world.isAirBlock(x, y, z) && !flag) {
				return false;
			} else {
				if (world.provider.isHellWorld && this.isFull == TMNBlocks.ender_water_dynamic) {
					world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
							(double) ((float) z + 0.5F), "random.fizz", 0.5F,
							2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

					for (int l = 0; l < 8; ++l) {
						world.spawnParticle("largesmoke", (double) x + Math.random(), (double) y + Math.random(),
								(double) z + Math.random(), 0.0D, 0.0D, 0.0D);
					}
				} else {
					if (!world.isRemote && flag && !material.isLiquid()) {
						world.func_147480_a(x, y, z, true);
					}

					world.setBlock(x, y, z, this.isFull, 0, 3);
				}

				return true;
			}
		}
	}
}
