package com.theslarfab.tmnmod.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEnderSlimeball extends EntityThrowable {

	public EntityEnderSlimeball(World world) {
		super(world);
	}

	public EntityEnderSlimeball(World world, EntityLivingBase livingBase) {
		super(world, livingBase);
	}

	public EntityEnderSlimeball(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	protected void onImpact(MovingObjectPosition movingObjectPosition) {
		if (movingObjectPosition.entityHit != null) {
			byte b0 = 0;

			if (movingObjectPosition.entityHit instanceof EntityBlaze) {
				b0 = 3;
			}

			movingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()),
					(float) b0);
		}

		for (int i = 0; i < 8; ++i) {
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}

		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
}