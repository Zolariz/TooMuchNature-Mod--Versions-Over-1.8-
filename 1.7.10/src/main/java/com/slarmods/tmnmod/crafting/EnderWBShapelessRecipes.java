package com.slarmods.tmnmod.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class EnderWBShapelessRecipes implements IRecipe {
	
	private final ItemStack recipeOutput;
	public final List recipeItems;

	public EnderWBShapelessRecipes(ItemStack itemstack, List list) {
		this.recipeOutput = itemstack;
		this.recipeItems = list;
	}

	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

	public boolean matches(InventoryCrafting invCrafting, World world) {
		ArrayList arraylist = new ArrayList(this.recipeItems);

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				ItemStack itemstack = invCrafting.getStackInRowAndColumn(j, i);

				if (itemstack != null) {
					boolean flag = false;
					Iterator iterator = arraylist.iterator();

					while (iterator.hasNext()) {
						ItemStack itemstack1 = (ItemStack) iterator.next();

						if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767
								|| itemstack.getItemDamage() == itemstack1.getItemDamage())) {
							flag = true;
							arraylist.remove(itemstack1);
							break;
						}
					}

					if (!flag) {
						return false;
					}
				}
			}
		}

		return arraylist.isEmpty();
	}

	public ItemStack getCraftingResult(InventoryCrafting invCrafting) {
		return this.recipeOutput.copy();
	}

	public int getRecipeSize() {
		return this.recipeItems.size();
	}
}
