package com.theslarfab.tmnmod.client.renderer.block;

import com.theslarfab.tmnmod.client.renderer.BlockRenderingIDs;
import com.theslarfab.tmnmod.init.TMNBlocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class RenderBlockEnderSlimeBlock implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		renderer.setOverrideBlockTexture(renderer.getBlockIcon(TMNBlocks.ender_slime_block));
		renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.renderAllFaces = true;
		renderer.setOverrideBlockTexture(renderer.getBlockIcon(TMNBlocks.ender_slime_block));
		renderer.setRenderBounds(0.2D, 0.2D, 0.2D, 0.8D, 0.8D, 0.8D);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.renderAllFaces = false;
		renderer.clearOverrideBlockTexture();
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return BlockRenderingIDs.enderSlimeBlockRenderID;
	}
}
