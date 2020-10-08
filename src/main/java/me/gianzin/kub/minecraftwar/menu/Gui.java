package me.gianzin.kub.minecraftwar.menu;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gui implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length==0){
            sender.sendMessage(MinecraftWar.chat + "Utilize: /gui <player>");
        }

        Player p = args[0];


        return true;
    }
}
