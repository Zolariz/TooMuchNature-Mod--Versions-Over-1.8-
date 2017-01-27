package com.theslarfab.tmnmod.init;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.entity.monster.EntityEnderSlime;
import com.theslarfab.tmnmod.entity.EntityKangaroo;
import com.theslarfab.tmnmod.entity.EntityLonghorn;
import com.theslarfab.tmnmod.entity.EntityZebra;
import com.theslarfab.tmnmod.entity.list.TMNEntityList;
import com.theslarfab.tmnmod.entity.projectile.EntityEnderGunBullet;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class TMNEntities {

	public static void init() {
		TMNEntities.registerEntities();
		TMNEntities.registerSpawnEggs();
	}

	public static void registerEntities() {
		int modEntityID = 0;
		EntityRegistry.registerModEntity(EntityKangaroo.class, "kangaroo", ++modEntityID, TooMuchNature.instance, 80, 3,
				false);
		EntityRegistry.registerModEntity(EntityLonghorn.class, "texas_longhorn", ++modEntityID, TooMuchNature.instance,
				80, 3, false);
		EntityRegistry.registerModEntity(EntityZebra.class, "zebra", ++modEntityID, TooMuchNature.instance, 80, 3,
				false);
		EntityRegistry.registerModEntity(EntityEnderSlime.class, "ender_slime", ++modEntityID, TooMuchNature.instance, 80,
				3, false);
		EntityRegistry.registerModEntity(EntityEnderGunBullet.class, "ender_gun_bullet", ++modEntityID,
				TooMuchNature.instance, 80, 3, false);
	}

	public static void registerSpawnEggs() {
		TMNEntityList.addMapping(EntityKangaroo.class, "kangaroo", 0x558299, 0x997256);
		TMNEntityList.addMapping(EntityLonghorn.class, "texas_longhorn", 0xEB7900, 0xADADAD);
		TMNEntityList.addMapping(EntityZebra.class, "zebra", 0xFFFFFF, 0x212121);
		TMNEntityList.addMapping(EntityEnderSlime.class, "ender_slime", 0xBB9FC4, 0x8E7B94);
		TMNEntityList.addMapping(EntityEnderGunBullet.class, "ender_bullet");
	}

	public static void addEntitySpawn() {
		EntityRegistry.addSpawn(EntityLonghorn.class, 6, 3, 4, EnumCreatureType.creature, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntityZebra.class, 7, 3, 5, EnumCreatureType.creature, BiomeGenBase.savanna,
				BiomeGenBase.savannaPlateau);
	}
}
