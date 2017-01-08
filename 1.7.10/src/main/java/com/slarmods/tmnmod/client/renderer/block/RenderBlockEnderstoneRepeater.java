/**
	Copyright (C) <2016>  <TheSlarFab>

    This file is part of the TheSlarFab TooMuchNatventure Mod; as such, 
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

// Ugghhhh! Screw dis!

package com.slarmods.tmnmod.client.renderer.block;

import com.slarmods.tmnmod.block.BlockEnderstoneDiode;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderBlockEnderstoneRepeater implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
		int l = world.getBlockMetadata(x, y, z);
		int i1 = l & 3;
		int j1 = (l & 12) >> 2;
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		double d0 = -0.1875D;
		boolean flag = ((BlockEnderstoneDiode) block).func_149910_g(world, x, y, z, l);
		double d1 = 0.0D;
		double d2 = 0.0D;
		double d3 = 0.0D;
		double d4 = 0.0D;

		switch (i1) {
		case 0:
			d4 = -0.3125D;
			d2 = BlockRedstoneRepeater.repeaterTorchOffset[j1];
			break;
		case 1:
			d3 = 0.3125D;
			d1 = -BlockRedstoneRepeater.repeaterTorchOffset[j1];
			break;
		case 2:
			d4 = 0.3125D;
			d2 = -BlockRedstoneRepeater.repeaterTorchOffset[j1];
			break;
		case 3:
			d3 = -0.3125D;
			d1 = BlockRedstoneRepeater.repeaterTorchOffset[j1];
		}

		if (!flag) {
			renderer.renderTorchAtAngle(block, (double) x + d1, (double) y + d0, (double) z + d2, 0.0D, 0.0D, 0);
		} else {
			IIcon iicon = renderer.getBlockIcon(Blocks.bedrock);
			renderer.setOverrideBlockTexture(iicon);
			float f = 2.0F;
			float f1 = 14.0F;
			float f2 = 7.0F;
			float f3 = 9.0F;

			switch (i1) {
			case 1:
			case 3:
				f = 7.0F;
				f1 = 9.0F;
				f2 = 2.0F;
				f3 = 14.0F;
			case 0:
			case 2:
			default:
				renderer.setRenderBounds((double) (f / 16.0F + (float) d1), 0.125D, (double) (f2 / 16.0F + (float) d2),
						(double) (f1 / 16.0F + (float) d1), 0.25D, (double) (f3 / 16.0F + (float) d2));
				double d5 = (double) iicon.getInterpolatedU((double) f);
				double d6 = (double) iicon.getInterpolatedV((double) f2);
				double d7 = (double) iicon.getInterpolatedU((double) f1);
				double d8 = (double) iicon.getInterpolatedV((double) f3);
				tessellator.addVertexWithUV((double) ((float) x + f / 16.0F) + d1, (double) ((float) y + 0.25F),
						(double) ((float) z + f2 / 16.0F) + d2, d5, d6);
				tessellator.addVertexWithUV((double) ((float) x + f / 16.0F) + d1, (double) ((float) y + 0.25F),
						(double) ((float) z + f3 / 16.0F) + d2, d5, d8);
				tessellator.addVertexWithUV((double) ((float) x + f1 / 16.0F) + d1, (double) ((float) y + 0.25F),
						(double) ((float) z + f3 / 16.0F) + d2, d7, d8);
				tessellator.addVertexWithUV((double) ((float) x + f1 / 16.0F) + d1, (double) ((float) y + 0.25F),
						(double) ((float) z + f2 / 16.0F) + d2, d7, d6);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
				renderer.clearOverrideBlockTexture();
			}
		}

		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		renderer.renderTorchAtAngle(block, (double) x + d3, (double) y + d0, (double) z + d4, 0.0D, 0.0D, 0);
		// this.renderBlockRedstoneDiode(block, x, y, z);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return 1943;
	}

}
