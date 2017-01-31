package com.theslarfab.tmnmod.item;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.entity.projectile.EntityEnderGunBullet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemEnderGun extends Item {

	public ItemEnderGun() {
		super();
		setMaxDamage(0);
		maxStackSize = 1;
		setCreativeTab(TooMuchNatventure.tabTMNMisc);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, final EntityPlayer entityPlayer) {

		ArrowNockEvent event = new ArrowNockEvent(entityPlayer, itemStack);
		boolean flag = entityPlayer.capabilities.isCreativeMode
				|| EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;

		if (flag || entityPlayer.inventory.hasItem(Items.coal)) {
			float f = 5.0F;

			EntityEnderGunBullet entityarrow = new EntityEnderGunBullet(world, entityPlayer, f * 2.0F) {

				public void onCollideWithPlayer(EntityPlayer entity) {
					super.onCollideWithPlayer(entity);
					int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
					int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
					int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
					World world = this.worldObj;

				}

				public void onUpdate() {
					super.onUpdate();
					int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
					int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
					int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
					World world = this.worldObj;
					Entity entity = (Entity) entityPlayer;

					if (this.worldObj.getBlock(i, j, k) != Blocks.air
							|| this.worldObj.getBlock(i, j - 1, k) != Blocks.air
							|| this.worldObj.getBlock(i, j + 1, k) != Blocks.air
							|| this.worldObj.getBlock(i + 1, j, k) != Blocks.air
							|| this.worldObj.getBlock(i - 1, j, k) != Blocks.air
							|| this.worldObj.getBlock(i, j, k + 1) != Blocks.air
							|| this.worldObj.getBlock(i, j, k - 1) != Blocks.air) {

						this.kill();
					}

				}

			};

			entityarrow.setIsCritical(false);
			entityarrow.setDamage(1.9);
			entityarrow.setKnockbackStrength(1);

			itemStack.damageItem(0, entityPlayer);
			world.playSoundAtEntity(entityPlayer, "random.explode", 1.0F, 2.0F);
			world.playSoundAtEntity(entityPlayer, "mob.blaze.hit", 1.0F, 1.0F);

			if (flag) {
				entityarrow.canBePickedUp = 2;
			} else {
				entityPlayer.inventory.consumeInventoryItem(Items.coal);
			}

			if (!world.isRemote) {
				world.spawnEntityInWorld(entityarrow);
			}
			World world1 = world;
			EntityPlayer entity = entityPlayer;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;

		}

		return itemStack;
	}

	public EnumAction getItemUseAction(ItemStack itemStack) {
		return EnumAction.bow;
	}
}
