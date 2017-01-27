package com.theslarfab.tmnmod.block;

import com.theslarfab.tmnmod.client.renderer.BlockRenderingIDs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEnderSlime extends Block {

	public BlockEnderSlime() {
		super(Material.cloth);
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public int getRenderType() {
		return BlockRenderingIDs.enderSlimeBlockRenderID;
	}
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
}
