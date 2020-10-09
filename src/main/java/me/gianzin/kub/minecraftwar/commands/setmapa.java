package me.gianzin.kub.minecraftwar.commands;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class setmapa implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length==0){
            sender.sendMessage(MinecraftWar.chat+ "Utilize: /setmapa <país/end>");
        }
        else if(args[0].equalsIgnoreCase("end")||args[0].equalsIgnoreCase("finalizar")){
            VariáveisGlobais.mapearPaís = null;
        }
        else{
            VariáveisGlobais.mapearPaís = args[0];
            Bukkit.broadcastMessage("\n");
            Bukkit.broadcastMessage("\n");
            Bukkit.broadcastMessage("\n");
            Bukkit.broadcastMessage("\n");
            Bukkit.broadcastMessage("Vocês estão definindo o território de " + args[0]);

        }


        return false;
    }
}
