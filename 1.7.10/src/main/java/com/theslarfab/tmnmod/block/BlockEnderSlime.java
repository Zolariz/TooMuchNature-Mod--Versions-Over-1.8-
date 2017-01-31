package com.theslarfab.tmnmod.block;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.client.renderer.block.BlockRenderingIDs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEnderSlime extends BlockBreakable {

	private boolean isBouncing = false;
	private double maxHeight = 0.0D;

	public BlockEnderSlime() {
		super(TooMuchNatventure.modid + ":" + "ender_slime", Material.clay, false);
		this.slipperiness = 0.8F;
	}

	public void onFallenUpon(World world, int X, int Y, int Z, Entity entity, float entityFallDistance) {
		if (entity.isSneaking()) {
			super.onFallenUpon(world, X, Y, Z, entity, entityFallDistance);
		} else {
			entity.fallDistance = 0.0F;
			this.isBouncing = true;
			this.maxHeight = (-entity.motionY);
		}
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (!entity.isSneaking()) {
			if (this.isBouncing) {
				entity.motionY = this.maxHeight;
				this.isBouncing = false;
			} else if (Math.abs(entity.motionY) < 0.1D) {
				double d0 = 0.4D + Math.abs(entity.motionY) * 0.2D;
				entity.motionX *= d0;
				entity.motionZ *= d0;
			}
		}
		super.onEntityCollidedWithBlock(world, x, y, z, entity);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return true;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side) {
		return true;
	}

	public int getRenderType() {
		return BlockRenderingIDs.enderSlimeBlockRenderID;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world_, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1 - 0.0625F, z + 1);
	}
}
