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

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.init.TMNBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemBirchDoor extends Item {
	private Material doorMaterial;

	public ItemBirchDoor(Material p_i45334_1_) {
		this.doorMaterial = p_i45334_1_;
		this.maxStackSize = 1;
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (side != 1) {
			return false;
		} else {
			++y;
			Block block = TMNBlocks.cherry_door_block;

			if (this.doorMaterial == Material.wood) {
				block = TMNBlocks.cherry_door_block;
			}

			if (player.canPlayerEdit(x, y, z, side, itemstack) && player.canPlayerEdit(x, y + 1, z, side, itemstack)) {
				if (!block.canPlaceBlockAt(world, x, y, z)) {
					return false;
				} else {
					int i1 = MathHelper.floor_double((double) ((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D)
							& 3;
					placeDoorBlock(world, x, y, z, i1, block);
					--itemstack.stackSize;
					return true;
				}
			} else {
				return false;
			}
		}
	}

	public static void placeDoorBlock(World par1World, int par2, int par3, int par4, int par5, Block par6Block) {
		byte b0 = 0;
		byte b1 = 0;

		if (par5 == 0) {
			b1 = 1;
		}

		if (par5 == 1) {
			b0 = -1;
		}

		if (par5 == 2) {
			b1 = -1;
		}

		if (par5 == 3) {
			b0 = 1;
		}

		int i1 = (par1World.getBlock(par2 - b0, par3, par4 - b1).isNormalCube() ? 1 : 0)
				+ (par1World.getBlock(par2 - b0, par3 + 1, par4 - b1).isNormalCube() ? 1 : 0);
		int j1 = (par1World.getBlock(par2 + b0, par3, par4 + b1).isNormalCube() ? 1 : 0)
				+ (par1World.getBlock(par2 + b0, par3 + 1, par4 + b1).isNormalCube() ? 1 : 0);
		boolean flag = par1World.getBlock(par2 - b0, par3, par4 - b1) == par6Block
				|| par1World.getBlock(par2 - b0, par3 + 1, par4 - b1) == par6Block;
		boolean flag1 = par1World.getBlock(par2 + b0, par3, par4 + b1) == par6Block
				|| par1World.getBlock(par2 + b0, par3 + 1, par4 + b1) == par6Block;
		boolean flag2 = false;

		if (flag && !flag1) {
			flag2 = true;
		} else if (j1 > i1) {
			flag2 = true;
		}

		par1World.setBlock(par2, par3, par4, par6Block, par5, 2);
		par1World.setBlock(par2, par3 + 1, par4, par6Block, 8 | (flag2 ? 1 : 0), 2);
		par1World.notifyBlocksOfNeighborChange(par2, par3, par4, par6Block);
		par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, par6Block);
	}
}