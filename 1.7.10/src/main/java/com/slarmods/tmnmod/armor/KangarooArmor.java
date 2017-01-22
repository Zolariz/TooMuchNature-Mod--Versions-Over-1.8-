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

package com.slarmods.tmnmod.armor;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.item.TMNItems;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class KangarooArmor extends ItemArmor {

	public KangarooArmor(ArmorMaterial material, int id, int slot) {
		super(material, id, slot);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureMisc);

		if (slot == 0) {
			this.setTextureName(TooMuchNature.modid + ":kangaroo_helmet");
		} else if (slot == 1) {
			this.setTextureName(TooMuchNature.modid + ":kangaroo_chestplate");
		} else if (slot == 2) {
			this.setTextureName(TooMuchNature.modid + ":kangaroo_leggings");
		} else if (slot == 3) {
			this.setTextureName(TooMuchNature.modid + ":kangaroo_boots");
		}
	}

	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		if (itemstack.getItem() == TMNItems.kangaroo_helm || itemstack.getItem() == TMNItems.kangaroo_chest
				|| itemstack.getItem() == TMNItems.kangaroo_boots) {
			return TooMuchNature.modid + ":textures/model/armor/kangaroo_layer_1.png";
		} else if (itemstack.getItem() == TMNItems.kangaroo_leggings) {
			return TooMuchNature.modid + ":textures/model/armor/kangaroo_layer_2.png";
		} else
			return null;
	}
}
