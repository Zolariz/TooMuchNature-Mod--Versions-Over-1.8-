package com.theslarfab.tmnmod.client.renderer.block;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.block.BlockEnderPistonBase;
import com.theslarfab.tmnmod.block.BlockEnderPistonExtension;
import com.theslarfab.tmnmod.client.renderer.BlockRenderingIDs;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderBlockEnderPistonExtension implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	public boolean renderPistonExtension(Block block, int x, int y, int z, boolean renderRod, RenderBlocks renderer) {
		int l = renderer.blockAccess.getBlockMetadata(x, y, z);
		int i1 = BlockEnderPistonExtension.getDirectionMeta(l);
		float f = 0.25F;
		float f1 = 0.375F;
		float f2 = 0.625F;
		float f3 = renderRod ? 1.0F : 0.5F;
		double d0 = renderRod ? 16.0D : 8.0D;

		switch (i1) {
		case 0:
			renderer.uvRotateEast = 3;
			renderer.uvRotateWest = 3;
			renderer.uvRotateSouth = 3;
			renderer.uvRotateNorth = 3;
			renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			this.renderPistonRodUD(renderer, (double) ((float) x + 0.375F), (double) ((float) x + 0.625F),
					(double) ((float) y + 0.25F), (double) ((float) y + 0.25F + f3), (double) ((float) z + 0.625F),
					(double) ((float) z + 0.625F), 0.8F, d0);
			this.renderPistonRodUD(renderer, (double) ((float) x + 0.625F), (double) ((float) x + 0.375F),
					(double) ((float) y + 0.25F), (double) ((float) y + 0.25F + f3), (double) ((float) z + 0.375F),
					(double) ((float) z + 0.375F), 0.8F, d0);
			this.renderPistonRodUD(renderer, (double) ((float) x + 0.375F), (double) ((float) x + 0.375F),
					(double) ((float) y + 0.25F), (double) ((float) y + 0.25F + f3), (double) ((float) z + 0.375F),
					(double) ((float) z + 0.625F), 0.6F, d0);
			this.renderPistonRodUD(renderer, (double) ((float) x + 0.625F), (double) ((float) x + 0.625F),
					(double) ((float) y + 0.25F), (double) ((float) y + 0.25F + f3), (double) ((float) z + 0.625F),
					(double) ((float) z + 0.375F), 0.6F, d0);
			break;
		case 1:
			renderer.setRenderBounds(0.0D, 0.75D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			this.renderPistonRodUD(renderer, (double) ((float) x + 0.375F), (double) ((float) x + 0.625F),
					(double) ((float) y - 0.25F + 1.0F - f3), (double) ((float) y - 0.25F + 1.0F),
					(double) ((float) z + 0.625F), (double) ((float) z + 0.625F), 0.8F, d0);
			this.renderPistonRodUD(renderer, (double) ((float) x + 0.625F), (double) ((float) x + 0.375F),
					(double) ((float) y - 0.25F + 1.0F - f3), (double) ((float) y - 0.25F + 1.0F),
					(double) ((float) z + 0.375F), (double) ((float) z + 0.375F), 0.8F, d0);
			this.renderPistonRodUD(renderer, (double) ((float) x + 0.375F), (double) ((float) x + 0.375F),
					(double) ((float) y - 0.25F + 1.0F - f3), (double) ((float) y - 0.25F + 1.0F),
					(double) ((float) z + 0.375F), (double) ((float) z + 0.625F), 0.6F, d0);
			this.renderPistonRodUD(renderer, (double) ((float) x + 0.625F), (double) ((float) x + 0.625F),
					(double) ((float) y - 0.25F + 1.0F - f3), (double) ((float) y - 0.25F + 1.0F),
					(double) ((float) z + 0.625F), (double) ((float) z + 0.375F), 0.6F, d0);
			break;
		case 2:
			renderer.uvRotateSouth = 1;
			renderer.uvRotateNorth = 2;
			renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.25D);
			renderer.renderStandardBlock(block, x, y, z);
			this.renderPistonRodSN(renderer, (double) ((float) x + 0.375F), (double) ((float) x + 0.375F),
					(double) ((float) y + 0.625F), (double) ((float) y + 0.375F), (double) ((float) z + 0.25F),
					(double) ((float) z + 0.25F + f3), 0.6F, d0);
			this.renderPistonRodSN(renderer, (double) ((float) x + 0.625F), (double) ((float) x + 0.625F),
					(double) ((float) y + 0.375F), (double) ((float) y + 0.625F), (double) ((float) z + 0.25F),
					(double) ((float) z + 0.25F + f3), 0.6F, d0);
			this.renderPistonRodSN(renderer, (double) ((float) x + 0.375F), (double) ((float) x + 0.625F),
					(double) ((float) y + 0.375F), (double) ((float) y + 0.375F), (double) ((float) z + 0.25F),
					(double) ((float) z + 0.25F + f3), 0.5F, d0);
			this.renderPistonRodSN(renderer, (double) ((float) x + 0.625F), (double) ((float) x + 0.375F),
					(double) ((float) y + 0.625F), (double) ((float) y + 0.625F), (double) ((float) z + 0.25F),
					(double) ((float) z + 0.25F + f3), 1.0F, d0);
			break;
		case 3:
			renderer.uvRotateSouth = 2;
			renderer.uvRotateNorth = 1;
			renderer.uvRotateTop = 3;
			renderer.uvRotateBottom = 3;
			renderer.setRenderBounds(0.0D, 0.0D, 0.75D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			this.renderPistonRodSN(renderer, (double) ((float) x + 0.375F), (double) ((float) x + 0.375F),
					(double) ((float) y + 0.625F), (double) ((float) y + 0.375F),
					(double) ((float) z - 0.25F + 1.0F - f3), (double) ((float) z - 0.25F + 1.0F), 0.6F, d0);
			this.renderPistonRodSN(renderer, (double) ((float) x + 0.625F), (double) ((float) x + 0.625F),
					(double) ((float) y + 0.375F), (double) ((float) y + 0.625F),
					(double) ((float) z - 0.25F + 1.0F - f3), (double) ((float) z - 0.25F + 1.0F), 0.6F, d0);
			this.renderPistonRodSN(renderer, (double) ((float) x + 0.375F), (double) ((float) x + 0.625F),
					(double) ((float) y + 0.375F), (double) ((float) y + 0.375F),
					(double) ((float) z - 0.25F + 1.0F - f3), (double) ((float) z - 0.25F + 1.0F), 0.5F, d0);
			this.renderPistonRodSN(renderer, (double) ((float) x + 0.625F), (double) ((float) x + 0.375F),
					(double) ((float) y + 0.625F), (double) ((float) y + 0.625F),
					(double) ((float) z - 0.25F + 1.0F - f3), (double) ((float) z - 0.25F + 1.0F), 1.0F, d0);
			break;
		case 4:
			renderer.uvRotateEast = 1;
			renderer.uvRotateWest = 2;
			renderer.uvRotateTop = 2;
			renderer.uvRotateBottom = 1;
			renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 0.25D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			this.renderPistonRodEW(renderer, (double) ((float) x + 0.25F), (double) ((float) x + 0.25F + f3),
					(double) ((float) y + 0.375F), (double) ((float) y + 0.375F), (double) ((float) z + 0.625F),
					(double) ((float) z + 0.375F), 0.5F, d0);
			this.renderPistonRodEW(renderer, (double) ((float) x + 0.25F), (double) ((float) x + 0.25F + f3),
					(double) ((float) y + 0.625F), (double) ((float) y + 0.625F), (double) ((float) z + 0.375F),
					(double) ((float) z + 0.625F), 1.0F, d0);
			this.renderPistonRodEW(renderer, (double) ((float) x + 0.25F), (double) ((float) x + 0.25F + f3),
					(double) ((float) y + 0.375F), (double) ((float) y + 0.625F), (double) ((float) z + 0.375F),
					(double) ((float) z + 0.375F), 0.6F, d0);
			this.renderPistonRodEW(renderer, (double) ((float) x + 0.25F), (double) ((float) x + 0.25F + f3),
					(double) ((float) y + 0.625F), (double) ((float) y + 0.375F), (double) ((float) z + 0.625F),
					(double) ((float) z + 0.625F), 0.6F, d0);
			break;
		case 5:
			renderer.uvRotateEast = 2;
			renderer.uvRotateWest = 1;
			renderer.uvRotateTop = 1;
			renderer.uvRotateBottom = 2;
			renderer.setRenderBounds(0.75D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			this.renderPistonRodEW(renderer, (double) ((float) x - 0.25F + 1.0F - f3),
					(double) ((float) x - 0.25F + 1.0F), (double) ((float) y + 0.375F), (double) ((float) y + 0.375F),
					(double) ((float) z + 0.625F), (double) ((float) z + 0.375F), 0.5F, d0);
			this.renderPistonRodEW(renderer, (double) ((float) x - 0.25F + 1.0F - f3),
					(double) ((float) x - 0.25F + 1.0F), (double) ((float) y + 0.625F), (double) ((float) y + 0.625F),
					(double) ((float) z + 0.375F), (double) ((float) z + 0.625F), 1.0F, d0);
			this.renderPistonRodEW(renderer, (double) ((float) x - 0.25F + 1.0F - f3),
					(double) ((float) x - 0.25F + 1.0F), (double) ((float) y + 0.375F), (double) ((float) y + 0.625F),
					(double) ((float) z + 0.375F), (double) ((float) z + 0.375F), 0.6F, d0);
			this.renderPistonRodEW(renderer, (double) ((float) x - 0.25F + 1.0F - f3),
					(double) ((float) x - 0.25F + 1.0F), (double) ((float) y + 0.625F), (double) ((float) y + 0.375F),
					(double) ((float) z + 0.625F), (double) ((float) z + 0.625F), 0.6F, d0);
		}

		renderer.uvRotateEast = 0;
		renderer.uvRotateWest = 0;
		renderer.uvRotateSouth = 0;
		renderer.uvRotateNorth = 0;
		renderer.uvRotateTop = 0;
		renderer.uvRotateBottom = 0;
		renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		return true;
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		renderer.renderAllFaces = true;
		boolean renderRod = true;
		this.renderPistonExtension(block, x, y, z, renderRod, renderer);
		renderer.renderAllFaces = false;
		return true;
	}

	public void renderPistonRodUD(RenderBlocks renderer, double p_147763_1_, double p_147763_3_, double p_147763_5_,
			double p_147763_7_, double p_147763_9_, double p_147763_11_, float p_147763_13_, double p_147763_14_) {
		IIcon iicon = BlockEnderPistonBase.getPistonBaseIcon(TooMuchNature.modid + ":" + "ender_piston_side");

		if (renderer.hasOverrideBlockTexture()) {
			iicon = renderer.overrideBlockTexture;
		}

		Tessellator tessellator = Tessellator.instance;
		double d7 = (double) iicon.getMinU();
		double d8 = (double) iicon.getMinV();
		double d9 = (double) iicon.getInterpolatedU(p_147763_14_);
		double d10 = (double) iicon.getInterpolatedV(4.0D);
		tessellator.setColorOpaque_F(p_147763_13_, p_147763_13_, p_147763_13_);
		tessellator.addVertexWithUV(p_147763_1_, p_147763_7_, p_147763_9_, d9, d8);
		tessellator.addVertexWithUV(p_147763_1_, p_147763_5_, p_147763_9_, d7, d8);
		tessellator.addVertexWithUV(p_147763_3_, p_147763_5_, p_147763_11_, d7, d10);
		tessellator.addVertexWithUV(p_147763_3_, p_147763_7_, p_147763_11_, d9, d10);
	}

	public void renderPistonRodSN(RenderBlocks renderer, double p_147789_1_, double p_147789_3_, double p_147789_5_,
			double p_147789_7_, double p_147789_9_, double p_147789_11_, float p_147789_13_, double p_147789_14_) {
		IIcon iicon = BlockEnderPistonBase.getPistonBaseIcon(TooMuchNature.modid + ":" + "ender_piston_side");

		if (renderer.hasOverrideBlockTexture()) {
			iicon = renderer.overrideBlockTexture;
		}

		Tessellator tessellator = Tessellator.instance;
		double d7 = (double) iicon.getMinU();
		double d8 = (double) iicon.getMinV();
		double d9 = (double) iicon.getInterpolatedU(p_147789_14_);
		double d10 = (double) iicon.getInterpolatedV(4.0D);
		tessellator.setColorOpaque_F(p_147789_13_, p_147789_13_, p_147789_13_);
		tessellator.addVertexWithUV(p_147789_1_, p_147789_5_, p_147789_11_, d9, d8);
		tessellator.addVertexWithUV(p_147789_1_, p_147789_5_, p_147789_9_, d7, d8);
		tessellator.addVertexWithUV(p_147789_3_, p_147789_7_, p_147789_9_, d7, d10);
		tessellator.addVertexWithUV(p_147789_3_, p_147789_7_, p_147789_11_, d9, d10);
	}

	public void renderPistonRodEW(RenderBlocks renderer, double p_147738_1_, double p_147738_3_, double p_147738_5_,
			double p_147738_7_, double p_147738_9_, double p_147738_11_, float p_147738_13_, double p_147738_14_) {
		IIcon iicon = BlockEnderPistonBase.getPistonBaseIcon(TooMuchNature.modid + ":" + "ender_piston_side");

		if (renderer.hasOverrideBlockTexture()) {
			iicon = renderer.overrideBlockTexture;
		}

		Tessellator tessellator = Tessellator.instance;
		double d7 = (double) iicon.getMinU();
		double d8 = (double) iicon.getMinV();
		double d9 = (double) iicon.getInterpolatedU(p_147738_14_);
		double d10 = (double) iicon.getInterpolatedV(4.0D);
		tessellator.setColorOpaque_F(p_147738_13_, p_147738_13_, p_147738_13_);
		tessellator.addVertexWithUV(p_147738_3_, p_147738_5_, p_147738_9_, d9, d8);
		tessellator.addVertexWithUV(p_147738_1_, p_147738_5_, p_147738_9_, d7, d8);
		tessellator.addVertexWithUV(p_147738_1_, p_147738_7_, p_147738_11_, d7, d10);
		tessellator.addVertexWithUV(p_147738_3_, p_147738_7_, p_147738_11_, d9, d10);
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return BlockRenderingIDs.enderPistonExtensionRenderID;
	}

}
