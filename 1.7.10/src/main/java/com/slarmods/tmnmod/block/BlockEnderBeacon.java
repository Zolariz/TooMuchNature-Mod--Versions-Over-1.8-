package com.slarmods.tmnmod.block;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.client.renderer.BlockRenderingIDs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.World;

public class BlockEnderBeacon extends BlockContainer {

	public BlockEnderBeacon() {
		super(Material.glass);
		this.setHardness(3.0F);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks);
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityBeacon();
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_,
			EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if (p_149727_1_.isRemote) {
			return true;
		} else {
			TileEntityBeacon tileentitybeacon = (TileEntityBeacon) p_149727_1_.getTileEntity(p_149727_2_, p_149727_3_,
					p_149727_4_);

			if (tileentitybeacon != null) {
				p_149727_5_.func_146104_a(tileentitybeacon);
			}

			return true;
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return BlockRenderingIDs.enderBeaconRenderID;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		super.registerBlockIcons(iconRegister);
	}

	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_,
			EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
		super.onBlockPlacedBy(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_, p_149689_6_);

		if (p_149689_6_.hasDisplayName()) {
			((TileEntityBeacon) p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_))
					.func_145999_a(p_149689_6_.getDisplayName());
		}
	}
}
