package me.gianzin.kub.minecraftwar.commands;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Exercitos implements CommandExecutor {

    public void HologramaReload(){
        for(int i=0; i<VariáveisGlobais.paisesList.size(); i++){

            Player p = VariáveisGlobais.paisesPlayers.get(VariáveisGlobais.paisesList.get(i));
            String cor = VariáveisGlobais.playerCor.get(p);
            switch(cor){
                case "blue":
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 1 &9" + VariáveisGlobais.paisesList.get(i));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 2 &b&9" + VariáveisGlobais.paisesExercitos.get(VariáveisGlobais.paisesList.get(i)));
                    break;
                case "yellow":
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 1 &e" + VariáveisGlobais.paisesList.get(i));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 2 &b&e" + VariáveisGlobais.paisesExercitos.get(VariáveisGlobais.paisesList.get(i)));
                    break;
                case "green":
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 1 &a" + VariáveisGlobais.paisesList.get(i));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 2 &b&a" + VariáveisGlobais.paisesExercitos.get(VariáveisGlobais.paisesList.get(i)));
                    break;
                case "red":
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 1 &c" + VariáveisGlobais.paisesList.get(i));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 2 &b&c" + VariáveisGlobais.paisesExercitos.get(VariáveisGlobais.paisesList.get(i)));
                    break;
                case "purple":
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 1 &5" + VariáveisGlobais.paisesList.get(i));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 2 &b&5" + VariáveisGlobais.paisesExercitos.get(VariáveisGlobais.paisesList.get(i)));
                    break;
                case "black":
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 1 &0" + VariáveisGlobais.paisesList.get(i));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "hd setline " + VariáveisGlobais.paisesList.get(i) + " 2 &b&0" + VariáveisGlobais.paisesExercitos.get(VariáveisGlobais.paisesList.get(i)));
                    break;

            }



        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        HologramaReload();

        if(args.length==0){
            sender.sendMessage(MinecraftWar.chat + "Utilize o comando: " + ChatColor.GOLD + "/exercitos <país> <add/remove> <quantidade>");
            if(sender instanceof Player){
                sender.sendMessage(MinecraftWar.chat + "Você possui " + VariáveisGlobais.playerFortificar.get(sender) + " exércitos para fortificar");
            }
            return true;
        }

        if(args[1].equals("add")){

            if(sender instanceof Player){
                if(!(sender==VariáveisGlobais.paisesPlayers.get(args[0]))){
                    sender.sendMessage(MinecraftWar.chat + "Você não é o dono deste território, " + ((Player) sender).getDisplayName() + " sua cor é: " + VariáveisGlobais.playerCor);
                    return true;
                }

                if(sender == VariáveisGlobais.playerDaVez) {

                    if (VariáveisGlobais.playerFortificar.get(sender) < Integer.parseInt(args[2])) {
                        sender.sendMessage(MinecraftWar.chat + "Você não tem exércitos suficientes");
                    } else {
                        VariáveisGlobais.paisesExercitos.put(args[0], VariáveisGlobais.paisesExercitos.get(args[0]) + Integer.parseInt(args[2]));

                        Bukkit.broadcastMessage(MinecraftWar.chat + "Foram adicionados " + args[2] + " exércitos ao país " + args[0]);
                        Bukkit.broadcastMessage(MinecraftWar.chat + "Agora o país " + args[0] + " possui " + VariáveisGlobais.paisesExercitos.get(args[0]));

                        VariáveisGlobais.playerFortificar.replace((Player) sender, VariáveisGlobais.playerFortificar.get(sender) - Integer.parseInt(args[2]));
                    }
                }
                else{
                    sender.sendMessage(MinecraftWar.chat + "Não é sua vez, aguarde");
                }

                HologramaReload();


                return true;
            }

            VariáveisGlobais.paisesExercitos.put(args[0], VariáveisGlobais.paisesExercitos.get(args[0]) + Integer.parseInt(args[2]));

            Bukkit.broadcastMessage(MinecraftWar.chat + "Foram adicionados " + args[2] + " exércitos ao país " + args[0]);
            Bukkit.broadcastMessage(MinecraftWar.chat + "Agora o país " + args[0] + " possui " + VariáveisGlobais.paisesExercitos.get(args[0]));

            HologramaReload();

        }
        else if(args[1].equals("remove")){

            if(sender instanceof Player){

                if(sender == VariáveisGlobais.playerDaVez) {

                    if(!(sender==VariáveisGlobais.paisesPlayers.get(args[0]))){
                        sender.sendMessage(MinecraftWar.chat + "Você não é o dono deste território, " + ((Player) sender).getDisplayName() + " sua cor é: " + VariáveisGlobais.playerCor);
                        return true;
                    }


                    if (Integer.parseInt(args[2]) >= VariáveisGlobais.paisesExercitos.get(args[0])) {

                        sender.sendMessage(MinecraftWar.chat + "Deve sobrar no mínimo 1 exército em cada território");
                        return true;

                    }

                    VariáveisGlobais.paisesExercitos.put(args[0], VariáveisGlobais.paisesExercitos.get(args[0]) - Integer.parseInt(args[2]));

                    Bukkit.broadcastMessage(MinecraftWar.chat + "Foram removidos " + args[2] + " exércitos ao país " + args[0]);
                    Bukkit.broadcastMessage(MinecraftWar.chat + "Agora o país " + args[0] + " possui " + VariáveisGlobais.paisesExercitos.get(args[0]));

                    VariáveisGlobais.playerFortificar.replace(VariáveisGlobais.paisesPlayers.get(args[0]), VariáveisGlobais.playerFortificar.get(VariáveisGlobais.paisesPlayers.get(args[0])) + Integer.parseInt(args[2]));
                    VariáveisGlobais.paisesPlayers.get(args[0]).sendMessage(MinecraftWar.chat + "Você recebeu " + args[2] + " exércitos provenientes do território " + args[0] + " para fortificarqualquer outro território");

                }
                else {
                    sender.sendMessage(MinecraftWar.chat + "Não é sua vez, aguarde");
                }

                HologramaReload();


                return true;

            }

            if(Integer.parseInt(args[2])>VariáveisGlobais.paisesExercitos.get(args[0])){

                sender.sendMessage(MinecraftWar.chat + "Deve sobrar no mínimo 1 exército em cada território");
                return true;

            }

            VariáveisGlobais.paisesExercitos.put(args[0], VariáveisGlobais.paisesExercitos.get(args[0]) - Integer.parseInt(args[2]));

            Bukkit.broadcastMessage(MinecraftWar.chat + "Foram removidos " + args[2] + " exércitos ao país " + args[0]);
            Bukkit.broadcastMessage(MinecraftWar.chat + "Agora o país " + args[0] + " possui " + VariáveisGlobais.paisesExercitos.get(args[0]));

            VariáveisGlobais.playerFortificar.replace(VariáveisGlobais.paisesPlayers.get(args[0]), VariáveisGlobais.playerFortificar.get(VariáveisGlobais.paisesPlayers.get(args[0])) + Integer.parseInt(args[2]));
            VariáveisGlobais.paisesPlayers.get(args[0]).sendMessage(MinecraftWar.chat + "Você recebeu " + args[2] + " exércitos provenientes do território " + args[0] + " para fortificarqualquer outro território");

            HologramaReload();

        }
        else {

            sender.sendMessage(MinecraftWar.chat + "Utilize o comando: " + ChatColor.GOLD + "/exercitos <país> <add/remove> <quantidade>");

            HologramaReload();

            return true;


        }




        return true;
    }
}
