package com.slarmods.tmnmod.block;

import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import static net.minecraftforge.common.EnumPlantType.*;

public class BlockTMNBush extends Block implements IPlantable {

	protected BlockTMNBush(Material material) {
		super(material);
		this.setTickRandomly(true);
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks);
	}

	protected BlockTMNBush() {
		this(Material.plants);
	}

	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
		return super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_)
				&& this.canBlockStay(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
	}

	protected boolean canPlaceBlockOn(Block block) {
		return block == Blocks.grass || block == TMNBlocks.cherry_grass || block == Blocks.dirt
				|| block == Blocks.farmland;
	}

	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_,
			Block p_149695_5_) {
		super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
		this.checkAndDropBlock(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
	}

	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
		this.checkAndDropBlock(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
	}

	protected void checkAndDropBlock(World p_149855_1_, int p_149855_2_, int p_149855_3_, int p_149855_4_) {
		if (!this.canBlockStay(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_)) {
			this.dropBlockAsItem(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_,
					p_149855_1_.getBlockMetadata(p_149855_2_, p_149855_3_, p_149855_4_), 0);
			p_149855_1_.setBlock(p_149855_2_, p_149855_3_, p_149855_4_, getBlockById(0), 0, 2);
		}
	}

	public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
		return p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_).canSustainPlant(p_149718_1_, p_149718_2_,
				p_149718_3_ - 1, p_149718_4_, ForgeDirection.UP, this);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_,
			int p_149668_4_) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 1;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		if (this == Blocks.wheat)
			return Crop;
		if (this == Blocks.carrots)
			return Crop;
		if (this == Blocks.potatoes)
			return Crop;
		if (this == Blocks.melon_stem)
			return Crop;
		if (this == Blocks.pumpkin_stem)
			return Crop;
		if (this == Blocks.waterlily)
			return Water;
		if (this == Blocks.nether_wart)
			return Nether;
		if (this == Blocks.sapling)
			return Plains;
		if (this == TMNBlocks.cherry_sapling)
			return Plains;
		if (this == TMNBlocks.crops_cherry)
			return Crop;
		return Plains;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return this;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}
}