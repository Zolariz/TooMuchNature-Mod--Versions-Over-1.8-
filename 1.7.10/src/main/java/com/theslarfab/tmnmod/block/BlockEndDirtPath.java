package com.theslarfab.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.init.TMNBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockEndDirtPath extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon topIcon;

	public BlockEndDirtPath() {
		super(Material.ground);
		this.setTickRandomly(true);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
		this.setLightOpacity(255);
		this.useNeighborBrightness = true;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox((double) (x + 0), (double) (y + 0), (double) (z + 0), (double) (x + 1),
				(double) (y + 1), (double) (z + 1));
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? this.topIcon
				: (side == 0 ? TMNBlocks.end_dirt.getBlockTextureFromSide(side) : this.blockIcon);
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);
		Material material = world.getBlock(x, y + 1, z).getMaterial();

		if (material.isSolid()) {
			world.setBlock(x, y, z, TMNBlocks.end_dirt);
		}
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return TMNBlocks.end_dirt.getItemDropped(0, random, fortune);
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(TMNBlocks.end_dirt_path);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.topIcon = iconRegister.registerIcon(this.getTextureName() + "_" + "top");
		this.blockIcon = iconRegister.registerIcon(this.getTextureName() + "_" + "side");
	}
}