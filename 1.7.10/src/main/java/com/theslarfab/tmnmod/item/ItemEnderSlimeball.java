package com.theslarfab.tmnmod.item;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.entity.projectile.EntityEnderSlimeball;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEnderSlimeball extends Item {

	public ItemEnderSlimeball() {
		this.maxStackSize = 64;
		this.setCreativeTab(TooMuchNatventure.tabTMNItems);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {
			--itemstack.stackSize;
		}

		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntityEnderSlimeball(world, player));
		}

		return itemstack;
	}
}