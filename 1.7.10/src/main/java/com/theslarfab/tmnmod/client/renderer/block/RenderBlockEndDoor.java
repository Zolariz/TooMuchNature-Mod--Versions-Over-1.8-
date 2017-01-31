package com.theslarfab.tmnmod.client.renderer.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderBlockEndDoor implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		Tessellator tessellator = Tessellator.instance;
		int l = world.getBlockMetadata(x, y, z);

		if ((l & 8) != 0) {
			if (world.getBlock(x, y - 1, z) != block) {
				return false;
			}
		} else if (world.getBlock(x, y + 1, z) != block) {
			return false;
		}

		boolean flag = false;
		float f = 0.5F;
		float f1 = 1.0F;
		float f2 = 0.8F;
		float f3 = 0.6F;
		int i1 = block.getMixedBrightnessForBlock(world, x, y, z);
		tessellator
				.setBrightness(renderer.renderMinY > 0.0D ? i1 : block.getMixedBrightnessForBlock(world, x, y - 1, z));
		tessellator.setColorOpaque_F(f, f, f);
		renderer.renderFaceYNeg(block, (double) x, (double) y, (double) z,
				renderer.getBlockIcon(block, world, x, y, z, 0));
		flag = true;
		tessellator
				.setBrightness(renderer.renderMaxY < 1.0D ? i1 : block.getMixedBrightnessForBlock(world, x, y + 1, z));
		tessellator.setColorOpaque_F(f1, f1, f1);
		renderer.renderFaceYPos(block, (double) x, (double) y, (double) z,
				renderer.getBlockIcon(block, world, x, y, z, 1));
		flag = true;
		tessellator
				.setBrightness(renderer.renderMinZ > 0.0D ? i1 : block.getMixedBrightnessForBlock(world, x, y, z - 1));
		tessellator.setColorOpaque_F(f2, f2, f2);
		IIcon iicon = renderer.getBlockIcon(block, world, x, y, z, 2);
		renderer.renderFaceZNeg(block, (double) x, (double) y, (double) z, iicon);
		flag = true;
		renderer.flipTexture = false;
		tessellator
				.setBrightness(renderer.renderMaxZ < 1.0D ? i1 : block.getMixedBrightnessForBlock(world, x, y, z + 1));
		tessellator.setColorOpaque_F(f2, f2, f2);
		iicon = renderer.getBlockIcon(block, world, x, y, z, 3);
		renderer.renderFaceZPos(block, (double) x, (double) y, (double) z, iicon);
		flag = true;
		renderer.flipTexture = false;
		tessellator
				.setBrightness(renderer.renderMinX > 0.0D ? i1 : block.getMixedBrightnessForBlock(world, x - 1, y, z));
		tessellator.setColorOpaque_F(f3, f3, f3);
		iicon = renderer.getBlockIcon(block, world, x, y, z, 4);
		renderer.renderFaceXNeg(block, (double) x, (double) y, (double) z, iicon);
		flag = true;
		renderer.flipTexture = false;
		tessellator
				.setBrightness(renderer.renderMaxX < 1.0D ? i1 : block.getMixedBrightnessForBlock(world, x + 1, y, z));
		tessellator.setColorOpaque_F(f3, f3, f3);
		iicon = renderer.getBlockIcon(block, world, x, y, z, 5);
		renderer.renderFaceXPos(block, (double) x, (double) y, (double) z, iicon);
		flag = true;
		renderer.flipTexture = false;
		return flag;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return BlockRenderingIDs.endDoorRenderID;
	}

}
