package com.theslarfab.tmnmod.block;

import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.block.BlockEnderstoneDiode;
import com.theslarfab.tmnmod.client.renderer.BlockRenderingIDs;
import com.theslarfab.tmnmod.init.TMNBlocks;
import com.theslarfab.tmnmod.init.TMNItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEnderstoneRepeater extends BlockEnderstoneDiode {

	public static final double[] repeaterTorchOffset = new double[] { -0.0625D, 0.0625D, 0.1875D, 0.3125D };
	private static final int[] repeaterState = new int[] { 1, 2, 3, 4 };

	public BlockEnderstoneRepeater(boolean isPowered) {
		super(isPowered);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int activate, float hitX,
			float hitY, float hitZ) {
		int i1 = world.getBlockMetadata(x, y, z);
		int j1 = (i1 & 12) >> 2;
		j1 = j1 + 1 << 2 & 12;
		world.setBlockMetadataWithNotify(x, y, z, j1 | i1 & 3, 3);
		return true;
	}

	protected int func_149901_b(int state) {
		return repeaterState[(state & 12) >> 2] * 2;
	}

	protected BlockEnderstoneDiode getBlockPowered() {
		return TMNBlocks.enderstone_repeater_powered;
	}

	protected BlockEnderstoneDiode getBlockUnpowered() {
		return TMNBlocks.enderstone_repeater_unpowered;
	}

	public Item getItemDropped(int metadata, Random random, int fortune) {
		return TMNItems.enderstone_repeater;
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return TMNItems.enderstone_repeater;
	}

	public int getRenderType() {
		return BlockRenderingIDs.enderstoneRepeaterRenderID;
	}

	public boolean func_149910_g(IBlockAccess world, int x, int y, int z, int side) {
		return this.func_149902_h(world, x, y, z, side) > 0;
	}

	protected boolean func_149908_a(Block block) {
		return isRedstoneRepeaterBlockID(block);
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int destroy) {
		super.breakBlock(world, x, y, z, block, destroy);
		this.func_149911_e(world, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (this.isRepeaterPowered) {
			int l = world.getBlockMetadata(x, y, z);
			int i1 = getDirection(l);
			double d0 = (double) ((float) x + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.2D;
			double d1 = (double) ((float) y + 0.4F) + (double) (random.nextFloat() - 0.5F) * 0.2D;
			double d2 = (double) ((float) z + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.2D;
			double d3 = 0.0D;
			double d4 = 0.0D;

			if (random.nextInt(2) == 0) {
				switch (i1) {
				case 0:
					d4 = -0.3125D;
					break;
				case 1:
					d3 = 0.3125D;
					break;
				case 2:
					d4 = 0.3125D;
					break;
				case 3:
					d3 = -0.3125D;
				}
			} else {
				int j1 = (l & 12) >> 2;

				switch (i1) {
				case 0:
					d4 = repeaterTorchOffset[j1];
					break;
				case 1:
					d3 = -repeaterTorchOffset[j1];
					break;
				case 2:
					d4 = -repeaterTorchOffset[j1];
					break;
				case 3:
					d3 = repeaterTorchOffset[j1];
				}
			}

			world.spawnParticle("reddust", d0 + d3, d1, d2 + d4, 0.0D, 5.0D, 1.5D);
		}
	}
}
