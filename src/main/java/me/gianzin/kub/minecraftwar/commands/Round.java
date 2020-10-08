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

public class Round implements CommandExecutor {

    public void Fortificação(){


        //Mensagem no centro da tela
        for(Player p : Bukkit.getOnlinePlayers()){
           //p.sendTitle("" + ChatColor.GOLD + ChatColor.BOLD + "Fortificação:", ChatColor.BOLD + ChatColor.DARK_AQUA + "Você recebeu );
        }

    }

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

        if(args.length==0){
            sender.sendMessage(MinecraftWar.chat + "A utilização é: /round <numero do round ou finalizar> <Player da vez> \n esse comando é de admin, não utilize-o. Utilize \"/start\" no lugar");
            return true;
        }

        if(args[0].equals("finalizar") && sender instanceof Player && sender == VariáveisGlobais.playerDaVez){

            System.out.println("Finalizando o round...");

            Player proximo = Bukkit.getPlayer("a");

            for(Player p : Bukkit.getOnlinePlayers()){
                if(VariáveisGlobais.playerNumero.get(p)==0){
                    proximo = p;
                }
            }

            System.out.println("O próximo é " + proximo);

            for(Player p : Bukkit.getOnlinePlayers()){
                if(VariáveisGlobais.playerNumero.get(p)== VariáveisGlobais.playerNumero.get(sender) + 1){
                    proximo = p;
                }
            }

            System.out.println("O próximo é " + proximo);

            if(VariáveisGlobais.playerNumero.get(sender) == VariáveisGlobais.players-1){
                VariáveisGlobais.round++;
            }

                VariáveisGlobais.playerDaVez = proximo;

                VariáveisGlobais.playerFortificar.replace(proximo, VariáveisGlobais.playerQntPaises.get(proximo) / 2);


                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "round " + VariáveisGlobais.round + " " + proximo.getName() + "");

        }

        int round = Integer.parseInt(args[0]);

        Player p = Bukkit.getPlayer(args[1]);

        if(round == 0) {
            for (int i = 0; i < 10; i++) {
                Bukkit.broadcastMessage("\n");
            }
            Bukkit.broadcastMessage(MinecraftWar.chat + "Rodada de fortificação de " + args[1] + ", não haverá ataques \n Utilize: /exercitos");

            VariáveisGlobais.playerFortificar.put(p, VariáveisGlobais.playerQntPaises.get(p) / 2);

            p.sendTitle("Utilize: " + ChatColor.BOLD + ChatColor.RED + "/exercitos", "Você possui " + ChatColor.GOLD + VariáveisGlobais.playerFortificar.get(p) + ChatColor.RESET + " exércitos para fortificar", 1, 120, 1);

            p.sendMessage("\n \n \n \n " + MinecraftWar.chat + "Ao finalizar utilize " + ChatColor.GOLD + "/round finalizar");

        }

        if(round>0){

            Bukkit.broadcastMessage(MinecraftWar.chat + "Rodada " + round + "Vez de " + args[1] + "\n Utilize: /exércitos");


            p.sendTitle("Utilize: " + ChatColor.BOLD + ChatColor.RED + "/exercitos", "Você possui " + ChatColor.GOLD + VariáveisGlobais.playerFortificar.get(p) + ChatColor.RESET + " exércitos para fortificar", 1, 120, 1);

            p.sendMessage("\n" + MinecraftWar.chat + "Após fortificar, faça" + ChatColor.GOLD + "/attack <Território com o qual quer atacar> <Território que será atacado>");


            p.sendMessage("\n \n \n \n " + MinecraftWar.chat + "Ao finalizar utilize " + ChatColor.GOLD + "/round finalizar");

            HologramaReload();

        }




        return true;
    }
}
