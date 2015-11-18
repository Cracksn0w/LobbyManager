package com.cracksn0w.lobbymanager;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.cracksn0w.lobbymanager.lobby.Lobby;

public class LobbyManager {

	private LobbyManagerPlugin plugin;
	private ArrayList<Lobby> lobbys;
	
	public LobbyManager(LobbyManagerPlugin plugin) {
		this.plugin = plugin;
		lobbys = new ArrayList<>();
	}
	
	public void registerLobby(Lobby lobby) {
		lobbys.add(lobby);
	}
	
	public ArrayList<Lobby> getLobbys() {
		return lobbys;
	}
	
	public boolean hasLobby(Player player) {
		for(Lobby lob : lobbys) {
			if(lob.hasPlayer(player)) return true;
		}
		
		return false;
	}
	
	public Lobby getLobby(Player player) {
		for(Lobby lob : lobbys) {
			if(lob.hasPlayer(player)) return lob;
		}
		
		return null;
	}
	
}