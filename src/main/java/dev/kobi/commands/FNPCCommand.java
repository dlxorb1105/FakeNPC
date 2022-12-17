package dev.kobi.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class FNPCCommand implements TabExecutor {
	private String[] helpLines;
	private List<String> tabCommandList;
	
	public FNPCCommand() {
		helpLines = new String[11];
		
		helpLines[0] = "/fnpc help <page>";
		helpLines[1] = "/fnpc list";
		helpLines[2] = "/fnpc create <name>";
		helpLines[3] = "/fnpc remove <name>";
		helpLines[4] = "/fnpc sel (id/name)";
		helpLines[5] = "/fnpc rename (name)";
		helpLines[6] = "/fnpc type <entity>"; 
		helpLines[7] = "/fnpc moveto <x> <y> <z>";
		helpLines[8] = "/fnpc tp";
		helpLines[9] = "/fnpc look";
		helpLines[10] = "/fnpc equip";
		
		tabCommandList = new ArrayList<String>();
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
		tabCommandList.clear();
		return tabCommandList;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!cmd.getName().equalsIgnoreCase("fnpc")) {
			return false;
		}
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			int argsLength = args.length;
						
			if (argsLength == 0) {
				help(player, 0);
			} else {
				String arg0 = args[0].toLowerCase();
				switch (arg0) {
				case "help":
					if (argsLength == 1) {
						help(player, 1);
					} else {
						Integer pageNumber = Integer.valueOf(args[1]);
						
						if (pageNumber == null) {
							player.sendMessage(ChatColor.DARK_RED + "숫자 형식이 아닙니다");
							return false;
						} else {
							help(player, pageNumber);							
						}
					}
					
					break;
				case "list":
					
					
					break;
				case "create":
					
					break;
				case "remove":
					
					break;
				case "sel":
					
					break;
				case "rename":
					
					break;
				case "type":
					
					break;
				case "moveto":
					
					break;
				case "tp":
					
					break;
				case "look":
					
					break;
				case "equip":
					
					break;
				default:
					break;
				}
			}
		} else if (sender instanceof ConsoleCommandSender) {
			sender.sendMessage("You are not player!");
		}
		return false;
	}

	private void help(Player player, int pageNumber) {
		int linePerPage = 8;
		int modPage = helpLines.length / linePerPage;
		int maxPage = (helpLines.length % linePerPage == 0) ? modPage : modPage + 1;
		
		player.sendMessage(ChatColor.YELLOW + "--------help " + pageNumber + "/" + maxPage + " page--------");  
		
		if (pageNumber >= 0 && pageNumber <= maxPage) {	
			int startIndex = (pageNumber - 1) * linePerPage;
			int elseLine = helpLines.length % linePerPage;
			
			int endIndex = startIndex + ((pageNumber == 1)  ? linePerPage - 1 : elseLine - 1);

			for (int i = startIndex; i <= endIndex; i++) {
				player.sendMessage(helpLines[i]);
			}
		}
	}
	
}
