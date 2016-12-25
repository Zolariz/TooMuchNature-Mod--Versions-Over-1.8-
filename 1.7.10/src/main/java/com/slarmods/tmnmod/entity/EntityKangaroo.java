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

package com.slarmods.tmnmod.entity;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityKangaroo extends EntityAnimal {

	public EntityKangaroo(World world) {
		super(world);
		this.setSize(0.9F, 1.6F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(22.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
	}

	protected String getLivingSound() {
		return TooMuchNature.modid + ":" + "kangaroosay";
	}

	protected String getHurtSound() {
		return TooMuchNature.modid + ":" + "kangaroohurt";
	}

	protected String getDeathSound() {
		return TooMuchNature.modid + ":" + "kangaroodeath";
	}

	protected void func_145780_a(int x, int y, int z, Block block) {
		this.playSound("mob.cow.step", 0.15F, 1.0F);
	}

	protected float getSoundVolume() {
		return 0.8F;
	}

	protected Item getDropItem() {
		return TooMuchNature.kangaroo_skin;
	}

	protected void dropFewItems(boolean drop, int i) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + i);
		int k;

		for (k = 0; k < j; ++k) {
			this.dropItem(TooMuchNature.kangaroo_skin, 1);
		}

		j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + i);

		for (k = 0; k < j; ++k) {
			if (this.isBurning()) {
				this.dropItem(TooMuchNature.cooked_kangaroo, 1);
			} else {
				this.dropItem(TooMuchNature.raw_kangaroo, 1);
			}
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityKangaroo(this.worldObj);
	}
}