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

package com.slarmods.tmnmod.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenCherryForest extends BiomeGenBase {

	public static int treesPerChunk;
	private static int grassPerChunk;

	public BiomeGenCherryForest(int id) {
		super(id);

		this.setHeight(height_LowPlains);
		this.setColor(4915021);
		this.setTemperatureRainfall(0.7F, 0.8F);
		this.isEqualTo(forest);

		BiomeGenCherryForest.treesPerChunk = 5;
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 4915021;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 2878766;
	}
}
