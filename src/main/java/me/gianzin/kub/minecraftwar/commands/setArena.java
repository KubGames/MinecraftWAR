package me.gianzin.kub.minecraftwar.commands;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setArena implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length==0){
            sender.sendMessage(MinecraftWar.chat + "utilize: /setarena <invasor/defensor>");
            return true;
        }
        if (sender instanceof Player){
            Player player = (Player) sender;

            if(args[0].equals("invasor")) {
                VariáveisGlobais.spawnInvasor = player.getLocation();
                sender.sendMessage(MinecraftWar.chat + "Posição salva");
            }
            if(args[0].equals("defensor")) {
                VariáveisGlobais.spawnDefensor = player.getLocation();
                sender.sendMessage(MinecraftWar.chat + "Posição salva");
            }
        }


        return true;
    }
}
