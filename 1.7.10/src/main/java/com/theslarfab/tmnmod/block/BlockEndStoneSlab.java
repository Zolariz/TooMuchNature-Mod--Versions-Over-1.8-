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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.init.TMNBlocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockEndStoneSlab extends BlockSlab {
	public static final String[] slab = new String[] { "smooth_end_stone", "end_stone", "smooth_end_stone_brick" };
	@SideOnly(Side.CLIENT)
	protected final boolean isDoubleSlab;
	private IIcon field_150007_M;

	public BlockEndStoneSlab(boolean isDoubleSlab) {
		super(isDoubleSlab, Material.rock);
		this.isDoubleSlab = isDoubleSlab;

		if (isDoubleSlab) {
			this.opaque = true;
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

		this.setLightOpacity(255);
		this.useNeighborBrightness = true;
		this.setHardness(2.0F);
		this.setHarvestLevel("pickaxe", 0);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		int k = meta & 7;

		if (this.field_150004_a && (meta & 8) != 0) {
			side = 1;
		}

		return k == 0 ? (side != 1 && side != 0 ? this.field_150007_M : this.blockIcon)
				: (k == 1 ? Blocks.end_stone.getBlockTextureFromSide(side)
						: (k == 2 ? TMNBlocks.end_stone_bricks.getBlockTextureFromSide(side) : this.blockIcon));
	}

	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(TMNBlocks.end_stone_slab);
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(TMNBlocks.end_stone_slab);
	}

	protected ItemStack createStackedBlock(int stackedBlock) {
		return new ItemStack(Item.getItemFromBlock(TMNBlocks.end_stone_slab), 2, stackedBlock & 7);
	}

	public String func_150002_b(int slabLength) {
		if (slabLength < 0 || slabLength >= slab.length) {
			slabLength = 0;
		}

		return super.getUnlocalizedName() + "." + slab[slabLength];
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list) {
		if (item != Item.getItemFromBlock(TMNBlocks.end_stone_double_slab)) {
			for (int i = 0; i < slab.length; ++i) {
				list.add(new ItemStack(item, 1, i));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(this.getTextureName() + "_top");
		this.field_150007_M = iconRegister.registerIcon(this.getTextureName() + "_side");
	}
}