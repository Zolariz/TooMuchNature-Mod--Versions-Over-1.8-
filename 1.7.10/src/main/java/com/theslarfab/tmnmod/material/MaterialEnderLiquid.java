package com.theslarfab.tmnmod.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialEnderLiquid extends Material {

	public MaterialEnderLiquid(MapColor mapColor) {
		super(mapColor);
		this.setReplaceable();
		this.setNoPushMobility();
	}

	public boolean isLiquid() {
		return true;
	}

	public boolean blocksMovement() {
		return false;
	}

	public boolean isSolid() {
		return false;
	}
}
