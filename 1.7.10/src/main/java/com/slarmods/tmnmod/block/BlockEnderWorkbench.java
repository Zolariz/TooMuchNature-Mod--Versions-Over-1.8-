package com.slarmods.tmnmod.block;

import com.slarmods.tmnmod.TooMuchNature;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockEnderWorkbench extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	@SideOnly(Side.CLIENT)
	private IIcon frontIcon;

	public BlockEnderWorkbench() {
		super(Material.wood);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.topIcon
				: (side == 0 ? TMNBlocks.end_wood_planks.getBlockTextureFromSide(side)
						: (side != 2 && side != 4 ? this.blockIcon : this.frontIcon));
	}

	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(TooMuchNature.modid + ":" + "ender_workbench_side");
		this.topIcon = iconRegister.registerIcon(TooMuchNature.modid + ":" + "ender_workbench_top");
		this.frontIcon = iconRegister.registerIcon(TooMuchNature.modid + ":" + "ender_workbench_front");
	}

	/*
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int q, float hitX,
			float hitY, float hitZ) {

		if (!player.isSneaking()) {
			player.openGui(TooMuchNature.instance, TooMuchNature.guiIDEnderWorkbench, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}
	*/
}
