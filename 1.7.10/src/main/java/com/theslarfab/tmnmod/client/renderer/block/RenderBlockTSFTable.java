package com.theslarfab.tmnmod.client.renderer.block;

import org.lwjgl.opengl.GL11;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.block.BlockEndWoodTable;
import com.theslarfab.tmnmod.init.TMNBlocks;

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

public class RenderBlockTSFTable implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

		int k;
		Tessellator tessellator = Tessellator.instance;
		for (k = 0; k < 5; ++k) {
			if (k == 0) {
				renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
				renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
			} else if (k == 1) {
				renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
				renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
			} else if (k == 2) {
				renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
				renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
			} else if (k == 3) {
				renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
				renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
			} else if (k == 4) {
				renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
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
		if (metadata == 0) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 0));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 0));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 0));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 0));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 0));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 1) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 1));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 1));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 1));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 1));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 1));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 2) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 2));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 2));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 2));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 2));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 2));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 3) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 3));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 3));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 3));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 3));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 3));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 4) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 4));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 4));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 4));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 4));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 4));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 5) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 5));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 5));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 5));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 5));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 5));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 6) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 6));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 6));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 6));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 6));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 6));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 7) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 7));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 7));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 7));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 7));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 7));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 8) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 8));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 8));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 8));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 8));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 8));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 9) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 9));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 9));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 9));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 9));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 9));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 10) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 10));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 10));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 10));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 10));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 10));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 11) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 11));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 11));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 11));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 11));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 11));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 12) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 12));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 12));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 12));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 12));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 12));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 13) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 13));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 13));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 13));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 13));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 13));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 14) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 14));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 14));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 14));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 14));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 14));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		if (metadata == 15) {
			/** Platform of Table */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 15));
			renderer.setRenderBounds(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 1 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 15));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.0625D, 0.1875D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 2 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 15));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.8125D, 0.9375D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 3 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 15));
			renderer.setRenderBounds(0.8125D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.1875D);
			renderer.renderStandardBlock(block, x, y, z);
			/** Table Leg 4 */
			renderer.setOverrideBlockTexture(renderer.getBlockIconFromSideAndMetadata(block, 0, 15));
			renderer.setRenderBounds(0.0625D, 0.0D, 0.8125D, 0.1875D, 0.8125D, 0.9375D);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
		}
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return BlockRenderingIDs.tsfTableRenderID;
	}

}
