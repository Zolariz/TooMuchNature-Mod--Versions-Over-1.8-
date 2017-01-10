package com.slarmods.tmnmod.client.renderer.block;

import org.lwjgl.opengl.GL11;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.block.BlockEndWoodTable;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class RenderBlockEndPlanksTable implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		int l = world.getBlockMetadata(x, y, z);
		switch (l) {
		case 0:
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(TooMuchNature.end_wood_planks));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(TooMuchNature.end_wood_planks));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(TooMuchNature.end_wood_planks));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(TooMuchNature.end_wood_planks));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(TooMuchNature.end_wood_planks));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			break;
		case 1:
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(Blocks.diamond_block));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(Blocks.diamond_block));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(Blocks.diamond_block));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(Blocks.diamond_block));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIcon(Blocks.diamond_block));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			break;
		}

		renderer.clearOverrideBlockTexture();
		return true;
	}

	public boolean renderEndWoodTableMetadata(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return 1944;
	}

}
