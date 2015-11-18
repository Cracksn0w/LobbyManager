package com.cracksn0w.lobbymanager.lobby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Lobby {

	private World world;
	private ArrayList<Player> players;
	private HashMap<UUID, Location> old_locations;
	private int online_players;
	
	public Lobby(World world) {
		this.world = world;
		players = new ArrayList<>();
		old_locations = new HashMap<>();
		online_players = 0;
	}
	
	public void joinToLobby(Player player) {
		players.add(player);
		old_locations.put(player.getUniqueId(), player.getLocation());
		player.teleport(world.getSpawnLocation());
		
		online_players ++;
	}
	
	public void leaveLobby(Player player) {
		players.remove(player);
		player.teleport(old_locations.get(player.getUniqueId()));
		old_locations.remove(player.getUniqueId());
		
		online_players --;
	}
	
	public void clearLobbby() {
		for(Player player : players) {
			player.teleport(old_locations.get(player.getUniqueId()));
		}
		
		players.clear();
		old_locations.clear();
		online_players = 0;
	}
	
	public boolean hasPlayer(Player player) {
		for(Player p : players) {
			if(p.getUniqueId() == player.getUniqueId()) {
				return true;
			}
		}
		
		return false;
	}
	
	public World getWorld() {
		return world;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public int getPlayerCount() {
		return online_players;
	}
	
}