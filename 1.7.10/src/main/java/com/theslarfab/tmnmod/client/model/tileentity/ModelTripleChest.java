/**
	Copyright (C) <2016>  <TheSlarFab>

    This file is part of the TheSlarFab TooMuchNatventure Mod; as such, 
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

package com.theslarfab.tmnmod.client.model.tileentity;

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
