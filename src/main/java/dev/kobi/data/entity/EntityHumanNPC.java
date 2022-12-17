package dev.kobi.data.entity;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;

public class EntityHumanNPC implements CustomNPC {

	@Override
	public void createNPC(Player player) {
		MinecraftServer nmsServer = ((CraftServer)Bukkit.getServer()).getServer();
		WorldServer nmsWorld = ((CraftWorld) player.getWorld()).getHandle();
		GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "Bob");
		
		EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile);
		CraftPlayer craftPlayer = npc.getBukkitEntity();
		craftPlayer.setCustomName("");
		
	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub
	}

	@Override
	public void despawn() {
		// TODO Auto-generated method stub
		
	}
}
