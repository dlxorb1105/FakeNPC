package dev.kobi.data.entity;

import org.bukkit.entity.Player;

public interface CustomNPC {
	void createNPC(Player player);
	void spawn();
	void despawn();
}
