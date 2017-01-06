package com.slarmods.tmnmod.block;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.tileentity.TileEntityEndWoodTable;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEndWoodTable extends BlockContainer {

	public BlockEndWoodTable(Material material) {
		super(material);
		this.setHardness(2.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks);
		this.setStepSound(soundTypeWood);
	}

	public int getRenderType() {
		return 1944;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityEndWoodTable();
	}
}
