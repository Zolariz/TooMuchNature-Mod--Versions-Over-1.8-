/**
	Copyright (C) <2016>  <TheSlarFab>

    This file is part of the TheSlarFab TooMuchNature Mod; as such, 
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

package com.theslarfab.tmnmod.block;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.init.TMNBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockMossyEndStoneBrickStairs extends BlockStairs {
	private final Block blockModel;
	private final int idk;

	public BlockMossyEndStoneBrickStairs(Block block, int par2) {
		super(TMNBlocks.end_stone_bricks, par2);
		this.blockModel = block;
		this.idk = par2;
		this.setHardness(1.5F);
		this.setResistance(0.3F);
		this.setStepSound(block.stepSound);
		this.setHarvestLevel("pickaxe", 0);
		this.setLightOpacity(255);
		this.setCreativeTab(TooMuchNatventure.tabTMNBlocks);
		this.useNeighborBrightness = true;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 10;
	}
}