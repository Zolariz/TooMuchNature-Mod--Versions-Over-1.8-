package com.theslarfab.tmnmod.item;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.event.UseEnderRoadTillerEvent;
import com.theslarfab.tmnmod.init.TMNBlocks;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ItemEnderaldRoadTiller extends Item {

	public ItemEnderaldRoadTiller() {
		this.setMaxDamage(2261);
		this.maxStackSize = 1;
		this.setCreativeTab(TooMuchNatventure.tabTMNMisc);
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, side, itemstack)) {
			return false;
		} else {
			UseEnderRoadTillerEvent event = new UseEnderRoadTillerEvent(player, itemstack, world, x, y, z);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return false;
			}

			if (event.getResult() == Result.ALLOW) {
				itemstack.damageItem(1, player);
				return true;
			}

			Block block = world.getBlock(x, y, z);

			if (side != 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z)
					&& (block == TMNBlocks.end_grass)) {
				Block block1 = TMNBlocks.end_dirt_path;
				world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
						(double) ((float) z + 0.5F), block1.stepSound.getStepResourcePath(),
						(block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

				if (world.isRemote) {
					return true;
				} else {
					world.setBlock(x, y, z, block1);
					itemstack.damageItem(1, player);
					return true;
				}
			} else {
				return false;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
}
