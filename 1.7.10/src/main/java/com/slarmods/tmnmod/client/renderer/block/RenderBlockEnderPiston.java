package com.slarmods.tmnmod.client.renderer.block;

import org.lwjgl.opengl.GL11;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.block.BlockEnderPistonBase;
import com.slarmods.tmnmod.block.BlockEnderPistonExtension;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.src.FMLRenderAccessLibrary;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderBlockEnderPiston implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		
	}

	public boolean renderPistonBase(Block block, int x, int y, int z, boolean p_147731_5_, RenderBlocks renderer) {
		int l = renderer.blockAccess.getBlockMetadata(x, y, z);
		boolean flag1 = (l & 8) != 0;
		int i1 = BlockEnderPistonBase.getPistonOrientation(l);
		float f = 0.25F;

		if (flag1) {
			switch (i1) {
			case 0:
				renderer.uvRotateEast = 3;
				renderer.uvRotateWest = 3;
				renderer.uvRotateSouth = 3;
				renderer.uvRotateNorth = 3;
				renderer.setRenderBounds(0.0D, 0.25D, 0.0D, 1.0D, 1.0D, 1.0D);
				break;
			case 1:
				renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
				break;
			case 2:
				renderer.uvRotateSouth = 1;
				renderer.uvRotateNorth = 2;
				renderer.setRenderBounds(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D);
				break;
			case 3:
				renderer.uvRotateSouth = 2;
				renderer.uvRotateNorth = 1;
				renderer.uvRotateTop = 3;
				renderer.uvRotateBottom = 3;
				renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D);
				break;
			case 4:
				renderer.uvRotateEast = 1;
				renderer.uvRotateWest = 2;
				renderer.uvRotateTop = 2;
				renderer.uvRotateBottom = 1;
				renderer.setRenderBounds(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
				break;
			case 5:
				renderer.uvRotateEast = 2;
				renderer.uvRotateWest = 1;
				renderer.uvRotateTop = 1;
				renderer.uvRotateBottom = 2;
				renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D);
			}

			((BlockEnderPistonBase) block).func_150070_b((float) renderer.renderMinX, (float) renderer.renderMinY,
					(float) renderer.renderMinZ, (float) renderer.renderMaxX, (float) renderer.renderMaxY,
					(float) renderer.renderMaxZ);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.uvRotateEast = 0;
			renderer.uvRotateWest = 0;
			renderer.uvRotateSouth = 0;
			renderer.uvRotateNorth = 0;
			renderer.uvRotateTop = 0;
			renderer.uvRotateBottom = 0;
			renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
			((BlockEnderPistonBase) block).func_150070_b((float) renderer.renderMinX, (float) renderer.renderMinY,
					(float) renderer.renderMinZ, (float) renderer.renderMaxX, (float) renderer.renderMaxY,
					(float) renderer.renderMaxZ);
		} else {
			switch (i1) {
			case 0:
				renderer.uvRotateEast = 3;
				renderer.uvRotateWest = 3;
				renderer.uvRotateSouth = 3;
				renderer.uvRotateNorth = 3;
			case 1:
			default:
				break;
			case 2:
				renderer.uvRotateSouth = 1;
				renderer.uvRotateNorth = 2;
				break;
			case 3:
				renderer.uvRotateSouth = 2;
				renderer.uvRotateNorth = 1;
				renderer.uvRotateTop = 3;
				renderer.uvRotateBottom = 3;
				break;
			case 4:
				renderer.uvRotateEast = 1;
				renderer.uvRotateWest = 2;
				renderer.uvRotateTop = 2;
				renderer.uvRotateBottom = 1;
				break;
			case 5:
				renderer.uvRotateEast = 2;
				renderer.uvRotateWest = 1;
				renderer.uvRotateTop = 1;
				renderer.uvRotateBottom = 2;
			}

			renderer.renderStandardBlock(block, x, y, z);
			renderer.uvRotateEast = 0;
			renderer.uvRotateWest = 0;
			renderer.uvRotateSouth = 0;
			renderer.uvRotateNorth = 0;
			renderer.uvRotateTop = 0;
			renderer.uvRotateBottom = 0;
		}

		return true;
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		renderer.renderAllFaces = true;
		boolean renderAll = true;
		renderPistonBase(block, x, y, z, renderAll, renderer);
		renderer.renderAllFaces = false;
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return 1946;
	}
}
