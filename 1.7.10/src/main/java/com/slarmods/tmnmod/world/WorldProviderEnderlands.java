package com.slarmods.tmnmod.world;

import com.slarmods.tmnmod.world.biome.BiomesTMN;
import com.slarmods.tmnmod.world.gen.ChunkProviderEnderlands;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderEnderlands extends WorldProvider {

	@Override
	/** tells Minecraft to use our new Terrain Generator */
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderEnderlands(this.worldObj, this.worldObj.getSeed(), true);
	}

	@Override
	/** tells Minecraft to use our new WorldChunkManager **/
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerEnderlands(worldObj.getSeed(), terrainType);
		this.dimensionId = DimensionIDs.ENDERLANDSDIMENSION;
		this.hasNoSky = true;
	}

	/** Get Provider for Dimension **/
	public static WorldProvider getProviderForDimension(int id) {
		return DimensionManager.createProviderFor(DimensionIDs.ENDERLANDSDIMENSION);
	}

	@Override
	public String getDimensionName() {
		return "The Enderlands";
	}

	@Override
	/** sets/creates the save folder */
	public String getSaveFolder() {
		return "DIM" + DimensionIDs.ENDERLANDSDIMENSION;
	}

	@SideOnly(Side.CLIENT)
	/** should stars be rendered? */
	public boolean renderStars() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	/** @return the player speed */
	public double getMovementFactor() {
		return 0.1;
	}

	@SideOnly(Side.CLIENT)
	/** @return the light value of the stars */
	public float getStarBrightness(World world, float f) {
		return 1.0F;
	}

	@SideOnly(Side.CLIENT)
	/** should clouds be rendered? */
	public boolean renderClouds() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean renderVoidFog() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	/** should the end sky be rendered or the overworld sky? */
	public boolean renderEndSky() {
		return true;
	}

	/**
	 * @return the sky color
	 */
	@SideOnly(Side.CLIENT)
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
		return worldObj.getSkyColorBody(cameraEntity, partialTicks);
	}

	@SideOnly(Side.CLIENT)
	/** should a color for the sky be rendered? */
	public boolean isSkyColored() {
		return false;
	}

	@Override
	/** can the player respawn in this dimension? */
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	/** is this a surface world or an underworld */
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	/** @return the high of the clouds */
	public float getCloudHeight() {
		return this.terrainType.getCloudHeight();
	}

	@Override
	/** the light value in this dimension */
	protected void generateLightBrightnessTable() {
		float f = 0.0F;

		for (int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - (float) i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	/** @return the dimension join message */
	public String getWelcomeMessage() {
		return "Entering the Enderlands";
	}

	@Override
	@SideOnly(Side.CLIENT)
	/** @return the dimension leave message */
	public String getDepartMessage() {
		return "Leaving the Enderlands";
	}

	@Override
	public Vec3 drawClouds(float partialTicks) {
		return super.drawClouds(partialTicks);
	}

	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
		int i = 10518688;
		float f2 = MathHelper.cos(p_76562_1_ * (float) Math.PI * 2.0F) * 2.0F + 0.5F;

		if (f2 < 0.0F) {
			f2 = 0.0F;
		}

		if (f2 > 1.0F) {
			f2 = 1.0F;
		}

		float f3 = (float) (i >> 16 & 255) / 255.0F;
		float f4 = (float) (i >> 8 & 255) / 255.0F;
		float f5 = (float) (i & 255) / 255.0F;
		f3 *= f2 * 0.0F + 0.15F;
		f4 *= f2 * 0.0F + 0.15F;
		f5 *= f2 * 0.0F + 0.15F;
		return Vec3.createVectorHelper((double) f3, (double) f4, (double) f5);
	}
}
