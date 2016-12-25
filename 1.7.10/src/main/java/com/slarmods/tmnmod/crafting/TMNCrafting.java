/**
	Copyright (C) <2016>  <TheSlarFab>

    This file is part of the TheSlarFab TooMuchNature Mod; as such, 
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

package com.slarmods.tmnmod.crafting;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.crafting.remover.RecipeRemover;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TMNCrafting {

	public static void register() {

		RecipeRemover.removeRecipe();

		GameRegistry.addRecipe(new ItemStack(TooMuchNature.kangaroo_helm),
				new Object[] { "###", "# #", "   ", '#', TooMuchNature.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TooMuchNature.kangaroo_helm),
				new Object[] { "   ", "###", "# #", '#', TooMuchNature.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TooMuchNature.kangaroo_boots),
				new Object[] { "# #", "# #", "   ", '#', TooMuchNature.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TooMuchNature.kangaroo_boots),
				new Object[] { "   ", "# #", "# #", '#', TooMuchNature.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TooMuchNature.kangaroo_chest),
				new Object[] { "# #", "###", "###", '#', TooMuchNature.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TooMuchNature.kangaroo_leggings),
				new Object[] { "###", "# #", "# #", '#', TooMuchNature.kangaroo_skin });

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wooden_button),
				new Object[] { TooMuchNature.cherry_planks });

		GameRegistry.addShapelessRecipe(new ItemStack(TooMuchNature.cherry_planks, 4),
				new Object[] { TooMuchNature.cherry_log });

		GameRegistry.addRecipe(new ItemStack(Items.stick, 6), new Object[] { "   ", "###", "###", '#', Items.stick });
		GameRegistry.addRecipe(new ItemStack(Items.stick, 6), new Object[] { "###", "###", "   ", '#', Items.stick });

		GameRegistry.addShapedRecipe(new ItemStack(Blocks.fence, 3),
				new Object[] { "   ", "#X#", "#X#", Character.valueOf('#'), new ItemStack(Blocks.planks, 1, 0),
						Character.valueOf('X'), new ItemStack(Items.stick, 1, 0), });
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.fence, 3),
				new Object[] { "#X#", "#X#", "   ", Character.valueOf('#'), new ItemStack(Blocks.planks, 1, 0),
						Character.valueOf('X'), new ItemStack(Items.stick, 1, 0), });
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.fence_gate, 1),
				new Object[] { "   ", "#X#", "#X#", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 0),
						Character.valueOf('#'), new ItemStack(Items.stick, 1, 0), });
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.fence_gate, 1),
				new Object[] { "#X#", "#X#", "   ", Character.valueOf('X'), new ItemStack(Blocks.planks, 1, 0),
						Character.valueOf('#'), new ItemStack(Items.stick, 1, 0), });

		GameRegistry.addShapedRecipe(new ItemStack(TooMuchNature.cherry_fence, 3),
				new Object[] { "   ", "#X#", "#X#", Character.valueOf('#'),
						new ItemStack(TooMuchNature.cherry_planks, 1, 0), Character.valueOf('X'),
						new ItemStack(Items.stick, 1, 0), });
		GameRegistry.addShapedRecipe(new ItemStack(TooMuchNature.cherry_fence, 3),
				new Object[] { "#X#", "#X#", "   ", Character.valueOf('#'),
						new ItemStack(TooMuchNature.cherry_planks, 1, 0), Character.valueOf('X'),
						new ItemStack(Items.stick, 1, 0), });
		GameRegistry.addShapedRecipe(new ItemStack(TooMuchNature.cherry_fence_gate, 1),
				new Object[] { "   ", "#X#", "#X#", Character.valueOf('X'),
						new ItemStack(TooMuchNature.cherry_planks, 1, 0), Character.valueOf('#'),
						new ItemStack(Items.stick, 1, 0), });
		GameRegistry.addShapedRecipe(new ItemStack(TooMuchNature.cherry_fence_gate, 1),
				new Object[] { "#X#", "#X#", "   ", Character.valueOf('X'),
						new ItemStack(TooMuchNature.cherry_planks, 1, 0), Character.valueOf('#'),
						new ItemStack(Items.stick, 1, 0), });

		GameRegistry.addShapedRecipe(new ItemStack(Blocks.crafting_table, 1),
				new Object[] { "##", "##", Character.valueOf('#'), new ItemStack(TooMuchNature.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(Items.stick, 4),
				new Object[] { "# ", "# ", Character.valueOf('#'), new ItemStack(TooMuchNature.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(Items.stick, 4),
				new Object[] { " #", " #", Character.valueOf('#'), new ItemStack(TooMuchNature.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(TooMuchNature.item_cherry_door, 1), new Object[] { "## ", "## ",
				"## ", Character.valueOf('#'), new ItemStack(TooMuchNature.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(TooMuchNature.item_cherry_door, 1), new Object[] { " ##", " ##",
				" ##", Character.valueOf('#'), new ItemStack(TooMuchNature.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(TooMuchNature.cherry_slab, 3), new Object[] { "###", "   ", "   ",
				Character.valueOf('#'), new ItemStack(TooMuchNature.cherry_planks, 1, 0) });

	}
}
