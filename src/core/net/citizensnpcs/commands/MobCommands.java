package net.citizensnpcs.commands;

import net.citizensnpcs.PermissionManager;
import net.citizensnpcs.api.CommandHandler;
import net.citizensnpcs.resources.npclib.HumanNPC;
import net.citizensnpcs.resources.sk89q.Command;
import net.citizensnpcs.resources.sk89q.CommandContext;
import net.citizensnpcs.resources.sk89q.CommandPermissions;
import net.citizensnpcs.resources.sk89q.CommandRequirements;

import org.bukkit.entity.Player;

public class MobCommands implements CommandHandler {
	@CommandRequirements()
	@Command(
			aliases = "npcspawn",
			usage = "npcspawn [type]",
			desc = "spawn a mob npc",
			min = 1,
			max = 1)
	@CommandPermissions("creature.spawn")
	public static void spawn(CommandContext args, Player player, HumanNPC npc) {

	}

	@Override
	public void addPermissions() {
		PermissionManager.addPerm("creature.spawn");
	}
}