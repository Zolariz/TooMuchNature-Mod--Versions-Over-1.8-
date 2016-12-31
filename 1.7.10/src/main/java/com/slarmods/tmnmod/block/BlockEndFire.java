package com.slarmods.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.IdentityHashMap;
import java.util.Map.Entry;
import java.util.Random;
import com.google.common.collect.Maps;
import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.util.ForgeDirection;
import static net.minecraftforge.common.util.ForgeDirection.*;

public class BlockEndFire extends Block {
	@Deprecated
	private int[] field_149849_a = new int[4096];
	@Deprecated
	private int[] field_149848_b = new int[4096];
	@SideOnly(Side.CLIENT)
	private IIcon[] fireIcon;

	public BlockEndFire(Material material) {
		super(material);
		this.setTickRandomly(true);
		this.setLightLevel(1.0F);
	}

	public static void func_149843_e() {

	}

	@Deprecated
	public void func_149842_a(int x, int y, int z) {
		this.setFireInfo((Block) Block.blockRegistry.getObjectById(x), y, z);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 1940;
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public int tickRate(World world) {
		return 30;
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		if (world.getGameRules().getGameRuleBooleanValue("doFireTick")) {
			boolean flag = world.getBlock(x, y - 1, z).isFireSource(world, x, y - 1, z, UP);

			if (!this.canPlaceBlockAt(world, x, y, z)) {
				world.setBlockToAir(x, y, z);
			}

			if (!flag && world.isRaining()
					&& (world.canLightningStrikeAt(x, y, z) || world.canLightningStrikeAt(x - 1, y, z)
							|| world.canLightningStrikeAt(x + 1, y, z) || world.canLightningStrikeAt(x, y, z - 1)
							|| world.canLightningStrikeAt(x, y, z + 1))) {
				world.setBlockToAir(x, y, z);
			} else {
				int l = world.getBlockMetadata(x, y, z);

				if (l < 15) {
					world.setBlockMetadataWithNotify(x, y, z, l + random.nextInt(3) / 2, 4);
				}

				world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + random.nextInt(10));

				if (!flag && !this.canNeighborBurn(world, x, y, z)) {
					if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) || l > 3) {
						world.setBlockToAir(x, y, z);
					}
				} else if (!flag && !this.canCatchFire(world, x, y - 1, z, UP) && l == 15 && random.nextInt(4) == 0) {
					world.setBlockToAir(x, y, z);
				} else {
					boolean flag1 = world.isBlockHighHumidity(x, y, z);
					byte b0 = 0;

					if (flag1) {
						b0 = -50;
					}

					this.tryCatchFire(world, x + 1, y, z, 300 + b0, random, l, WEST);
					this.tryCatchFire(world, x - 1, y, z, 300 + b0, random, l, EAST);
					this.tryCatchFire(world, x, y - 1, z, 250 + b0, random, l, UP);
					this.tryCatchFire(world, x, y + 1, z, 250 + b0, random, l, DOWN);
					this.tryCatchFire(world, x, y, z - 1, 300 + b0, random, l, SOUTH);
					this.tryCatchFire(world, x, y, z + 1, 300 + b0, random, l, NORTH);

					for (int i1 = x - 1; i1 <= x + 1; ++i1) {
						for (int j1 = z - 1; j1 <= z + 1; ++j1) {
							for (int k1 = y - 1; k1 <= y + 4; ++k1) {
								if (i1 != x || k1 != y || j1 != z) {
									int l1 = 100;

									if (k1 > y + 1) {
										l1 += (k1 - (y + 1)) * 100;
									}

									int i2 = this.getChanceOfNeighborsEncouragingFire(world, i1, k1, j1);

									if (i2 > 0) {
										int j2 = (i2 + 40 + world.difficultySetting.getDifficultyId() * 7) / (l + 30);

										if (flag1) {
											j2 /= 2;
										}

										if (j2 > 0 && random.nextInt(l1) <= j2
												&& (!world.isRaining() || !world.canLightningStrikeAt(i1, k1, j1))
												&& !world.canLightningStrikeAt(i1 - 1, k1, z)
												&& !world.canLightningStrikeAt(i1 + 1, k1, j1)
												&& !world.canLightningStrikeAt(i1, k1, j1 - 1)
												&& !world.canLightningStrikeAt(i1, k1, j1 + 1)) {
											int k2 = l + random.nextInt(5) / 4;

											if (k2 > 15) {
												k2 = 15;
											}

											world.setBlock(i1, k1, j1, this, k2, 3);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public boolean func_149698_L() {
		return false;
	}

	@Deprecated
	private void tryCatchFire(World world, int x, int y, int z, int side, Random random, int par7) {
		this.tryCatchFire(world, x, y, z, side, random, par7, UP);
	}

	private void tryCatchFire(World world, int x, int y, int z, int side, Random random, int par7,
			ForgeDirection face) {
		int j1 = world.getBlock(x, y, z).getFlammability(world, x, y, z, face);

		if (random.nextInt(side) < j1) {
			boolean flag = world.getBlock(x, y, z) == Blocks.tnt;

			if (random.nextInt(par7 + 10) < 5 && !world.canLightningStrikeAt(x, y, z)) {
				int k1 = par7 + random.nextInt(5) / 4;

				if (k1 > 15) {
					k1 = 15;
				}

				world.setBlock(x, y, z, this, k1, 3);
			} else {
				world.setBlockToAir(x, y, z);
			}

			if (flag) {
				Blocks.tnt.onBlockDestroyedByPlayer(world, x, y, z, 1);
			}
		}
	}

	private boolean canNeighborBurn(World world, int x, int y, int z) {
		return this.canCatchFire(world, x + 1, y, z, WEST) || this.canCatchFire(world, x - 1, y, z, EAST)
				|| this.canCatchFire(world, x, y - 1, z, UP) || this.canCatchFire(world, x, y + 1, z, DOWN)
				|| this.canCatchFire(world, x, y, z - 1, SOUTH) || this.canCatchFire(world, x, y, z + 1, NORTH);
	}

	private int getChanceOfNeighborsEncouragingFire(World world, int x, int y, int z) {
		byte b0 = 0;

		if (!world.isAirBlock(x, y, z)) {
			return 0;
		} else {
			int l = b0;
			l = this.getChanceToEncourageFire(world, x + 1, y, z, l, WEST);
			l = this.getChanceToEncourageFire(world, x - 1, y, z, l, EAST);
			l = this.getChanceToEncourageFire(world, x, y - 1, z, l, UP);
			l = this.getChanceToEncourageFire(world, x, y + 1, z, l, DOWN);
			l = this.getChanceToEncourageFire(world, x, y, z - 1, l, SOUTH);
			l = this.getChanceToEncourageFire(world, x, y, z + 1, l, NORTH);
			return l;
		}
	}

	public boolean isCollidable() {
		return false;
	}

	@Deprecated
	public boolean canBlockCatchFire(IBlockAccess blockAccess, int x, int y, int z) {
		return canCatchFire(blockAccess, x, y, z, UP);
	}

	@Deprecated
	public int func_149846_a(World world, int x, int y, int z, int side) {
		return getChanceToEncourageFire(world, x, y, z, side, UP);
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) || this.canNeighborBurn(world, x, y, z);
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor Block
	 */
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) {
			world.setBlockToAir(x, y, z);
		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World world, int x, int y, int z) {
		if (world.provider.dimensionId > 0
				|| !((BlockLowerEndPortal) TooMuchNature.lower_end_portal).canPlaceBlockAt(world, x, y, z)) {
			if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) {
				world.setBlockToAir(x, y, z);
			} else {
				world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
			}
		}
	}

	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (random.nextInt(24) == 0) {
			world.playSound((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F),
					"fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
		}

		int l;
		float f;
		float f1;
		float f2;

		if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)
				&& !((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x, y - 1, z, UP)) {
			if (Blocks.fire.canCatchFire(world, x - 1, y, z, EAST)) {
				for (l = 0; l < 2; ++l) {
					f = (float) x + random.nextFloat() * 0.1F;
					f1 = (float) y + random.nextFloat();
					f2 = (float) z + random.nextFloat();
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x + 1, y, z, WEST)) {
				for (l = 0; l < 2; ++l) {
					f = (float) (x + 1) - random.nextFloat() * 0.1F;
					f1 = (float) y + random.nextFloat();
					f2 = (float) z + random.nextFloat();
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x, y, z - 1, SOUTH)) {
				for (l = 0; l < 2; ++l) {
					f = (float) x + random.nextFloat();
					f1 = (float) y + random.nextFloat();
					f2 = (float) z + random.nextFloat() * 0.1F;
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x, y, z + 1, NORTH)) {
				for (l = 0; l < 2; ++l) {
					f = (float) x + random.nextFloat();
					f1 = (float) y + random.nextFloat();
					f2 = (float) (z + 1) - random.nextFloat() * 0.1F;
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (((BlockEndFire) TooMuchNature.end_fire).canCatchFire(world, x, y + 1, z, DOWN)) {
				for (l = 0; l < 2; ++l) {
					f = (float) x + random.nextFloat();
					f1 = (float) (y + 1) - random.nextFloat() * 0.1F;
					f2 = (float) z + random.nextFloat();
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}
		} else {
			for (l = 0; l < 3; ++l) {
				f = (float) x + random.nextFloat();
				f1 = (float) y + random.nextFloat() * 0.5F + 0.5F;
				f2 = (float) z + random.nextFloat();
				world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.fireIcon = new IIcon[] { iconRegister.registerIcon(this.getTextureName() + "_layer_0"),
				iconRegister.registerIcon(this.getTextureName() + "_layer_1") };
	}

	@SideOnly(Side.CLIENT)
	public IIcon getFireIcon(int iFireIcon) {
		return this.fireIcon[iFireIcon];
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return this.fireIcon[0];
	}

	public MapColor getMapColor(int color) {
		return MapColor.sandColor;
	}

	private static class FireInfo {
		private int encouragement = 0;
		private int flammibility = 0;
	}

	private IdentityHashMap<Block, FireInfo> blockInfo = Maps.newIdentityHashMap();

	public void setFireInfo(Block block, int encouragement, int flammibility) {
		if (block == Blocks.air)
			throw new IllegalArgumentException("Tried to set air on fire... This is bad.");
		int id = Block.getIdFromBlock(block);
		this.field_149849_a[id] = encouragement;
		this.field_149848_b[id] = flammibility;

		FireInfo info = getInfo(block, true);
		info.encouragement = encouragement;
		info.flammibility = flammibility;
	}

	private FireInfo getInfo(Block block, boolean garentee) {
		FireInfo ret = blockInfo.get(block);
		if (ret == null && garentee) {
			ret = new FireInfo();
			blockInfo.put(block, ret);
		}
		return ret;
	}

	public void rebuildFireInfo() {
		for (int x = 0; x < 4096; x++) {
			field_149849_a[x] = 0;
			field_149848_b[x] = 0;
		}

		for (Entry<Block, FireInfo> e : blockInfo.entrySet()) {
			int id = Block.getIdFromBlock(e.getKey());
			if (id >= 0 && id < 4096) {
				field_149849_a[id] = e.getValue().encouragement;
				field_149848_b[id] = e.getValue().flammibility;
			}
		}
	}

	public int getFlammability(Block block) {
		int id = Block.getIdFromBlock(block);
		return id >= 0 && id < 4096 ? field_149848_b[id] : 0;
	}

	public int getEncouragement(Block block) {
		int id = Block.getIdFromBlock(block);
		return id >= 0 && id < 4096 ? field_149849_a[id] : 0;
	}

	public boolean canCatchFire(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return world.getBlock(x, y, z).isFlammable(world, x, y, z, face);
	}

	public int getChanceToEncourageFire(IBlockAccess world, int x, int y, int z, int oldChance, ForgeDirection face) {
		int newChance = world.getBlock(x, y, z).getFireSpreadSpeed(world, x, y, z, face);
		return (newChance > oldChance ? newChance : oldChance);
	}
}
