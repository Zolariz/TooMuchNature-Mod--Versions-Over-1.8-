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
import com.slarmods.tmnmod.block.BlockEnderstoneWire;
import com.slarmods.tmnmod.client.renderer.BlockRenderingIDs;
import com.slarmods.tmnmod.init.TMNBlocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

@SideOnly(Side.CLIENT)
public class RenderBlockEnderstoneWire implements ISimpleBlockRenderingHandler {
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {

	}

	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		Tessellator tessellator = Tessellator.instance;
		int l = world.getBlockMetadata(x, y, z);
		IIcon icon = BlockRedstoneWire.getRedstoneWireIcon("cross");
		IIcon icon1 = BlockRedstoneWire.getRedstoneWireIcon("line");
		IIcon icon2 = BlockRedstoneWire.getRedstoneWireIcon("cross_overlay");
		IIcon icon3 = BlockRedstoneWire.getRedstoneWireIcon("line_overlay");
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		float f = 1.0F;
		float f1 = l / 15.0F;
		float f2 = f1 * 0.6F + 0.4F;

		if (l == 0) {
			f2 = 0.3F;
		}

		float f3 = f1 * f1 * 0.7F - 0.5F;
		float f4 = f1 * f1 * 0.6F - 0.7F;

		if (f3 < 0.0F) {
			f3 = 0.0F;
		}

		if (f4 < 0.0F) {
			f4 = 0.0F;
		}

		tessellator.setColorOpaque_F(f4, f3, f2);
		boolean flag = (BlockEnderstoneWire.isPowerProviderOrWire(world, x - 1, y, z, 1))
				|| ((!world.getBlock(x - 1, y, z).isBlockNormalCube())
						&& (BlockEnderstoneWire.isPowerProviderOrWire(world, x - 1, y - 1, z, -1)));
		boolean flag1 = (BlockEnderstoneWire.isPowerProviderOrWire(world, x + 1, y, z, 3))
				|| ((!world.getBlock(x + 1, y, z).isBlockNormalCube())
						&& (BlockEnderstoneWire.isPowerProviderOrWire(world, x + 1, y - 1, z, -1)));
		boolean flag2 = (BlockEnderstoneWire.isPowerProviderOrWire(world, x, y, z - 1, 2))
				|| ((!world.getBlock(x, y, z - 1).isBlockNormalCube())
						&& (BlockEnderstoneWire.isPowerProviderOrWire(world, x, y - 1, z - 1, -1)));
		boolean flag3 = (BlockEnderstoneWire.isPowerProviderOrWire(world, x, y, z + 1, 0))
				|| ((!world.getBlock(x, y, z + 1).isBlockNormalCube())
						&& (BlockEnderstoneWire.isPowerProviderOrWire(world, x, y - 1, z + 1, -1)));

		if (!world.getBlock(x, y + 1, z).isBlockNormalCube()) {
			if ((world.getBlock(x - 1, y, z).isBlockNormalCube())
					&& (BlockEnderstoneWire.isPowerProviderOrWire(world, x - 1, y + 1, z, -1))) {
				flag = true;
			}

			if ((world.getBlock(x + 1, y, z).isBlockNormalCube())
					&& (BlockEnderstoneWire.isPowerProviderOrWire(world, x + 1, y + 1, z, -1))) {
				flag1 = true;
			}

			if ((world.getBlock(x, y, z - 1).isBlockNormalCube())
					&& (BlockEnderstoneWire.isPowerProviderOrWire(world, x, y + 1, z - 1, -1))) {
				flag2 = true;
			}

			if ((world.getBlock(x, y, z + 1).isBlockNormalCube())
					&& (BlockEnderstoneWire.isPowerProviderOrWire(world, x, y + 1, z + 1, -1))) {
				flag3 = true;
			}
		}

		float f5 = x + 0;
		float f6 = x + 1;
		float f7 = z + 0;
		float f8 = z + 1;
		int i1 = 0;

		if (((flag) || (flag1)) && (!flag2) && (!flag3)) {
			i1 = 1;
		}

		if (((flag2) || (flag3)) && (!flag1) && (!flag)) {
			i1 = 2;
		}

