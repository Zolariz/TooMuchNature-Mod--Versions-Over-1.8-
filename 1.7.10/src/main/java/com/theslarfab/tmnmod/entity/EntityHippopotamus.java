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

package com.theslarfab.tmnmod.entity;

import java.util.List;
import java.util.UUID;

import com.theslarfab.tmnmod.TooMuchNature;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityHippopotamus extends EntityAnimal {

	private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = (new AttributeModifier(field_110189_bq,
			"Attacking speed boost", 0.45D, 0)).setSaved(false);
	/** Above zero if this PigZombie is Angry. */
	private int angerLevel;
	/** A random delay until this PigZombie next makes a sound. */
	private int randomSoundDelay;
	private Entity field_110191_bu;

	public EntityHippopotamus(World world) {
		super(world);
		this.setSize(1.5F, 2.5F);
		this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(4, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(5, new EntityAITempt(this, 1.25D, Item.getItemFromBlock(Blocks.hay_block), false));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}

	public boolean isAIEnabled() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(55.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
	}
	
	public void onUpdate() {
		if (this.field_110191_bu != this.entityToAttack && !this.worldObj.isRemote) {
			IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			iattributeinstance.removeModifier(field_110190_br);

			if (this.entityToAttack != null) {
				iattributeinstance.applyModifier(field_110190_br);
			}
		}

		this.field_110191_bu = this.entityToAttack;

		if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
			this.playSound("hipporoar", this.getSoundVolume() * 2.0F,
					((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
		}

		super.onUpdate();
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		super.writeEntityToNBT(nbttagcompound);
		nbttagcompound.setShort("Anger", (short) this.angerLevel);
	}

	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		super.readEntityFromNBT(p_70037_1_);
		this.angerLevel = p_70037_1_.getShort("Anger");
	}

	protected Entity findPlayerToAttack() {
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	public boolean attackEntityFrom(DamageSource source, float par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity entity = source.getEntity();

			if (entity instanceof EntityPlayer) {
				List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
						this.boundingBox.expand(32.0D, 32.0D, 32.0D));

				for (int i = 0; i < list.size(); ++i) {
					Entity entity1 = (Entity) list.get(i);

					if (entity1 instanceof EntityHippopotamus) {
						EntityHippopotamus entityhippopotamus = (EntityHippopotamus) entity1;
						entityhippopotamus.becomeAngryAt(entity);
					}
				}

				this.becomeAngryAt(entity);
			}

			return super.attackEntityFrom(source, par2);
		}
	}

	private void becomeAngryAt(Entity entity) {
		this.entityToAttack = entity;
		this.angerLevel = 400 + this.rand.nextInt(400);
		this.randomSoundDelay = this.rand.nextInt(40);
	}

	protected String getLivingSound() {
		return TooMuchNature.modid + ":" + "hipposay";
	}

	protected String getHurtSound() {
		return TooMuchNature.modid + ":" + "hippohit";
	}

	protected String getDeathSound() {
		return TooMuchNature.modid + ":" + "hippodeath";
	}

	public boolean canMateWith(EntityAnimal animal) {
		return animal == this ? false
				: (animal.getClass() != this.getClass() ? false : this.isInLove() && animal.isInLove());
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityHippopotamus(this.worldObj);
	}
}
