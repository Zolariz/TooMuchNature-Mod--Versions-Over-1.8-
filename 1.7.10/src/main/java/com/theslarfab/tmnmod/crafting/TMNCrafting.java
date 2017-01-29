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

package com.theslarfab.tmnmod.crafting;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.crafting.remover.RecipeRemover;
import com.theslarfab.tmnmod.init.TMNBlocks;
import com.theslarfab.tmnmod.init.TMNItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TMNCrafting {

	public static void register() {

		RecipeRemover.removeRecipe();

		GameRegistry.addRecipe(new ItemStack(TMNItems.kangaroo_helm),
				new Object[] { "###", "# #", "   ", '#', TMNItems.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TMNItems.kangaroo_helm),
				new Object[] { "   ", "###", "# #", '#', TMNItems.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TMNItems.kangaroo_boots),
				new Object[] { "# #", "# #", "   ", '#', TMNItems.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TMNItems.kangaroo_boots),
				new Object[] { "   ", "# #", "# #", '#', TMNItems.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TMNItems.kangaroo_chest),
				new Object[] { "# #", "###", "###", '#', TMNItems.kangaroo_skin });
		GameRegistry.addRecipe(new ItemStack(TMNItems.kangaroo_leggings),
				new Object[] { "###", "# #", "# #", '#', TMNItems.kangaroo_skin });

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wooden_button), new Object[] { TMNBlocks.cherry_planks });

		GameRegistry.addShapelessRecipe(new ItemStack(TMNBlocks.cherry_planks, 4),
				new Object[] { TMNBlocks.cherry_log });

		GameRegistry.addShapedRecipe(new ItemStack(TMNBlocks.cherry_fence, 3),
				new Object[] { "   ", "#X#", "#X#", Character.valueOf('#'),
						new ItemStack(TMNBlocks.cherry_planks, 1, 0), Character.valueOf('X'),
						new ItemStack(Items.stick, 1, 0), });
		GameRegistry.addShapedRecipe(new ItemStack(TMNBlocks.cherry_fence, 3),
				new Object[] { "#X#", "#X#", "   ", Character.valueOf('#'),
						new ItemStack(TMNBlocks.cherry_planks, 1, 0), Character.valueOf('X'),
						new ItemStack(Items.stick, 1, 0), });
		GameRegistry.addShapedRecipe(new ItemStack(TMNBlocks.cherry_fence_gate, 1),
				new Object[] { "   ", "#X#", "#X#", Character.valueOf('X'),
						new ItemStack(TMNBlocks.cherry_planks, 1, 0), Character.valueOf('#'),
						new ItemStack(Items.stick, 1, 0), });
		GameRegistry.addShapedRecipe(new ItemStack(TMNBlocks.cherry_fence_gate, 1),
				new Object[] { "#X#", "#X#", "   ", Character.valueOf('X'),
						new ItemStack(TMNBlocks.cherry_planks, 1, 0), Character.valueOf('#'),
						new ItemStack(Items.stick, 1, 0), });

		GameRegistry.addShapedRecipe(new ItemStack(Blocks.crafting_table, 1),
				new Object[] { "##", "##", Character.valueOf('#'), new ItemStack(TMNBlocks.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(Items.stick, 4),
				new Object[] { "# ", "# ", Character.valueOf('#'), new ItemStack(TMNBlocks.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(Items.stick, 4),
				new Object[] { " #", " #", Character.valueOf('#'), new ItemStack(TMNBlocks.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(TMNItems.item_cherry_door, 1),
				new Object[] { "## ", "##&", "## ", Character.valueOf('#'),
						new ItemStack(TMNBlocks.cherry_planks, 1, 0), Character.valueOf('&'),
						new ItemStack(Items.wooden_door, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(TMNItems.item_cherry_door, 1), new Object[] { " ##", " ##", " ##",
				Character.valueOf('#'), new ItemStack(TMNBlocks.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(TMNBlocks.cherry_slab, 3), new Object[] { "###", "   ", "   ",
				Character.valueOf('#'), new ItemStack(TMNBlocks.cherry_planks, 1, 0) });

		GameRegistry.addShapedRecipe(new ItemStack(TMNBlocks.enderald_block, 1), new Object[] { "###", "###", "###",
				Character.valueOf('#'), new ItemStack(TMNItems.enderald, 1, 0) });
	}
}