		if (i1 == 0) {
			int j1 = 0;
			int k1 = 0;
			int l1 = 16;
			int i2 = 16;

			if (!flag) {
				f5 += 0.3125F;
			}

			if (!flag) {
				j1 += 5;
			}

			if (!flag1) {
				f6 -= 0.3125F;
			}

			if (!flag1) {
				l1 -= 5;
			}

			if (!flag2) {
				f7 += 0.3125F;
			}

			if (!flag2) {
				k1 += 5;
			}

			if (!flag3) {
				f8 -= 0.3125F;
			}

			if (!flag3) {
				i2 -= 5;
			}

			tessellator.addVertexWithUV(f6, y + 0.015625D, f8, icon.getInterpolatedU(l1), icon.getInterpolatedV(i2));
			tessellator.addVertexWithUV(f6, y + 0.015625D, f7, icon.getInterpolatedU(l1), icon.getInterpolatedV(k1));
			tessellator.addVertexWithUV(f5, y + 0.015625D, f7, icon.getInterpolatedU(j1), icon.getInterpolatedV(k1));
			tessellator.addVertexWithUV(f5, y + 0.015625D, f8, icon.getInterpolatedU(j1), icon.getInterpolatedV(i2));
			tessellator.setColorOpaque_F(f, f, f);
			tessellator.addVertexWithUV(f6, y + 0.015625D, f8, icon2.getInterpolatedU(l1), icon2.getInterpolatedV(i2));
			tessellator.addVertexWithUV(f6, y + 0.015625D, f7, icon2.getInterpolatedU(l1), icon2.getInterpolatedV(k1));
			tessellator.addVertexWithUV(f5, y + 0.015625D, f7, icon2.getInterpolatedU(j1), icon2.getInterpolatedV(k1));
			tessellator.addVertexWithUV(f5, y + 0.015625D, f8, icon2.getInterpolatedU(j1), icon2.getInterpolatedV(i2));
		} else if (i1 == 1) {
			tessellator.addVertexWithUV(f6, y + 0.015625D, f8, icon1.getMaxU(), icon1.getMaxV());
			tessellator.addVertexWithUV(f6, y + 0.015625D, f7, icon1.getMaxU(), icon1.getMinV());
			tessellator.addVertexWithUV(f5, y + 0.015625D, f7, icon1.getMinU(), icon1.getMinV());
			tessellator.addVertexWithUV(f5, y + 0.015625D, f8, icon1.getMinU(), icon1.getMaxV());
			tessellator.setColorOpaque_F(f, f, f);
			tessellator.addVertexWithUV(f6, y + 0.015625D, f8, icon3.getMaxU(), icon3.getMaxV());
			tessellator.addVertexWithUV(f6, y + 0.015625D, f7, icon3.getMaxU(), icon3.getMinV());
			tessellator.addVertexWithUV(f5, y + 0.015625D, f7, icon3.getMinU(), icon3.getMinV());
			tessellator.addVertexWithUV(f5, y + 0.015625D, f8, icon3.getMinU(), icon3.getMaxV());
		} else {
			tessellator.addVertexWithUV(f6, y + 0.015625D, f8, icon1.getMaxU(), icon1.getMaxV());
			tessellator.addVertexWithUV(f6, y + 0.015625D, f7, icon1.getMinU(), icon1.getMaxV());
			tessellator.addVertexWithUV(f5, y + 0.015625D, f7, icon1.getMinU(), icon1.getMinV());
			tessellator.addVertexWithUV(f5, y + 0.015625D, f8, icon1.getMaxU(), icon1.getMinV());
			tessellator.setColorOpaque_F(f, f, f);
			tessellator.addVertexWithUV(f6, y + 0.015625D, f8, icon3.getMaxU(), icon3.getMaxV());
			tessellator.addVertexWithUV(f6, y + 0.015625D, f7, icon3.getMinU(), icon3.getMaxV());
			tessellator.addVertexWithUV(f5, y + 0.015625D, f7, icon3.getMinU(), icon3.getMinV());
			tessellator.addVertexWithUV(f5, y + 0.015625D, f8, icon3.getMaxU(), icon3.getMinV());
		}

