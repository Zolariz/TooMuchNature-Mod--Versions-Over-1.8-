package com.slarmods.tmnmod.block;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.tileentity.TileEntityEndWoodTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEndWoodTable extends Block {

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
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side) {
		return true;
	}
	
	@SideOnly(Side.CLIENT)
    public String getItemIconName()
    {
        return TooMuchNature.modid + ":" + "end_wood_table";
    }
}
