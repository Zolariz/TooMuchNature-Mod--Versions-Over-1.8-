package com.slarmods.tmnmod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class EnderWorkbenchRecipeSorter implements Comparator {

	final EnderWorkbenchCraftingManager enderWorkbench;

	public EnderWorkbenchRecipeSorter(EnderWorkbenchCraftingManager enderWorkbenchCraftingManager) {
		enderWorkbench = enderWorkbenchCraftingManager;
	}

	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof EnderWBShapelessRecipes && irecipe2 instanceof EnderWBShapedRecipes ? 1
				: (irecipe2 instanceof EnderWBShapelessRecipes && irecipe1 instanceof EnderWBShapedRecipes ? -1
						: (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1
								: (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compare((IRecipe) o1, (IRecipe) o2);
	}
}
