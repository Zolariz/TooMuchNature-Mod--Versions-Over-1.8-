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

		RenderBlockEnderstoneDiode rbediode = new RenderBlockEnderstoneDiode();
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
		rbediode.renderWorldBlock(world, x, y, z, block, modelId, renderer);
		return true;
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
