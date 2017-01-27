package com.theslarfab.tmnmod.block;

import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.init.TMNBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockEnderstoneLamp extends Block {

	private final boolean isOn;

	public BlockEnderstoneLamp(boolean isOn) {
		super(Material.redstoneLight);

		this.isOn = isOn;
		this.setStepSound(soundTypeGlass);

		if (isOn) {
			this.setLightLevel(1.0F);
		}
	}

	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister
				.registerIcon(TooMuchNature.modid + ":" + (this.isOn ? "enderstone_lamp_on" : "enderstone_lamp_off"));
	}

	public void onBlockAdded(World world, int x, int y, int z) {

		if (!world.isRemote) {
			if (this.isOn && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
				world.scheduleBlockUpdate(x, y, z, this, 4);
			} else if (!this.isOn && world.isBlockIndirectlyGettingPowered(x, y, z)) {
				world.setBlock(x, y, z, TMNBlocks.lit_enderstone_lamp, 0, 2);
			}
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {

		if (!world.isRemote) {
			if (this.isOn && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
				world.scheduleBlockUpdate(x, y, z, this, 4);
			} else if (!this.isOn && world.isBlockIndirectlyGettingPowered(x, y, z)) {
				world.setBlock(x, y, z, TMNBlocks.lit_enderstone_lamp, 0, 2);
			}
		}
	}

	public void updateTick(World world, int x, int y, int z, Random random) {

		if (!world.isRemote && this.isOn && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
			world.setBlock(x, y, z, TMNBlocks.enderstone_lamp, 0, 2);
		}
	}

	public Item getItemDropped(int i, Random random, int j) {
		return Item.getItemFromBlock(TMNBlocks.enderstone_lamp);
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(TMNBlocks.enderstone_lamp);
	}

	protected ItemStack createStackedBlock(int i) {
		return new ItemStack(TMNBlocks.enderstone_lamp);
	}
}