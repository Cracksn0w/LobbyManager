package com.cracksn0w.lobbymanager;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.cracksn0w.lobbymanager.WorldLoader.WorldLoader;
import com.cracksn0w.test.JoinListener;

public class LobbyManagerPlugin extends JavaPlugin {
	
	private WorldLoader world_loader;
	private LobbyManager lobby_manager;
	
	private HashMap<String, FileConfiguration> configs = new HashMap<>();
	
	@Override
	public void onEnable() {
		
		this.setupConfig();
		
		this.initializeServices();
		this.runServices();
		
		this.test();
		
	}
	
	private void initializeServices() {
		this.world_loader = new WorldLoader(this);
		this.lobby_manager = new LobbyManager(this);
	}
	
	private void runServices() {
		world_loader.createWorldFolders();
		world_loader.loadWorlds();
	}
	
	private void setupConfig() {
		this.saveDefaultConfig();
		
		configs.put("default", this.getConfig());
	}
	
	public FileConfiguration getNamedConfig(String name) {
		return configs.get(name);
	}
	
	public WorldLoader getWorldLoader() {
		return world_loader;
	}
	
	public LobbyManager getLobbyManager() {
		return lobby_manager;
	}
	
	private void test() {
		this.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
	}
	
}