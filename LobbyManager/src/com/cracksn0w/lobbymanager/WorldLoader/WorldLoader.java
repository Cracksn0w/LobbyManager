package com.cracksn0w.lobbymanager.WorldLoader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import com.cracksn0w.lobbymanager.LobbyManagerPlugin;
import com.cracksn0w.lobbymanager.lobby.Lobby;

public class WorldLoader {

	LobbyManagerPlugin plugin;
	
	public WorldLoader(LobbyManagerPlugin plugin) {
		this.plugin = plugin;
	}
	
	public void createWorldFolders() {
		int lobby_count = plugin.getNamedConfig("default").getInt("lobbys");
		
		for(int i = 0; i < lobby_count; i++) {
			File src = new File("./Lobby");
			File tar = new File("./Lobby" + i);
			
			try {
				FileUtils.copyDirectory(src, tar);
			} catch (IOException e) {
				plugin.getLogger().severe("Lobby " + i + " konnte nicht erstellt werden!");
			}
		}
	}
	
	public void loadWorlds() {
		int lobby_count = plugin.getNamedConfig("default").getInt("lobbys");
		
		for(int i = 0; i < lobby_count; i++) {
			World world = plugin.getServer().createWorld(new WorldCreator("Lobby" + i));
			
			plugin.getLobbyManager().registerLobby(new Lobby(world));
			plugin.getLogger().info("Lobby " + i + " registriert! :)");
		}
	}
	
}