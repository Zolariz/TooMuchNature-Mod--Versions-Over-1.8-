package com.slarmods.tmnmod.client.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelTripleChest - TheSlarFab
 * Created using Tabula 4.1.1
 */
public class ModelTripleChest extends ModelChest {
    public ModelRenderer chestKnob;
    public ModelRenderer chestLid;
    public ModelRenderer chestBelow;

    public ModelTripleChest() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.chestLid = new ModelRenderer(this, 0, 0);
        this.chestLid.setRotationPoint(1.0F, 7.0F, 15.0F);
        this.chestLid.addBox(0.0F, -5.0F, -14.0F, 44, 5, 14, 0.0F);
        this.chestBelow = new ModelRenderer(this, 0, 19);
        this.chestBelow.setRotationPoint(1.0F, 6.0F, 1.0F);
        this.chestBelow.addBox(0.0F, 0.0F, 0.0F, 44, 10, 14, 0.0F);
        this.chestKnob = new ModelRenderer(this, 0, 0);
        this.chestKnob.setRotationPoint(23.0F, 7.0F, 15.0F);
        this.chestKnob.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
    }
}
