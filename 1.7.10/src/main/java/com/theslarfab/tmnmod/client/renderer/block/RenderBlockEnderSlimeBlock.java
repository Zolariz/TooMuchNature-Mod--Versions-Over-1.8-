package com.theslarfab.tmnmod.client.renderer.block;

import org.lwjgl.opengl.GL11;

import com.theslarfab.tmnmod.init.TMNBlocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class RenderBlockEnderSlimeBlock implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

		int k;
		Tessellator tessellator = Tessellator.instance;
		for (k = 0; k < 2; ++k) {
			if (k == 0) {
				renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
				renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
			} else if (k == 1) {
				renderer.setRenderBounds(0.1875D, 0.1875D, 0.1875D, 0.8125D, 0.8125D, 0.8125D);
				renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
			}

			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, -1.0F, 0.0F);
			renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D,
					renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 1.0F, 0.0F);
			renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D,
					renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 0.0F, -1.0F);
			renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D,
					renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 0.0F, 1.0F);
			renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D,
					renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(-1.0F, 0.0F, 0.0F);
			renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D,
					renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D,
					renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
			tessellator.draw();
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		}

		renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		renderer.clearOverrideBlockTexture();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		int metadata = world.getBlockMetadata(x, y, z);
		renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
		renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.renderAllFaces = true;
		renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
		renderer.setRenderBounds(0.1875D, 0.1875D, 0.1875D, 0.8125D, 0.8125D, 0.8125D);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.renderAllFaces = false;
		renderer.clearOverrideBlockTexture();
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return BlockRenderingIDs.enderSlimeBlockRenderID;
	}
}
