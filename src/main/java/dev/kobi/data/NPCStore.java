package dev.kobi.data;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.server.level.EntityPlayer;

public class NPCStore {
	private List<EntityPlayer> npcs = Lists.newArrayList();
	
	public void addNPC(EntityPlayer npc) {
		npcs.add(npc);
	}
	
	public void removeNPC(int index) {
		npcs.remove(index);
	}
}
