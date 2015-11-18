package com.cracksn0w.lobbymanager.lobby;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyInfoItem {

	Player player;
	Lobby lobby;
	ItemStack itemstack;
	
	public LobbyInfoItem(Player player, Lobby lobby) {
		this.player = player;
		this.lobby = lobby;
		
		itemstack = new ItemStack(Material.STICK, 1);
		refresh();
	}
	
	public Player getOwner() {
		return player;
	}
	
	public Lobby getLobby() {
		return lobby;
	}
	
	public ItemStack getItemStack() {
		return itemstack;
	}
	
	public void refresh() {
		ItemMeta meta = itemstack.getItemMeta();
		List<String> lore = new ArrayList<>();
		
		meta.setDisplayName(ChatColor.GOLD + "Lobby");
		lore.add("Player Counter: " + lobby.getPlayerCount());
		meta.setLore(lore);
		
		itemstack.setItemMeta(meta);
	}
	
}