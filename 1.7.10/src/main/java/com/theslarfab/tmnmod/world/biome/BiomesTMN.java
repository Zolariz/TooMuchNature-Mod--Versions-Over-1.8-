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

package com.theslarfab.tmnmod.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class BiomesTMN {

	public static BiomeGenBase cherryForest;
	public static BiomeGenBase rainforest;

	public static void init() {
		BiomesTMN.registerBiomes();
	}

	public static void registerBiomes() {
		cherryForest = new BiomeGenCherryForest(40).setBiomeName("Cherry Forest");
		BiomeDictionary.registerBiomeType(cherryForest, Type.FOREST);
		BiomeManager.warmBiomes.add(new BiomeEntry(cherryForest, 10));
		BiomeManager.addSpawnBiome(cherryForest);

		rainforest = new BiomeGenRainforest(41).setBiomeName("Rainforest");
		BiomeDictionary.registerBiomeType(rainforest, Type.FOREST);
		BiomeManager.warmBiomes.add(new BiomeEntry(rainforest, 10));
	}
}
