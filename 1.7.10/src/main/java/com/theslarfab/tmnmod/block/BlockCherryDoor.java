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

import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.init.TMNItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCherryDoor extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] field_150017_a;
	@SideOnly(Side.CLIENT)
	private IIcon[] field_150016_b;

	public BlockCherryDoor(Material wood) {
		super(wood);
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
		this.setStepSound(Block.soundTypeWood);
		this.setHardness(3.0F);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.field_150016_b[0];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess par1BlockAccess, int par2, int par3, int par4, int par5) {
		if (par5 != 1 && par5 != 0) {
			int i1 = this.func_150012_g(par1BlockAccess, par2, par3, par4);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;

			if (flag) {
				if (j1 == 0 && par5 == 2) {
					flag1 = !flag1;
				} else if (j1 == 1 && par5 == 5) {
					flag1 = !flag1;
				} else if (j1 == 2 && par5 == 3) {
					flag1 = !flag1;
				} else if (j1 == 3 && par5 == 4) {
					flag1 = !flag1;
				}
			} else {
				if (j1 == 0 && par5 == 5) {
					flag1 = !flag1;
				} else if (j1 == 1 && par5 == 3) {
					flag1 = !flag1;
				} else if (j1 == 2 && par5 == 4) {
					flag1 = !flag1;
				} else if (j1 == 3 && par5 == 2) {
					flag1 = !flag1;
				}

				if ((i1 & 16) != 0) {
					flag1 = !flag1;
				}
			}

			return flag2 ? this.field_150017_a[flag1 ? 1 : 0] : this.field_150016_b[flag1 ? 1 : 0];
		} else {
			return this.field_150016_b[0];
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.field_150017_a = new IIcon[2];
		this.field_150016_b = new IIcon[2];
		this.field_150017_a[0] = iconRegister
				.registerIcon(this.getTextureName() + "_upper");
		this.field_150016_b[0] = iconRegister
				.registerIcon(this.getTextureName() + "_lower");
		this.field_150017_a[1] = new IconFlipped(this.field_150017_a[0], true, false);
		this.field_150016_b[1] = new IconFlipped(this.field_150016_b[0], true, false);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean getBlocksMovement(IBlockAccess blockAccess, int x, int y, int z) {
		int l = this.func_150012_g(blockAccess, x, y, z);
		return (l & 4) != 0;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 7;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		this.setBlockBoundsBasedOnState(world, x, y, z);
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		this.setBlockBoundsBasedOnState(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		this.func_150011_b(this.func_150012_g(blockAccess, x, y, z));
	}

	public int func_150013_e(IBlockAccess blockAccess, int x, int y, int z) {
		return this.func_150012_g(blockAccess, x, y, z) & 3;
	}

	public boolean func_150015_f(IBlockAccess blockAccess, int x, int y, int z) {
		return (this.func_150012_g(blockAccess, x, y, z) & 4) != 0;
	}

	private void func_150011_b(int par1) {
		float f = 0.1875F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		int j = par1 & 3;
		boolean flag = (par1 & 4) != 0;
		boolean flag1 = (par1 & 16) != 0;

		if (j == 0) {
			if (flag) {
				if (!flag1) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
				} else {
					this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			}
		} else if (j == 1) {
			if (flag) {
				if (!flag1) {
					this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
			}
		} else if (j == 2) {
			if (flag) {
				if (!flag1) {
					this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
				}
			} else {
				this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			}
		} else if (j == 3) {
			if (flag) {
				if (!flag1) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
			}
		}
	}

	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
	}

	public boolean onBlockActivated(World par1World, int par2X, int par3Y, int par4Z, EntityPlayer par4Player, int par5,
			float par6, float par7, float par8) {
		if (this.blockMaterial == Material.iron) {
			return false; // Allow items to interact with the door
		} else {
			int i1 = this.func_150012_g(par1World, par2X, par3Y, par4Z);
			int j1 = i1 & 7;
			j1 ^= 4;

			if ((i1 & 8) == 0) {
				par1World.setBlockMetadataWithNotify(par2X, par3Y, par4Z, j1, 2);
				par1World.markBlockRangeForRenderUpdate(par2X, par3Y, par4Z, par2X, par3Y, par4Z);
			} else {
				par1World.setBlockMetadataWithNotify(par2X, par3Y - 1, par4Z, j1, 2);
				par1World.markBlockRangeForRenderUpdate(par2X, par3Y - 1, par4Z, par2X, par3Y, par4Z);
			}

			par1World.playAuxSFXAtEntity(par4Player, 1003, par2X, par3Y, par4Z, 0);
			return true;
		}
	}

	public void func_150014_a(World world, int x, int y, int z, boolean isNotified) {
		int l = this.func_150012_g(world, x, y, z);
		boolean flag1 = (l & 4) != 0;

		if (flag1 != isNotified) {
			int i1 = l & 7;
			i1 ^= 4;

			if ((l & 8) == 0) {
				world.setBlockMetadataWithNotify(x, y, z, i1, 2);
				world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
			} else {
				world.setBlockMetadataWithNotify(x, y - 1, z, i1, 2);
				world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
			}

			world.playAuxSFXAtEntity((EntityPlayer) null, 1003, x, y, z, 0);
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		int l = world.getBlockMetadata(x, y, z);

		if ((l & 8) == 0) {
			boolean flag = false;

			if (world.getBlock(x, y + 1, z) != this) {
				world.setBlockToAir(x, y, z);
				flag = true;
			}

			if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)) {
				world.setBlockToAir(x, y, z);
				flag = true;

				if (world.getBlock(x, y + 1, z) == this) {
					world.setBlockToAir(x, y + 1, z);
				}
			}

			if (flag) {
				if (!world.isRemote) {
					this.dropBlockAsItem(world, x, y, z, l, 0);
				}
			} else {
				boolean flag1 = world.isBlockIndirectlyGettingPowered(x, y, z)
						|| world.isBlockIndirectlyGettingPowered(x, y + 1, z);

				if ((flag1 || block.canProvidePower()) && block != this) {
					this.func_150014_a(world, x, y, z, flag1);
				}
			}
		} else {
			if (world.getBlock(x, y - 1, z) != this) {
				world.setBlockToAir(x, y, z);
			}

			if (block != this) {
				this.onNeighborBlockChange(world, x, y - 1, z, block);
			}
		}
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return (meta & 8) != 0 ? null : TMNItems.item_cherry_door;
	}

	public MovingObjectPosition collisionRayTrace(World par1World, int par2X, int par3Y, int par4Z, Vec3 par5,
			Vec3 par6) {
		this.setBlockBoundsBasedOnState(par1World, par2X, par3Y, par4Z);
		return super.collisionRayTrace(par1World, par2X, par3Y, par4Z, par5, par6);
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return y >= world.getHeight() - 1 ? false
				: World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && super.canPlaceBlockAt(world, x, y, z)
						&& super.canPlaceBlockAt(world, x, y + 1, z);
	}

	public int getMobilityFlag() {
		return 1;
	}

	public int func_150012_g(IBlockAccess blockAccess, int x, int y, int z) {
		int l = blockAccess.getBlockMetadata(x, y, z);
		boolean flag = (l & 8) != 0;
		int i1;
		int j1;

		if (flag) {
			i1 = blockAccess.getBlockMetadata(x, y - 1, z);
			j1 = l;
		} else {
			i1 = l;
			j1 = blockAccess.getBlockMetadata(x, y + 1, z);
		}

		boolean flag1 = (j1 & 1) != 0;
		return i1 & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return TMNItems.item_cherry_door;
	}

	public void onBlockHarvested(World par1World, int par2X, int par3Y, int par4Z, int par5, EntityPlayer par6Player) {
		if (par6Player.capabilities.isCreativeMode && (par5 & 8) != 0
				&& par1World.getBlock(par2X, par3Y - 1, par4Z) == this) {
			par1World.setBlockToAir(par2X, par3Y - 1, par4Z);
		}
	}
}