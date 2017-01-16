package com.slarmods.tmnmod.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialEnderLiquid extends Material {

	public MaterialEnderLiquid(MapColor p_i2114_1_) {
		super(p_i2114_1_);
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
