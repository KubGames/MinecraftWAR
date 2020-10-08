package me.gianzin.kub.minecraftwar.commands;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class countrylist implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(MinecraftWar.chat + "os países são: " + VariáveisGlobais.paisesList.toString());

        return false;
    }
}
