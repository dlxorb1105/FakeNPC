package dev.kobi;

import org.bukkit.plugin.java.JavaPlugin;

import dev.kobi.commands.FNPCCommand;
import dev.kobi.data.NPCStore;

public class FakeNPC extends JavaPlugin {
	
	public static final NPCStore NPC_STORE = new NPCStore(); 
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	@Override
	public void onEnable() {
		registerCommands();
	}	
	
	private void registerCommands() {
		FNPCCommand fnpcCommand = new FNPCCommand();
		getCommand("fnpc").setExecutor(fnpcCommand);
		getCommand("fnpc").setTabCompleter(fnpcCommand);
	}
}
