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

package com.theslarfab.tmnmod.client.renderer.block;

import com.theslarfab.tmnmod.block.BlockEnderstoneComparator;
import com.theslarfab.tmnmod.client.renderer.BlockRenderingIDs;
import com.theslarfab.tmnmod.init.TMNBlocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderBlockEnderstoneComparator implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		int l = world.getBlockMetadata(x, y, z);
		int i1 = l & 3;
		double d0 = 0.0D;
		double d1 = -0.1875D;
		double d2 = 0.0D;
		double d3 = 0.0D;
		double d4 = 0.0D;
		IIcon iicon;

		if (BlockEnderstoneComparator.func_149969_d(l)) {
			iicon = TMNBlocks.lit_enderstone_torch.getBlockTextureFromSide(0);
		} else {
			d1 -= 0.1875D;
			iicon = TMNBlocks.unlit_enderstone_torch.getBlockTextureFromSide(0);
		}

		switch (i1) {
		case 0:
			d2 = -0.3125D;
			d4 = 1.0D;
			break;
		case 1:
			d0 = 0.3125D;
			d3 = -1.0D;
			break;
		case 2:
			d2 = 0.3125D;
			d4 = -1.0D;
			break;
		case 3:
			d0 = -0.3125D;
			d3 = 1.0D;
		}

		renderer.renderTorchAtAngle(block, (double) x + 0.25D * d3 + 0.1875D * d4, (double) ((float) y - 0.1875F),
				(double) z + 0.25D * d4 + 0.1875D * d3, 0.0D, 0.0D, l);
		renderer.renderTorchAtAngle(block, (double) x + 0.25D * d3 + -0.1875D * d4, (double) ((float) y - 0.1875F),
				(double) z + 0.25D * d4 + -0.1875D * d3, 0.0D, 0.0D, l);
		renderer.setOverrideBlockTexture(iicon);
		renderer.renderTorchAtAngle(block, (double) x + d0, (double) y + d1, (double) z + d2, 0.0D, 0.0D, l);
		renderer.clearOverrideBlockTexture();
		this.renderBlockEnderstoneDiode(block, x, y, z, renderer);
		return true;
	}

	public boolean renderBlockEnderstoneDiode(Block block, int x, int y, int z, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		this.renderBlockEnderstoneDiodeMetadata(block, x, y, z, renderer.blockAccess.getBlockMetadata(x, y, z) & 3,
				renderer);
		return true;
	}

	public void renderBlockEnderstoneDiodeMetadata(Block block, int x, int y, int z, int side, RenderBlocks renderer) {
		renderer.renderStandardBlock(block, x, y, z);
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		int i1 = renderer.blockAccess.getBlockMetadata(x, y, z);
		IIcon iicon = renderer.getBlockIconFromSideAndMetadata(block, 1, i1);
		double d0 = (double) iicon.getMinU();
		double d1 = (double) iicon.getMaxU();
		double d2 = (double) iicon.getMinV();
		double d3 = (double) iicon.getMaxV();
		double d4 = 0.125D;
		double d5 = (double) (x + 1);
		double d6 = (double) (x + 1);
		double d7 = (double) (x + 0);
		double d8 = (double) (x + 0);
		double d9 = (double) (z + 0);
		double d10 = (double) (z + 1);
		double d11 = (double) (z + 1);
		double d12 = (double) (z + 0);
		double d13 = (double) y + d4;

		if (side == 2) {
			d5 = d6 = (double) (x + 0);
			d7 = d8 = (double) (x + 1);
			d9 = d12 = (double) (z + 1);
			d10 = d11 = (double) (z + 0);
		} else if (side == 3) {
			d5 = d8 = (double) (x + 0);
			d6 = d7 = (double) (x + 1);
			d9 = d10 = (double) (z + 0);
			d11 = d12 = (double) (z + 1);
		} else if (side == 1) {
			d5 = d8 = (double) (x + 1);
			d6 = d7 = (double) (x + 0);
			d9 = d10 = (double) (z + 1);
			d11 = d12 = (double) (z + 0);
		}

		tessellator.addVertexWithUV(d8, d13, d12, d0, d2);
		tessellator.addVertexWithUV(d7, d13, d11, d0, d3);
		tessellator.addVertexWithUV(d6, d13, d10, d1, d3);
		tessellator.addVertexWithUV(d5, d13, d9, d1, d2);
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return BlockRenderingIDs.enderstoneComparatorRenderID;
	}
}
