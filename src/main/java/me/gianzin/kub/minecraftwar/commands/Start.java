package me.gianzin.kub.minecraftwar.commands;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.bukkit.Bukkit.getServer;

public class Start implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Criar uma Lista de paisesPorPlayer limpa


        VariáveisGlobais.players = Bukkit.getOnlinePlayers().size();

        if(VariáveisGlobais.players > 6){
            sender.sendMessage( MinecraftWar.chat + " Há muitos players no servidor, o número máximo é 6");
        }

        Bukkit.broadcastMessage(MinecraftWar.chat + "O jogo irá começar com " + ChatColor.GOLD + VariáveisGlobais.players + " Jogadores");


        List<String> paisesinhos = new ArrayList<>();
        paisesinhos.addAll(VariáveisGlobais.paisesList);
        List<String> usados = new ArrayList<>();
        Random random = new Random();


        //Distribuição de cores
        int contador=0;
        for(Player p : Bukkit.getOnlinePlayers()){

            VariáveisGlobais.playerQntPaises.put(p, 0);

            VariáveisGlobais.playerNumero.put(p, contador);

            if(VariáveisGlobais.playerNumero.get(p) == 0){
                VariáveisGlobais.playerDaVez = p;
            }

            switch (contador) {

                case 0:
                    p.setDisplayName(ChatColor.BLUE + p.getName() + ChatColor.RESET);
                    VariáveisGlobais.playerCor.put(p, "blue");
                    Bukkit.broadcastMessage(MinecraftWar.chat + p.getDisplayName() + " Está no time Azul");
                    break;
                case 1:
                    p.setDisplayName(ChatColor.YELLOW + p.getName() + ChatColor.RESET);
                    VariáveisGlobais.playerCor.put(p, "yellow");
                    Bukkit.broadcastMessage(MinecraftWar.chat + p.getDisplayName() + " Está no time Amarelo");
                    break;
                case 2:
                    VariáveisGlobais.playerCor.put(p, "green");
                    p.setDisplayName(ChatColor.GREEN + p.getName() + ChatColor.RESET);
                    Bukkit.broadcastMessage(MinecraftWar.chat + p.getDisplayName() + " Está no time Verde");
                    break;
                case 3:
                    VariáveisGlobais.playerCor.put(p, "red");
                    p.setDisplayName(ChatColor.RED + p.getName());
                    Bukkit.broadcastMessage(MinecraftWar.chat + p.getDisplayName() + " Está no time Vermelho");
                    break;
                case 4:
                    VariáveisGlobais.playerCor.put(p, "purple");
                    p.setDisplayName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.RESET);
                    Bukkit.broadcastMessage(MinecraftWar.chat + p.getDisplayName() + " Está no time Roxo");
                    break;
                case 5:
                    VariáveisGlobais.playerCor.put(p, "black");
                    p.setDisplayName(ChatColor.BLACK + p.getName() + ChatColor.RESET);
                    Bukkit.broadcastMessage(MinecraftWar.chat + p.getDisplayName() + " Está no time Preto");
                    break;

            }
            contador++;
        }

        //Distribuição de Países
        while (usados.size()<VariáveisGlobais.paisesList.size()) {
            for (Player p : Bukkit.getOnlinePlayers()) {



                int pais = random.nextInt(paisesinhos.size());

                System.out.println("int pais foi randomizada");


                p.sendMessage(MinecraftWar.chat + "Você recebeu " + ChatColor.GOLD + paisesinhos.get(pais));
                VariáveisGlobais.paisesPlayers.put(paisesinhos.get(pais), p);
                System.out.println("foi anotado em paisesPlayers que o país " + paisesinhos.get(pais) + " pertence a " + p.getDisplayName());
                usados.add(paisesinhos.get(pais));
                System.out.println("O país usado foi adicionado ao usados");

                //Adicionar Países aos paisesPorPlayer

                VariáveisGlobais.playerQntPaises.replace(p, VariáveisGlobais.playerQntPaises.get(p) + 1);



                paisesinhos.remove(pais);
                System.out.println("País foi removido de paisesinhos");

            }
        }

        for (Player p : Bukkit.getOnlinePlayers()) {

            p.sendMessage(MinecraftWar.chat + "Você possui " + VariáveisGlobais.playerQntPaises.get(p) + " territórios");

        }





        Bukkit.broadcastMessage(VariáveisGlobais.playerCor.toString());
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

        Bukkit.broadcastMessage(MinecraftWar.chat + "estão sobrando " + paisesinhos.toString());

        Bukkit.broadcastMessage(MinecraftWar.chat + "foram usados " + usados.toString());

        getServer().dispatchCommand(getServer().getConsoleSender(), "round 0 " + VariáveisGlobais.playerDaVez.getName());

        VariáveisGlobais.round = 0;

        VariáveisGlobais.Touchscreen();

        return true;
    }
}
