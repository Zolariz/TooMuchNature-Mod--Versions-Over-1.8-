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

// only for testing purposes

package com.slarmods.tmnmod.creativetabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class TMNCreativeTabs {
	
	public static CreativeTabs tabTestInventory;

	public static void registerTabs() {
		
		tabTestInventory = (new CreativeTabs("testInventory")
	    {
	        @SideOnly(Side.CLIENT)
	        public Item getTabIconItem()
	        {
	            return Item.getItemFromBlock(Blocks.ender_chest);
	        }
	    }).setBackgroundImageName("inventory.png").setNoScrollbar().setNoTitle();
	}
}