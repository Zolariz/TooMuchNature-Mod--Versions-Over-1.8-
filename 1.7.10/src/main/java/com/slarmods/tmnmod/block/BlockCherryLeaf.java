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

package com.slarmods.tmnmod.block;

import java.util.List;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.item.TMNItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCherryLeaf extends BlockTMNLeaves {

	public static final String[][] leaftypes = new String[][] { { "leaves_cherry" }, { "leaves_cherry_opaque" } };
	public static final String[] leaves = new String[] { "cherry" };

	public BlockCherryLeaf(Material leaves) {
		super();
	}

	protected void func_150124_c(World world, int x, int y, int z, int drop, int itemDrop) {
		if ((drop & 3) == 0 && world.rand.nextInt(itemDrop) == 0) {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(TMNItems.cherry, 1, 0));
		}
	}

	public int damageDropped(int i) {
		return super.damageDropped(i) + 4;
	}

	public int getDamageValue(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z) & 3;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < leaves.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		for (int i = 0; i < leaftypes.length; ++i) {
			this.field_150129_M[i] = new IIcon[leaftypes[i].length];

			for (int j = 0; j < leaftypes[i].length; ++j) {
				this.field_150129_M[i][j] = iconRegister.registerIcon(TooMuchNature.modid + ":" + leaftypes[i][j]);
			}
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1]
				: this.field_150129_M[this.field_150127_b][0];
	}

	@Override
	public String[] func_150125_e() {
		return leaves;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side) {
		return true;
	}
}