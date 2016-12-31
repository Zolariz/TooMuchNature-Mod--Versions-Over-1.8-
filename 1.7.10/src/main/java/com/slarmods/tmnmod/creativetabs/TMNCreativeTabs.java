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