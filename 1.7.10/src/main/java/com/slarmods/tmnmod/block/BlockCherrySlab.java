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

package com.slarmods.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCherrySlab extends BlockSlab {
	public static final String[] slab = new String[] { "cherry" };
	protected final boolean field_150004_a;

	public BlockCherrySlab(Material wood, boolean isDoubleSlab) {
		super(isDoubleSlab, Material.wood);
		this.field_150004_a = isDoubleSlab;

		if (isDoubleSlab) {
			this.opaque = true;
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

		this.setLightOpacity(255);
		this.useNeighborBrightness = true;
		this.setHardness(2.0F);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockaccess, int x, int y, int z) {
		if (this.field_150004_a) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			boolean flag = (blockaccess.getBlockMetadata(x, y, z) & 8) != 0;

			if (flag) {
				this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			} else {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			}
		}
	}

	public void setBlockBoundsForItemRender() {
		if (this.field_150004_a) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return TooMuchNature.cherry_planks.getIcon(par1, par2 & 7);
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(TooMuchNature.cherry_slab);
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(TooMuchNature.cherry_slab);
	}

	protected ItemStack createStackedBlock(int stackedBlock) {
		return new ItemStack(Item.getItemFromBlock(TooMuchNature.cherry_slab), 2, stackedBlock & 7);
	}

	public String func_150002_b(int llength) {
		if (llength < 0 || llength >= slab.length) {
			llength = 0;
		}

		return super.getUnlocalizedName() + "." + slab[llength];
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list) {
		if (item != Item.getItemFromBlock(TooMuchNature.cherry_double_slab)) {
			for (int i = 0; i < slab.length; ++i) {
				list.add(new ItemStack(item, 1, i));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {

	}
}