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

import java.util.List;
import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.world.gen.feature.WorldGenCherryTree;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockCherrySapling extends BlockBush implements IGrowable {

	public static final String[] sapling = new String[] { "cherry" };
	private static final IIcon[] iconLength = new IIcon[sapling.length];

	public BlockCherrySapling() {
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks);
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		if (!world.isRemote) {
			super.updateTick(world, x, y, z, random);

			if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0) {
				this.func_149879_c(world, x, y, z, random);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		meta &= 7;
		return iconLength[MathHelper.clamp_int(meta, 0, 5)];
	}

	public void func_149879_c(World world, int x, int y, int z, Random random) {
		int l = world.getBlockMetadata(x, y, z);

		if ((l & 8) == 0) {
			world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
		} else {
			this.saplingGeneration(world, x, y, z, random);
		}
	}

	public void saplingGeneration(World world, int x, int y, int z, Random random) {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, x, y, z))
			return;
		int l = world.getBlockMetadata(x, y, z) & 7;
		Object object = random.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;

		switch (l) {
		case 0:
			object = new WorldGenCherryTree(TooMuchNature.cherry_log, TooMuchNature.cherry_leaf, 0, 0, false, 4, 6,
					false);
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			break;

		}

		Block block = Blocks.air;

		if (flag) {
			world.setBlock(x + i1, y, z + j1, block, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
			world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
		} else {
			world.setBlock(x, y, z, block, 0, 4);
		}

		if (!((WorldGenerator) object).generate(world, random, x + i1, y, z + j1)) {
			if (flag) {
				world.setBlock(x + i1, y, z + j1, this, l, 4);
				world.setBlock(x + i1 + 1, y, z + j1, this, l, 4);
				world.setBlock(x + i1, y, z + j1 + 1, this, l, 4);
				world.setBlock(x + i1 + 1, y, z + j1 + 1, this, l, 4);
			} else {
				world.setBlock(x, y, z, this, l, 4);
			}
		}
	}

	public boolean func_149880_a(World world, int x, int y, int z, int p_149880_5_) {
		return world.getBlock(x, y, z) == this && (world.getBlockMetadata(x, y, z) & 7) == p_149880_5_;
	}

	public int damageDropped(int p_149692_1_) {
		return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < sapling.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		for (int i = 0; i < iconLength.length; ++i) {
			iconLength[i] = p_149651_1_.registerIcon(this.getTextureName() + "_" + sapling[i]);
		}
	}

	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_,
			boolean p_149851_5_) {
		return true;
	}

	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_,
			int p_149852_5_) {
		return (double) p_149852_1_.rand.nextFloat() < 0.45D;
	}

	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_,
			int p_149853_5_) {
		this.func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
	}
}
