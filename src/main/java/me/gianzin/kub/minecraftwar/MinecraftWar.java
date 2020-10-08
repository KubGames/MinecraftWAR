package me.gianzin.kub.minecraftwar;

import me.gianzin.kub.minecraftwar.commands.*;
import me.gianzin.kub.minecraftwar.eventos.PlayerDeath;
import me.gianzin.kub.minecraftwar.menu.Gui;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;


public final class MinecraftWar extends JavaPlugin {

    public static String chat = ("" + ChatColor.GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "WAR" + ChatColor.RESET + ChatColor.GRAY + "] " + ChatColor.AQUA + ChatColor.BOLD);

    @Override
    public void onEnable() {
        // Plugin startup logic



        VariáveisGlobais.paisesList.addAll(Arrays.asList(VariáveisGlobais.paises));
        for (String paises : VariáveisGlobais.paisesList){
            VariáveisGlobais.paisesExercitos.put(paises, 1);
        }

        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        this.getCommand("start").setExecutor(new Start());
        this.getCommand("attack").setExecutor(new Attack());
        this.getCommand("setarena").setExecutor(new setArena());
        this.getCommand("countrylist").setExecutor(new countrylist());
        this.getCommand("exercitos").setExecutor(new Exercitos());
        this.getCommand("round").setExecutor(new Round());
        this.getCommand("gui").setExecutor(new Gui());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
