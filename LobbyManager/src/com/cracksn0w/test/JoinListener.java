package com.cracksn0w.test;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

import com.cracksn0w.lobbymanager.LobbyManagerPlugin;
import com.cracksn0w.lobbymanager.lobby.Lobby;
import com.cracksn0w.lobbymanager.lobby.LobbyInfoItem;

public class JoinListener implements Listener {

	LobbyManagerPlugin plugin;
	
	ArrayList<LobbyInfoItem> infoitems;
	
	public JoinListener(LobbyManagerPlugin plugin) {
		this.plugin = plugin;
		
		infoitems = new ArrayList<>();
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		Lobby lobby = plugin.getLobbyManager().getLobbys().get(0);
		lobby.joinToLobby(p);
		
		LobbyInfoItem item = new LobbyInfoItem(p, lobby);
		p.getInventory().addItem(item.getItemStack());
		infoitems.add(item);
		
		Scoreboard board = ScoreboardAPI.createScoreboard(ChatColor.GOLD + "Test");
		ScoreboardAPI.addText(board, "Hallo");
		
		p.setScoreboard(board);
		
		p.sendMessage("Hallo in deiner Lobby sind gerade " + lobby.getPlayerCount() + " Spieler!");
		
		for(LobbyInfoItem lii : infoitems) {
			lii.refresh();
		}
	}
	
}