package com.slarmods.tmnmod.client.renderer.block;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.block.BlockEndFire;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderBlockEndFire implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block par1Block, int par2, int par3, RenderBlocks par4) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess blockAccess, int par2, int par3, int par4, Block par1Block,
			int modelId, RenderBlocks renderer) {
		if (par1Block == TooMuchNature.end_fire) {
			Tessellator tessellator = Tessellator.instance;
			BlockEndFire endFire = (BlockEndFire) par1Block;
			IIcon icon = endFire.getFireIcon(0);
			IIcon icon1 = endFire.getFireIcon(1);
			IIcon icon2 = icon;
			if (renderer.hasOverrideBlockTexture()) {
				icon2 = renderer.overrideBlockTexture;
			}
			tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
			tessellator.setBrightness(par1Block.getMixedBrightnessForBlock(renderer.blockAccess, par2, par3, par4));
			double d0 = icon2.getMinU();
			double d1 = icon2.getMinV();
			double d2 = icon2.getMaxU();
			double d3 = icon2.getMaxV();
			float f = 1.4F;

			double d12 = par2 + 0.5D + 0.2D;
			double d4 = par2 + 0.5D - 0.2D;
			double d5 = par4 + 0.5D + 0.2D;
			double d6 = par4 + 0.5D - 0.2D;
			double d7 = par2 + 0.5D - 0.3D;
			double d8 = par2 + 0.5D + 0.3D;
			double d9 = par4 + 0.5D - 0.3D;
			double d10 = par4 + 0.5D + 0.3D;
			tessellator.addVertexWithUV(d7, par3 + f, par4 + 1, d2, d1);
			tessellator.addVertexWithUV(d12, par3 + 0, par4 + 1, d2, d3);
			tessellator.addVertexWithUV(d12, par3 + 0, par4 + 0, d0, d3);
			tessellator.addVertexWithUV(d7, par3 + f, par4 + 0, d0, d1);
			tessellator.addVertexWithUV(d8, par3 + f, par4 + 0, d2, d1);
			tessellator.addVertexWithUV(d4, par3 + 0, par4 + 0, d2, d3);
			tessellator.addVertexWithUV(d4, par3 + 0, par4 + 1, d0, d3);
			tessellator.addVertexWithUV(d8, par3 + f, par4 + 1, d0, d1);
			d0 = icon1.getMinU();
			d1 = icon1.getMinV();
			d2 = icon1.getMaxU();
			d3 = icon1.getMaxV();
			tessellator.addVertexWithUV(par2 + 1, par3 + f, d10, d2, d1);
			tessellator.addVertexWithUV(par2 + 1, par3 + 0, d6, d2, d3);
			tessellator.addVertexWithUV(par2 + 0, par3 + 0, d6, d0, d3);
			tessellator.addVertexWithUV(par2 + 0, par3 + f, d10, d0, d1);
			tessellator.addVertexWithUV(par2 + 0, par3 + f, d9, d2, d1);
			tessellator.addVertexWithUV(par2 + 0, par3 + 0, d5, d2, d3);
			tessellator.addVertexWithUV(par2 + 1, par3 + 0, d5, d0, d3);
			tessellator.addVertexWithUV(par2 + 1, par3 + f, d9, d0, d1);
			d12 = par2 + 0.5D - 0.5D;
			d4 = par2 + 0.5D + 0.5D;
			d5 = par4 + 0.5D - 0.5D;
			d6 = par4 + 0.5D + 0.5D;
			d7 = par2 + 0.5D - 0.4D;
			d8 = par2 + 0.5D + 0.4D;
			d9 = par4 + 0.5D - 0.4D;
			d10 = par4 + 0.5D + 0.4D;
			tessellator.addVertexWithUV(d7, par3 + f, par4 + 0, d0, d1);
			tessellator.addVertexWithUV(d12, par3 + 0, par4 + 0, d0, d3);
			tessellator.addVertexWithUV(d12, par3 + 0, par4 + 1, d2, d3);
			tessellator.addVertexWithUV(d7, par3 + f, par4 + 1, d2, d1);
			tessellator.addVertexWithUV(d8, par3 + f, par4 + 1, d0, d1);
			tessellator.addVertexWithUV(d4, par3 + 0, par4 + 1, d0, d3);
			tessellator.addVertexWithUV(d4, par3 + 0, par4 + 0, d2, d3);
			tessellator.addVertexWithUV(d8, par3 + f, par4 + 0, d2, d1);
			d0 = icon.getMinU();
			d1 = icon.getMinV();
			d2 = icon.getMaxU();
			d3 = icon.getMaxV();
			tessellator.addVertexWithUV(par2 + 0, par3 + f, d10, d0, d1);
			tessellator.addVertexWithUV(par2 + 0, par3 + 0, d6, d0, d3);
			tessellator.addVertexWithUV(par2 + 1, par3 + 0, d6, d2, d3);
			tessellator.addVertexWithUV(par2 + 1, par3 + f, d10, d2, d1);
			tessellator.addVertexWithUV(par2 + 1, par3 + f, d9, d0, d1);
			tessellator.addVertexWithUV(par2 + 1, par3 + 0, d5, d0, d3);
			tessellator.addVertexWithUV(par2 + 0, par3 + 0, d5, d2, d3);
			tessellator.addVertexWithUV(par2 + 0, par3 + f, d9, d2, d1);

			return true;
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return 1940;
	}
}
