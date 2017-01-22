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

package com.slarmods.tmnmod.item;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.block.TMNBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemBlockCherrySlab extends ItemSlab {
	
	public ItemBlockCherrySlab(Block block) {
		super(block, (BlockSlab) TMNBlocks.cherry_slab, (BlockSlab) TMNBlocks.cherry_double_slab, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
}