		if (!world.getBlock(x, y + 1, z).isBlockNormalCube()) {
			if ((world.getBlock(x - 1, y, z).isBlockNormalCube())
					&& (world.getBlock(x - 1, y + 1, z) == TMNBlocks.enderstone_wire)) {
				tessellator.setColorOpaque_F(f * f4, f * f3, f * f2);
				tessellator.addVertexWithUV(x + 0.015625D, y + 1 + 0.021875F, z + 1, icon1.getMaxU(), icon1.getMinV());
				tessellator.addVertexWithUV(x + 0.015625D, y + 0, z + 1, icon1.getMinU(), icon1.getMinV());
				tessellator.addVertexWithUV(x + 0.015625D, y + 0, z + 0, icon1.getMinU(), icon1.getMaxV());
				tessellator.addVertexWithUV(x + 0.015625D, y + 1 + 0.021875F, z + 0, icon1.getMaxU(), icon1.getMaxV());
				tessellator.setColorOpaque_F(f, f, f);
				tessellator.addVertexWithUV(x + 0.015625D, y + 1 + 0.021875F, z + 1, icon3.getMaxU(), icon3.getMinV());
				tessellator.addVertexWithUV(x + 0.015625D, y + 0, z + 1, icon3.getMinU(), icon3.getMinV());
				tessellator.addVertexWithUV(x + 0.015625D, y + 0, z + 0, icon3.getMinU(), icon3.getMaxV());
				tessellator.addVertexWithUV(x + 0.015625D, y + 1 + 0.021875F, z + 0, icon3.getMaxU(), icon3.getMaxV());
			}

			if ((world.getBlock(x + 1, y, z).isBlockNormalCube())
					&& (world.getBlock(x + 1, y + 1, z) == TMNBlocks.enderstone_wire)) {
				tessellator.setColorOpaque_F(f * f4, f * f3, f * f2);
				tessellator.addVertexWithUV(x + 1 - 0.015625D, y + 0, z + 1, icon1.getMinU(), icon1.getMaxV());
				tessellator.addVertexWithUV(x + 1 - 0.015625D, y + 1 + 0.021875F, z + 1, icon1.getMaxU(),
						icon1.getMaxV());
				tessellator.addVertexWithUV(x + 1 - 0.015625D, y + 1 + 0.021875F, z + 0, icon1.getMaxU(),
						icon1.getMinV());
				tessellator.addVertexWithUV(x + 1 - 0.015625D, y + 0, z + 0, icon1.getMinU(), icon1.getMinV());
				tessellator.setColorOpaque_F(f, f, f);
				tessellator.addVertexWithUV(x + 1 - 0.015625D, y + 0, z + 1, icon3.getMinU(), icon3.getMaxV());
				tessellator.addVertexWithUV(x + 1 - 0.015625D, y + 1 + 0.021875F, z + 1, icon3.getMaxU(),
						icon3.getMaxV());
				tessellator.addVertexWithUV(x + 1 - 0.015625D, y + 1 + 0.021875F, z + 0, icon3.getMaxU(),
						icon3.getMinV());
				tessellator.addVertexWithUV(x + 1 - 0.015625D, y + 0, z + 0, icon3.getMinU(), icon3.getMinV());
			}

			if ((world.getBlock(x, y, z - 1).isBlockNormalCube())
					&& (world.getBlock(x, y + 1, z - 1) == TMNBlocks.enderstone_wire)) {
				tessellator.setColorOpaque_F(f * f4, f * f3, f * f2);
				tessellator.addVertexWithUV(x + 1, y + 0, z + 0.015625D, icon1.getMinU(), icon1.getMaxV());
				tessellator.addVertexWithUV(x + 1, y + 1 + 0.021875F, z + 0.015625D, icon1.getMaxU(), icon1.getMaxV());
				tessellator.addVertexWithUV(x + 0, y + 1 + 0.021875F, z + 0.015625D, icon1.getMaxU(), icon1.getMinV());
				tessellator.addVertexWithUV(x + 0, y + 0, z + 0.015625D, icon1.getMinU(), icon1.getMinV());
				tessellator.setColorOpaque_F(f, f, f);
				tessellator.addVertexWithUV(x + 1, y + 0, z + 0.015625D, icon3.getMinU(), icon3.getMaxV());
				tessellator.addVertexWithUV(x + 1, y + 1 + 0.021875F, z + 0.015625D, icon3.getMaxU(), icon3.getMaxV());
				tessellator.addVertexWithUV(x + 0, y + 1 + 0.021875F, z + 0.015625D, icon3.getMaxU(), icon3.getMinV());
				tessellator.addVertexWithUV(x + 0, y + 0, z + 0.015625D, icon3.getMinU(), icon3.getMinV());
			}

			if ((world.getBlock(x, y, z + 1).isBlockNormalCube())
					&& (world.getBlock(x, y + 1, z + 1) == TMNBlocks.enderstone_wire)) {
				tessellator.setColorOpaque_F(f * f4, f * f3, f * f2);
				tessellator.addVertexWithUV(x + 1, y + 1 + 0.021875F, z + 1 - 0.015625D, icon1.getMaxU(),
						icon1.getMinV());
				tessellator.addVertexWithUV(x + 1, y + 0, z + 1 - 0.015625D, icon1.getMinU(), icon1.getMinV());
				tessellator.addVertexWithUV(x + 0, y + 0, z + 1 - 0.015625D, icon1.getMinU(), icon1.getMaxV());
				tessellator.addVertexWithUV(x + 0, y + 1 + 0.021875F, z + 1 - 0.015625D, icon1.getMaxU(),
						icon1.getMaxV());
				tessellator.setColorOpaque_F(f, f, f);
				tessellator.addVertexWithUV(x + 1, y + 1 + 0.021875F, z + 1 - 0.015625D, icon3.getMaxU(),
						icon3.getMinV());
				tessellator.addVertexWithUV(x + 1, y + 0, z + 1 - 0.015625D, icon3.getMinU(), icon3.getMinV());
				tessellator.addVertexWithUV(x + 0, y + 0, z + 1 - 0.015625D, icon3.getMinU(), icon3.getMaxV());
				tessellator.addVertexWithUV(x + 0, y + 1 + 0.021875F, z + 1 - 0.015625D, icon3.getMaxU(),
						icon3.getMaxV());
			}
		}

		return true;
	}

	public boolean shouldRender3DInInventory(int arg0) {
		return false;
	}

	public int getRenderId() {
		return BlockRenderingIDs.enderstoneWireRenderID;
	}
}
