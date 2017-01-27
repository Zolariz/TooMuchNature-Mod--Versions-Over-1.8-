package com.theslarfab.tmnmod.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import com.theslarfab.tmnmod.block.BlockEnderPistonBase;
import com.theslarfab.tmnmod.init.TMNBlocks;
import com.theslarfab.tmnmod.tileentity.TileEntityEnderPiston;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class TileEntityRendererEnderPiston extends TileEntitySpecialRenderer {
	private RenderBlocks renderBlocks;

	public void renderTileEntityAt(TileEntityEnderPiston tileEntityEnderPiston, double x, double y, double z,
			float side) {
		Block block = tileEntityEnderPiston.getStoredBlockID();

		if (block.getMaterial() != Material.air && tileEntityEnderPiston.func_145860_a(side) < 1.0F) {
			Tessellator tessellator = Tessellator.instance;
			this.bindTexture(TextureMap.locationBlocksTexture);
			RenderHelper.disableStandardItemLighting();
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_CULL_FACE);

			if (Minecraft.isAmbientOcclusionEnabled()) {
				GL11.glShadeModel(GL11.GL_SMOOTH);
			} else {
				GL11.glShadeModel(GL11.GL_FLAT);
			}

			tessellator.startDrawingQuads();
			tessellator.setTranslation(
					(double) ((float) x - (float) tileEntityEnderPiston.xCoord
							+ tileEntityEnderPiston.func_145865_b(side)),
					(double) ((float) y - (float) tileEntityEnderPiston.yCoord
							+ tileEntityEnderPiston.func_145862_c(side)),
					(double) ((float) z - (float) tileEntityEnderPiston.zCoord
							+ tileEntityEnderPiston.func_145859_d(side)));
			tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);

			if (block == TMNBlocks.ender_piston_head && tileEntityEnderPiston.func_145860_a(side) < 0.5F) {
				this.renderBlocks.renderPistonExtensionAllFaces(block, tileEntityEnderPiston.xCoord,
						tileEntityEnderPiston.yCoord, tileEntityEnderPiston.zCoord, false);
			} else if (tileEntityEnderPiston.func_145867_d() && !tileEntityEnderPiston.isExtending()) {
				TMNBlocks.ender_piston_head.func_150086_a(((BlockEnderPistonBase) block).getPistonExtensionTexture());
				this.renderBlocks.renderPistonExtensionAllFaces(TMNBlocks.ender_piston_head,
						tileEntityEnderPiston.xCoord, tileEntityEnderPiston.yCoord, tileEntityEnderPiston.zCoord,
						tileEntityEnderPiston.func_145860_a(side) < 0.5F);
				TMNBlocks.ender_piston_head.func_150087_e();
				tessellator.setTranslation((double) ((float) x - (float) tileEntityEnderPiston.xCoord),
						(double) ((float) y - (float) tileEntityEnderPiston.yCoord),
						(double) ((float) z - (float) tileEntityEnderPiston.zCoord));
				this.renderBlocks.renderPistonBaseAllFaces(block, tileEntityEnderPiston.xCoord,
						tileEntityEnderPiston.yCoord, tileEntityEnderPiston.zCoord);
			} else {
				this.renderBlocks.renderBlockAllFaces(block, tileEntityEnderPiston.xCoord,
						tileEntityEnderPiston.yCoord, tileEntityEnderPiston.zCoord);
			}

			tessellator.setTranslation(0.0D, 0.0D, 0.0D);
			tessellator.draw();
			RenderHelper.enableStandardItemLighting();
		}
	}

	public void renderInWorld(World world) {
		this.renderBlocks = new RenderBlocks(world);
	}

	public void renderTileEntityAt(TileEntity tileEntityEnderPiston, double x, double y, double z, float side) {
		this.renderTileEntityAt((TileEntityEnderPiston) tileEntityEnderPiston, x, y, z, side);
	}
}
