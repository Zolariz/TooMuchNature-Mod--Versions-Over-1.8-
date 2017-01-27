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

package com.theslarfab.tmnmod.command.server;

import java.util.List;

import com.theslarfab.tmnmod.entity.list.TMNEntityList;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class CommandSummonTMN extends CommandBase implements ICommand {

	public String getCommandName() {
		return "tmnspawn";
	}

	/**
	 * Return the required permission level for this command.
	 */
	public int getRequiredPermissionLevel() {
		return 2;
	}

	public String getCommandUsage(ICommandSender commandsender) {
		return "commands.tmnspawn.usage";
	}

	public void processCommand(ICommandSender commandsender, String[] p_71515_2_) {
		if (p_71515_2_.length < 1) {
			throw new WrongUsageException("commands.tmnspawn.usage", new Object[0]);
		} else {
			String s = p_71515_2_[0];
			double d0 = (double) commandsender.getPlayerCoordinates().posX + 0.5D;
			double d1 = (double) commandsender.getPlayerCoordinates().posY;
			double d2 = (double) commandsender.getPlayerCoordinates().posZ + 0.5D;

			if (p_71515_2_.length >= 4) {
				d0 = func_110666_a(commandsender, d0, p_71515_2_[1]);
				d1 = func_110666_a(commandsender, d1, p_71515_2_[2]);
				d2 = func_110666_a(commandsender, d2, p_71515_2_[3]);
			}

			World world = commandsender.getEntityWorld();

			if (!world.blockExists((int) d0, (int) d1, (int) d2)) {
				func_152373_a(commandsender, this, "commands.summon.outOfWorld", new Object[0]);
			} else {
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				boolean flag = false;

				if (p_71515_2_.length >= 5) {
					IChatComponent ichatcomponent = func_147178_a(commandsender, p_71515_2_, 4);

					try {
						NBTBase nbtbase = JsonToNBT.func_150315_a(ichatcomponent.getUnformattedText());

						if (!(nbtbase instanceof NBTTagCompound)) {
							func_152373_a(commandsender, this, "commands.summon.tagError",
									new Object[] { "Not a valid tag" });
							return;
						}

						nbttagcompound = (NBTTagCompound) nbtbase;
						flag = true;
					} catch (NBTException nbtexception) {
						func_152373_a(commandsender, this, "commands.summon.tagError",
								new Object[] { nbtexception.getMessage() });
						return;
					}
				}

				nbttagcompound.setString("id", s);
				Entity entity1 = TMNEntityList.createEntityFromNBT(nbttagcompound, world);

				if (entity1 == null) {
					func_152373_a(commandsender, this, "commands.summon.failed", new Object[0]);
				} else {
					entity1.setLocationAndAngles(d0, d1, d2, entity1.rotationYaw, entity1.rotationPitch);

					if (!flag && entity1 instanceof EntityLiving) {
						((EntityLiving) entity1).onSpawnWithEgg((IEntityLivingData) null);
					}

					world.spawnEntityInWorld(entity1);
					Entity entity2 = entity1;

					for (NBTTagCompound nbttagcompound1 = nbttagcompound; entity2 != null && nbttagcompound1
							.hasKey("Riding", 10); nbttagcompound1 = nbttagcompound1.getCompoundTag("Riding")) {
						Entity entity = TMNEntityList.createEntityFromNBT(nbttagcompound1.getCompoundTag("Riding"),
								world);

						if (entity != null) {
							entity.setLocationAndAngles(d0, d1, d2, entity.rotationYaw, entity.rotationPitch);
							world.spawnEntityInWorld(entity);
							entity2.mountEntity(entity);
						}

						entity2 = entity;
					}

					func_152373_a(commandsender, this, "commands.summon.success", new Object[0]);
				}
			}
		}
	}

	/**
	 * Adds the strings available in this command to the given list of tab
	 * completion options.
	 */
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
		return p_71516_2_.length == 1 ? getListOfStringsMatchingLastWord(p_71516_2_, this.func_147182_d()) : null;
	}

	protected String[] func_147182_d() {
		return (String[]) TMNEntityList.func_151515_b().toArray(new String[0]);
	}
}