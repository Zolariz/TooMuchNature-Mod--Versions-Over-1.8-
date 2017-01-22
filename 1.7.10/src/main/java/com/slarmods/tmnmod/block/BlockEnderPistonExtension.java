package com.slarmods.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.client.renderer.BlockRenderingIDs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEnderPistonExtension extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon pistonTexture;

	public BlockEnderPistonExtension() {
		super(Material.piston);
		this.setStepSound(soundTypePiston);
		this.setHardness(0.5F);
	}

	@SideOnly(Side.CLIENT)
	public void func_150086_a(IIcon icon) {
		this.pistonTexture = icon;
	}

	public void onBlockHarvested(World world, int x, int y, int z, int side, EntityPlayer entityPlayer) {
		if (entityPlayer.capabilities.isCreativeMode) {
			int i1 = getDirectionMeta(side);
			Block block = world.getBlock(x - Facing.offsetsXForSide[i1], y - Facing.offsetsYForSide[i1],
					z - Facing.offsetsZForSide[i1]);

			if (block == TMNBlocks.ender_piston_normal || block == TMNBlocks.ender_piston_sticky) {
				world.setBlockToAir(x - Facing.offsetsXForSide[i1], y - Facing.offsetsYForSide[i1],
						z - Facing.offsetsZForSide[i1]);
			}
		}

		super.onBlockHarvested(world, x, y, z, side, entityPlayer);
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int side) {
		super.breakBlock(world, x, y, z, block, side);
		int i1 = Facing.oppositeSide[getDirectionMeta(side)];
		x += Facing.offsetsXForSide[i1];
		y += Facing.offsetsYForSide[i1];
		z += Facing.offsetsZForSide[i1];
		Block block1 = world.getBlock(x, y, z);

		if (block1 == TMNBlocks.ender_piston_normal || block1 == TMNBlocks.ender_piston_sticky) {
			side = world.getBlockMetadata(x, y, z);

			if (BlockEnderPistonBase.isExtended(side)) {
				block1.dropBlockAsItem(world, x, y, z, side, 0);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void func_150087_e() {
		this.pistonTexture = null;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		int k = getDirectionMeta(meta);
		return side == k ? (this.pistonTexture != null ? this.pistonTexture
				: ((meta & 8) != 0
						? BlockEnderPistonBase.getPistonBaseIcon(TooMuchNature.modid + ":" + "ender_piston_top_sticky")
						: BlockEnderPistonBase
								.getPistonBaseIcon(TooMuchNature.modid + ":" + "ender_piston_top_normal")))
				: (k < 6 && side == Facing.oppositeSide[k]
						? BlockEnderPistonBase.getPistonBaseIcon(TooMuchNature.modid + ":" + "ender_piston_top_normal")
						: BlockEnderPistonBase.getPistonBaseIcon(TooMuchNature.modid + ":" + "ender_piston_side"));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {

	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return BlockRenderingIDs.enderPistonExtensionRenderID;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return false;
	}

	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
		return false;
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list,
			Entity entity) {
		int l = world.getBlockMetadata(x, y, z);
		float f = 0.25F;
		float f1 = 0.375F;
		float f2 = 0.625F;
		float f3 = 0.25F;
		float f4 = 0.75F;

		switch (getDirectionMeta(l)) {
		case 0:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			this.setBlockBounds(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			break;
		case 2:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			this.setBlockBounds(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			break;
		case 3:
			this.setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			this.setBlockBounds(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			break;
		case 4:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			this.setBlockBounds(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			break;
		case 5:
			this.setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
			this.setBlockBounds(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
			super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		int l = blockAccess.getBlockMetadata(x, y, z);
		float f = 0.25F;

		switch (getDirectionMeta(l)) {
		case 0:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
			break;
		case 2:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
			break;
		case 3:
			this.setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
			break;
		case 4:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
			break;
		case 5:
			this.setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		int l = getDirectionMeta(world.getBlockMetadata(x, y, z));
		Block block1 = world.getBlock(x - Facing.offsetsXForSide[l], y - Facing.offsetsYForSide[l],
				z - Facing.offsetsZForSide[l]);

		if (block1 != TMNBlocks.ender_piston_normal && block1 != TMNBlocks.ender_piston_sticky) {
			world.setBlockToAir(x, y, z);
		} else {
			block1.onNeighborBlockChange(world, x - Facing.offsetsXForSide[l], y - Facing.offsetsYForSide[l],
					z - Facing.offsetsZForSide[l], block);
		}
	}

	public static int getDirectionMeta(int meta) {
		return MathHelper.clamp_int(meta & 7, 0, Facing.offsetsXForSide.length - 1);
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z);
		return (l & 8) != 0 ? Item.getItemFromBlock(TMNBlocks.ender_piston_sticky)
				: Item.getItemFromBlock(TMNBlocks.ender_piston_normal);
	}
}
