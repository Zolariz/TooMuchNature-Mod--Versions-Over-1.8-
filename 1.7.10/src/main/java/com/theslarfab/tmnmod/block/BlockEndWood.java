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

package com.theslarfab.tmnmod.block;

import java.util.List;

import com.theslarfab.tmnmod.TooMuchNatventure;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockEndWood extends Block {

	public static final String[] planks = new String[] { "end_oak", "dark_end_oak", "light_end_oak" };

	@SideOnly(Side.CLIENT)
	private IIcon[] iiicon;

	public BlockEndWood(Material wood) {
		super(Material.wood);
		this.setCreativeTab(TooMuchNatventure.tabTMNBlocks);
		this.setHardness(2.0F);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int meta, int icon) {
		if (icon < 0 || icon >= this.iiicon.length) {
			icon = 0;
		}

		return this.iiicon[icon];
	}

	public int damageDropped(int damageDrop) {
		return damageDrop;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iiicon = new IIcon[planks.length];

		for (int i = 0; i < this.iiicon.length; ++i) {
			this.iiicon[i] = iconRegister.registerIcon(this.getTextureName() + "_" + planks[i]);
		}
	}
}