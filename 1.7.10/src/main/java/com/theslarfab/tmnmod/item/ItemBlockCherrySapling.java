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

package com.theslarfab.tmnmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCherrySapling extends ItemBlock {

	public static final String[] sapling = new String[] { "cherry" };

	public ItemBlockCherrySapling(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= sapling.length) {
			i = 0;
		}

		return super.getUnlocalizedName() + "." + sapling[i];
	}

	public int getMetadata(int meta) {
		return meta;
	}
}
