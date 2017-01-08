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

package com.slarmods.tmnmod.client.renderer.block;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.block.BlockEndFire;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class RenderBlockEndFire implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block par1Block, int par2, int par3, RenderBlocks par4) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
		BlockEndFire blockEndFire = (BlockEndFire) block;
		Tessellator tessellator = Tessellator.instance;
		IIcon iicon = blockEndFire.getFireIcon(0);
		IIcon iicon1 = blockEndFire.getFireIcon(1);
		IIcon iicon2 = iicon;
		boolean rendered = false;

		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		tessellator.setBrightness(blockEndFire.getMixedBrightnessForBlock(world, x, y, z));
		double d0 = iicon2.getMinU();
		double d1 = iicon2.getMinV();
		double d2 = iicon2.getMaxU();
		double d3 = iicon2.getMaxV();
		float f = 1.4F;
		if ((!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z))
				&& (!((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x, y - 1, z, ForgeDirection.UP))) {
			float f2 = 0.2F;
			float f1 = 0.0625F;
			if ((x + y + z & 0x1) == 1) {
				d0 = iicon1.getMinU();
				d1 = iicon1.getMinV();
				d2 = iicon1.getMaxU();
				d3 = iicon1.getMaxV();
			}
			if ((x / 2 + y / 2 + z / 2 & 0x1) == 1) {
				double d5 = d2;
				d2 = d0;
				d0 = d5;
			}
			if (((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x - 1, y, z, ForgeDirection.EAST)) {
				tessellator.addVertexWithUV(x + f2, y + f + f1, z + 1, d2, d1);
				tessellator.addVertexWithUV(x + 0, y + 0 + f1, z + 1, d2, d3);
				tessellator.addVertexWithUV(x + 0, y + 0 + f1, z + 0, d0, d3);
				tessellator.addVertexWithUV(x + f2, y + f + f1, z + 0, d0, d1);
				tessellator.addVertexWithUV(x + f2, y + f + f1, z + 0, d0, d1);
				tessellator.addVertexWithUV(x + 0, y + 0 + f1, z + 0, d0, d3);
				tessellator.addVertexWithUV(x + 0, y + 0 + f1, z + 1, d2, d3);
				tessellator.addVertexWithUV(x + f2, y + f + f1, z + 1, d2, d1);
				rendered = true;
			}
			if (((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x + 1, y, z, ForgeDirection.WEST)) {
				tessellator.addVertexWithUV(x + 1 - f2, y + f + f1, z + 0, d0, d1);
				tessellator.addVertexWithUV(x + 1 - 0, y + 0 + f1, z + 0, d0, d3);
				tessellator.addVertexWithUV(x + 1 - 0, y + 0 + f1, z + 1, d2, d3);
				tessellator.addVertexWithUV(x + 1 - f2, y + f + f1, z + 1, d2, d1);
				tessellator.addVertexWithUV(x + 1 - f2, y + f + f1, z + 1, d2, d1);
				tessellator.addVertexWithUV(x + 1 - 0, y + 0 + f1, z + 1, d2, d3);
				tessellator.addVertexWithUV(x + 1 - 0, y + 0 + f1, z + 0, d0, d3);
				tessellator.addVertexWithUV(x + 1 - f2, y + f + f1, z + 0, d0, d1);
				rendered = true;
			}
			if (((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x, y, z - 1, ForgeDirection.SOUTH)) {
				tessellator.addVertexWithUV(x + 0, y + f + f1, z + f2, d2, d1);
				tessellator.addVertexWithUV(x + 0, y + 0 + f1, z + 0, d2, d3);
				tessellator.addVertexWithUV(x + 1, y + 0 + f1, z + 0, d0, d3);
				tessellator.addVertexWithUV(x + 1, y + f + f1, z + f2, d0, d1);
				tessellator.addVertexWithUV(x + 1, y + f + f1, z + f2, d0, d1);
				tessellator.addVertexWithUV(x + 1, y + 0 + f1, z + 0, d0, d3);
				tessellator.addVertexWithUV(x + 0, y + 0 + f1, z + 0, d2, d3);
				tessellator.addVertexWithUV(x + 0, y + f + f1, z + f2, d2, d1);
				rendered = true;
			}
			if (((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x, y, z + 1, ForgeDirection.NORTH)) {
				tessellator.addVertexWithUV(x + 1, y + f + f1, z + 1 - f2, d0, d1);
				tessellator.addVertexWithUV(x + 1, y + 0 + f1, z + 1 - 0, d0, d3);
				tessellator.addVertexWithUV(x + 0, y + 0 + f1, z + 1 - 0, d2, d3);
				tessellator.addVertexWithUV(x + 0, y + f + f1, z + 1 - f2, d2, d1);
				tessellator.addVertexWithUV(x + 0, y + f + f1, z + 1 - f2, d2, d1);
				tessellator.addVertexWithUV(x + 0, y + 0 + f1, z + 1 - 0, d2, d3);
				tessellator.addVertexWithUV(x + 1, y + 0 + f1, z + 1 - 0, d0, d3);
				tessellator.addVertexWithUV(x + 1, y + f + f1, z + 1 - f2, d0, d1);
				rendered = true;
			}
			if (((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x, y + 1, z, ForgeDirection.DOWN)) {
				double d5 = x + 0.5D + 0.5D;
				double d6 = x + 0.5D - 0.5D;
				double d7 = z + 0.5D + 0.5D;
				double d8 = z + 0.5D - 0.5D;
				double d9 = x + 0.5D - 0.5D;
				double d10 = x + 0.5D + 0.5D;
				double d11 = z + 0.5D - 0.5D;
				double d12 = z + 0.5D + 0.5D;
				d0 = iicon.getMinU();
				d1 = iicon.getMinV();
				d2 = iicon.getMaxU();
				d3 = iicon.getMaxV();
				y++;
				f = -0.2F;
				if ((x + y + z & 0x1) == 0) {
					tessellator.addVertexWithUV(d9, y + f, z + 0, d2, d1);
					tessellator.addVertexWithUV(d5, y + 0, z + 0, d2, d3);
					tessellator.addVertexWithUV(d5, y + 0, z + 1, d0, d3);
					tessellator.addVertexWithUV(d9, y + f, z + 1, d0, d1);
					d0 = iicon1.getMinU();
					d1 = iicon1.getMinV();
					d2 = iicon1.getMaxU();
					d3 = iicon1.getMaxV();
					tessellator.addVertexWithUV(d10, y + f, z + 1, d2, d1);
					tessellator.addVertexWithUV(d6, y + 0, z + 1, d2, d3);
					tessellator.addVertexWithUV(d6, y + 0, z + 0, d0, d3);
					tessellator.addVertexWithUV(d10, y + f, z + 0, d0, d1);
				} else {
					tessellator.addVertexWithUV(x + 0, y + f, d12, d2, d1);
					tessellator.addVertexWithUV(x + 0, y + 0, d8, d2, d3);
					tessellator.addVertexWithUV(x + 1, y + 0, d8, d0, d3);
					tessellator.addVertexWithUV(x + 1, y + f, d12, d0, d1);
					d0 = iicon1.getMinU();
					d1 = iicon1.getMinV();
					d2 = iicon1.getMaxU();
					d3 = iicon1.getMaxV();
					tessellator.addVertexWithUV(x + 1, y + f, d11, d2, d1);
					tessellator.addVertexWithUV(x + 1, y + 0, d7, d2, d3);
					tessellator.addVertexWithUV(x + 0, y + 0, d7, d0, d3);
					tessellator.addVertexWithUV(x + 0, y + f, d11, d0, d1);
				}
			}
		}
		if (!rendered) {
			double d4 = x + 0.5D + 0.2D;
			double d5 = x + 0.5D - 0.2D;
			double d6 = z + 0.5D + 0.2D;
			double d7 = z + 0.5D - 0.2D;
			double d8 = x + 0.5D - 0.3D;
			double d9 = x + 0.5D + 0.3D;
			double d10 = z + 0.5D - 0.3D;
			double d11 = z + 0.5D + 0.3D;
			tessellator.addVertexWithUV(d8, y + f, z + 1, d2, d1);
			tessellator.addVertexWithUV(d4, y + 0, z + 1, d2, d3);
			tessellator.addVertexWithUV(d4, y + 0, z + 0, d0, d3);
			tessellator.addVertexWithUV(d8, y + f, z + 0, d0, d1);
			tessellator.addVertexWithUV(d9, y + f, z + 0, d2, d1);
			tessellator.addVertexWithUV(d5, y + 0, z + 0, d2, d3);
			tessellator.addVertexWithUV(d5, y + 0, z + 1, d0, d3);
			tessellator.addVertexWithUV(d9, y + f, z + 1, d0, d1);
			d0 = iicon1.getMinU();
			d1 = iicon1.getMinV();
			d2 = iicon1.getMaxU();
			d3 = iicon1.getMaxV();
			tessellator.addVertexWithUV(x + 1, y + f, d11, d2, d1);
			tessellator.addVertexWithUV(x + 1, y + 0, d7, d2, d3);
			tessellator.addVertexWithUV(x + 0, y + 0, d7, d0, d3);
			tessellator.addVertexWithUV(x + 0, y + f, d11, d0, d1);
			tessellator.addVertexWithUV(x + 0, y + f, d10, d2, d1);
			tessellator.addVertexWithUV(x + 0, y + 0, d6, d2, d3);
			tessellator.addVertexWithUV(x + 1, y + 0, d6, d0, d3);
			tessellator.addVertexWithUV(x + 1, y + f, d10, d0, d1);
			d4 = x + 0.5D - 0.5D;
			d5 = x + 0.5D + 0.5D;
			d6 = z + 0.5D - 0.5D;
			d7 = z + 0.5D + 0.5D;
			d8 = x + 0.5D - 0.4D;
			d9 = x + 0.5D + 0.4D;
			d10 = z + 0.5D - 0.4D;
			d11 = z + 0.5D + 0.4D;
			tessellator.addVertexWithUV(d8, y + f, z + 0, d0, d1);
			tessellator.addVertexWithUV(d4, y + 0, z + 0, d0, d3);
			tessellator.addVertexWithUV(d4, y + 0, z + 1, d2, d3);
			tessellator.addVertexWithUV(d8, y + f, z + 1, d2, d1);
			tessellator.addVertexWithUV(d9, y + f, z + 1, d0, d1);
			tessellator.addVertexWithUV(d5, y + 0, z + 1, d0, d3);
			tessellator.addVertexWithUV(d5, y + 0, z + 0, d2, d3);
			tessellator.addVertexWithUV(d9, y + f, z + 0, d2, d1);
			d0 = iicon.getMinU();
			d1 = iicon.getMinV();
			d2 = iicon.getMaxU();
			d3 = iicon.getMaxV();
			tessellator.addVertexWithUV(x + 0, y + f, d11, d0, d1);
			tessellator.addVertexWithUV(x + 0, y + 0, d7, d0, d3);
			tessellator.addVertexWithUV(x + 1, y + 0, d7, d2, d3);
			tessellator.addVertexWithUV(x + 1, y + f, d11, d2, d1);
			tessellator.addVertexWithUV(x + 1, y + f, d10, d0, d1);
			tessellator.addVertexWithUV(x + 1, y + 0, d6, d0, d3);
			tessellator.addVertexWithUV(x + 0, y + 0, d6, d2, d3);
			tessellator.addVertexWithUV(x + 0, y + f, d10, d2, d1);
		}
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return 1940;
	}
}
