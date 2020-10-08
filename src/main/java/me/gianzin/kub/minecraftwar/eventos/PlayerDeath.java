package me.gianzin.kub.minecraftwar.eventos;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.EventListener;

import static org.bukkit.Bukkit.getServer;


public class PlayerDeath implements Listener {
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



    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){

        HologramaReload();



        if(VariáveisGlobais.invasorVsDefensor[0].equals(" ") || VariáveisGlobais.invasorVsDefensor[1].equals(" ")){
            return;
        }


        Player perdedor = (Player) event.getEntity();
        Player vencedor = (Player) perdedor.getKiller();

        String invasor = VariáveisGlobais.invasorVsDefensor[0];
        String defensor = VariáveisGlobais.invasorVsDefensor[1];

        Bukkit.broadcastMessage("\n \n \n \n" + MinecraftWar.chat + perdedor.getDisplayName() + ChatColor.RED + ChatColor.BOLD + " Perdeu para " + ChatColor.RESET + vencedor.getDisplayName());


        //Caso o Invasor morra
        if(VariáveisGlobais.paisesPlayers.get(VariáveisGlobais.invasorVsDefensor[0]) == perdedor){

            Bukkit.broadcastMessage(MinecraftWar.chat + "O invasor perdeu");



            //Definir quantos exércitos o invasor vai perder

            //Se atacou com 1 exército
            if(VariáveisGlobais.paisesExercitos.get(invasor) < 3){
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Perdeu 1 exército");
                VariáveisGlobais.paisesExercitos.replace(invasor, 1);
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Agora possui " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                System.out.println("    perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Perdeu 1 exército\");\n" +
                        "                VariáveisGlobais.paisesExercitos.replace(invasor, 1);\n" +
                        "                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n");

            }
            //Se atacou com 2 exércitos
            else if(VariáveisGlobais.paisesExercitos.get(invasor) == 3){
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Perdeu 2 exércitos");
                VariáveisGlobais.paisesExercitos.replace(invasor, 1);
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Agora possui " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                System.out.println("   perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Perdeu 2 exércitos\");\n" +
                        "                VariáveisGlobais.paisesExercitos.replace(invasor, 1);\n" +
                        "                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n");

            }
            //Se atacou com mais de 2 exércitos
            else if(VariáveisGlobais.paisesExercitos.get(invasor) > 3){
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Perdeu 3 exércitos");
                VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 3);
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Agora possui " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                System.out.println("  perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Perdeu 3 exércitos\");\n" +
                        "                VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 3);\n" +
                        "                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n" +
                        "             ");

            }

            //Definir quantos exércitos a defesa vai perder

            //Se defendeu com 1 exército
            if(VariáveisGlobais.paisesExercitos.get(defensor) < 2){
                vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + ", por ter apenas um exército, não perdeu nenhum exército ");
                vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + " Ainda possui " + VariáveisGlobais.paisesExercitos.get(defensor) + " exércitos");

                System.out.println(" vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + \", por ter apenas um exército, não perdeu nenhum exército \");\n" +
                        "                vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \" Ainda possui \" + VariáveisGlobais.paisesExercitos.get(defensor) + \" exércitos\");\n" +
                        "              ");

            }
            //Se defendeu com 2 exércitos
            else if(VariáveisGlobais.paisesExercitos.get(defensor) == 2){

                //Verificar quanto de vida o player tem

                //Se menor do que a metade
                if(vencedor.getHealth() <= 10){

                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + " perdeu 1 exército porque você está com a metade ou menos de sua vida");
                    VariáveisGlobais.paisesExercitos.replace(defensor, 1);
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + " Ainda possui seus " + VariáveisGlobais.paisesExercitos.get(defensor) + " exércitos");

                    System.out.println("        vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \" perdeu 1 exército porque você está com a metade ou menos de sua vida\");\n" +
                            "                    VariáveisGlobais.paisesExercitos.replace(defensor, 1);\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \" Ainda possui seus \" + VariáveisGlobais.paisesExercitos.get(defensor) + \" exércitos\");\n");


                }
                //Se maior do que a metade
                else{
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + " não perdeu nenhum exército porque voccê está com mais do que a metade da sua vida");
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + " Ainda possui seus " + VariáveisGlobais.paisesExercitos.get(defensor) + " exércitos");

                    System.out.println("     vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + \" não perdeu nenhum exército porque voccê está com mais do que a metade da sua vida\");\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + \" Ainda possui seus \" + VariáveisGlobais.paisesExercitos.get(defensor) + \" exércitos\");\n");

                }

            }
            //Se defendeu com mais de 2 exércitos
            else if(VariáveisGlobais.paisesExercitos.get(defensor) > 2){

                //Se menor do que 1 terço
                if(vencedor.getHealth() <= 20f/3){

                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + " perdeu 2 exércitos porque você está com a metade ou menos de sua vida");
                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(defensor) - 2);
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + " Agora possui" + VariáveisGlobais.paisesExercitos.get(defensor) + " exércitos");

                    System.out.println("   vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \" perdeu 2 exércitos porque você está com a metade ou menos de sua vida\");\n" +
                            "                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(defensor) - 2);\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \" Agora possui\" + VariáveisGlobais.paisesExercitos.get(defensor) + \" exércitos\");\n");

                }
                //Se maior do que um terço
                else if(vencedor.getHealth() <= (20f*2/3)){
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.YELLOW + ChatColor.BOLD + defensor + " perdeu 1 exércitos porque você está com dois terços ou menos de sua vida");
                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(defensor) - 1);
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + " Agora possui " + VariáveisGlobais.paisesExercitos.get(defensor) + " exércitos");

                    System.out.println("      vencedor.sendMessage(MinecraftWar.chat + ChatColor.YELLOW + ChatColor.BOLD + defensor + \" perdeu 1 exércitos porque você está com dois terços ou menos de sua vida\");\n" +
                            "                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(defensor) - 1);\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(defensor) + \" exércitos\");\n");

                }
                //Se maior do que dois terços
                else{

                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + " não perdeu nenhum exército porque voccê está com mais do que dois terços da sua vida");
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + " Ainda possui seus " + VariáveisGlobais.paisesExercitos.get(defensor) + " exércitos");

                    System.out.println("\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + \" não perdeu nenhum exército porque voccê está com mais do que dois terços da sua vida\");\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + defensor + \" Ainda possui seus \" + VariáveisGlobais.paisesExercitos.get(defensor) + \" exércitos\");\n");

                }
            }


        }

        //Caso o Invasor vença
        else if(VariáveisGlobais.paisesPlayers.get(VariáveisGlobais.invasorVsDefensor[0]) == vencedor){
            Bukkit.broadcastMessage(MinecraftWar.chat + "O invasor venceu");

            //Definir quantos exércitos o defensor vai perder

            //Se defendeu com 1 ou 2 exércitos
            if(VariáveisGlobais.paisesExercitos.get(defensor) < 4){
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + "Perdeu todos os exércitos, pois tinha menos de 4 exércitos");
                VariáveisGlobais.paisesExercitos.replace(defensor, 1);
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + " Agora possui " + VariáveisGlobais.paisesExercitos.get(defensor) + " exércitos");
                VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 1);
                VariáveisGlobais.paisesPlayers.replace(defensor, vencedor);
                Bukkit.broadcastMessage(MinecraftWar.chat + ChatColor.RED + defensor + " agora pertence a " + vencedor.getDisplayName());

                System.out.println("  perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \"Perdeu todos os exércitos, pois tinha menos de 4 exércitos\");\n" +
                        "                VariáveisGlobais.paisesExercitos.replace(defensor, 1);\n" +
                        "                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(defensor) + \" exércitos\");\n" +
                        "                VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 1);\n" +
                        "                VariáveisGlobais.paisesPlayers.replace(defensor, vencedor);\n" +
                        "                Bukkit.broadcastMessage(MinecraftWar.chat + ChatColor.RED + defensor + \" agora pertence a \" + vencedor.getDisplayName());\n" +
                        "              ");
            }

            //Se defendeu com mais de 2 exércitos
            else if(VariáveisGlobais.paisesExercitos.get(defensor) > 3){
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + " Perdeu 3 exércitos, porém o território ainda te percence, pois possuía mais de 3 exércitos e ainda pode lutar mais batalhas");
                VariáveisGlobais.paisesExercitos.replace(defensor, VariáveisGlobais.paisesExercitos.get(defensor) - 3);
                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + " Agora possui " + VariáveisGlobais.paisesExercitos.get(defensor) + " exércitos");

                System.out.println("  perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \" Perdeu 3 exércitos, porém o território ainda te percence, pois possuía mais de 3 exércitos e ainda pode lutar mais batalhas\");\n" +
                        "                VariáveisGlobais.paisesExercitos.replace(defensor, VariáveisGlobais.paisesExercitos.get(defensor) - 3);\n" +
                        "                perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + defensor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(defensor) + \" exércitos\");\n");

            }

            //Definir quantos exércitos o invasor vai perder

            //Se atacou com 1 exército
            if(VariáveisGlobais.paisesExercitos.get(invasor) < 3){

                //Verificar quanto de vida o player tem

                //Se menor do que a metade
                if(vencedor.getHealth() <= 10){

                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " perdeu 1 exército porque você está com a metade ou menos de sua vida");
                    VariáveisGlobais.paisesExercitos.replace(invasor, 1);
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Ainda possui seus " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                    System.out.println("vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" perdeu 1 exército porque você está com a metade ou menos de sua vida\");\n" +
                            "                    VariáveisGlobais.paisesExercitos.replace(invasor, 1);\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Ainda possui seus \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n");


                }
                //Se maior do que a metade
                else if(vencedor.getHealth() > 10){
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + " não perdeu nenhum exército porque você está com mais do que a metade da sua vida");
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + " Ainda possui seus " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                    System.out.println("   vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + \" não perdeu nenhum exército porque você está com mais do que a metade da sua vida\");\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + \" Ainda possui seus \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n");

                }

            }
            //Se atacou com 2 exércitos
            else if(VariáveisGlobais.paisesExercitos.get(defensor) == 3){

                //Verificar quanto de vida o player tem

                //Se menor do que 1 terço
                if(vencedor.getHealth() <= 20f/3){

                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " perdeu 2 exércitos porque você está com a metade ou menos de sua vida");
                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 2);
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Agora possui" + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");


                    System.out.println("   vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" perdeu 2 exércitos porque você está com a metade ou menos de sua vida\");\n" +
                            "                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 2);\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Agora possui\" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n");
                }
                //Se maior do que um terço
                else if(vencedor.getHealth() <= (20f*2/3)){
                    perdedor.sendMessage(MinecraftWar.chat + ChatColor.YELLOW + ChatColor.BOLD + invasor + " não perdeu nenhum exército porque voccê está com mais do que a metade da sua vida");
                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 1);
                    perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Agora possui " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                    System.out.print("         perdedor.sendMessage(MinecraftWar.chat + ChatColor.YELLOW + ChatColor.BOLD + invasor + \" não perdeu nenhum exército porque voccê está com mais do que a metade da sua vida\");\n" +
                            "                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 1);\n" +
                            "                    perdedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n");
                }
                //Se maior do que dois terços
                else if(vencedor.getHealth() <= (20f*2/3)) {

                    perdedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + " não perdeu nenhum exército porque voccê está com mais do que um terço da sua vida");
                    perdedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + " Ainda possui seus " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                    System.out.println("           perdedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + \" não perdeu nenhum exército porque voccê está com mais do que um terço da sua vida\");\n" +
                            "                    perdedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + \" Ainda possui seus \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n");
                }

            }
            //Se atacou com mais de 3 exércitos
            else if(VariáveisGlobais.paisesExercitos.get(defensor) > 3){

                //Se menor do que 1 quarto
                if(vencedor.getHealth() <= 20f/4){

                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor+ " perdeu 3 exércitos porque você está com um quarto ou menos de sua vida");
                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 3);
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Agora possui" + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                    System.out.println(" vencedor.sendMessage(MinecraftWar.chat + ChatColor.YELLOW + ChatColor.BOLD + invasor + \" perdeu 2 exércitos porque você está com a metade ou menos de sua vida\");\n" +
                            "                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 2);\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n");

                }
                //Se maior do 1 um quarto
                else if(vencedor.getHealth() <= (20f*2/4)){
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.YELLOW + ChatColor.BOLD + invasor + " perdeu 2 exércitos porque você está com a metade ou menos de sua vida");
                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 2);
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Agora possui " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                    System.out.print(" vencedor.sendMessage(MinecraftWar.chat + ChatColor.YELLOW + ChatColor.BOLD + invasor + \" perdeu 2 exércitos porque você está com a metade ou menos de sua vida\");\n" +
                            "                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 2);\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n");
                }
                //Se menor do que 3 quartos

                else if(vencedor.getHealth() <= (20f*3/4)){
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.YELLOW + ChatColor.BOLD + invasor + " perdeu 3 exércitos porque você está com três quartos ou menos de sua vida");
                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 3);
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + " Agora possui " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");

                    System.out.println("vencedor.sendMessage(MinecraftWar.chat + ChatColor.YELLOW + ChatColor.BOLD + invasor + \" perdeu 3 exércitos porque você está com três quartos ou menos de sua vida\");\n" +
                            "                    VariáveisGlobais.paisesExercitos.replace(invasor, VariáveisGlobais.paisesExercitos.get(invasor) - 3);\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.RED + ChatColor.BOLD + invasor + \" Agora possui \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");\n" +
                            "                   ");
                }

                //Se maior do que 3 quartos
                else if(vencedor.getHealth() > (20f*3/4)) {

                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + " não perdeu nenhum exército porque voccê está com mais do que três quartos da sua vida");
                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + " Ainda possui seus " + VariáveisGlobais.paisesExercitos.get(invasor) + " exércitos");
                    System.out.println("vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + \" não perdeu nenhum exército porque voccê está com mais do que três quartos da sua vida\");\n" +
                            "                    vencedor.sendMessage(MinecraftWar.chat + ChatColor.GREEN + ChatColor.BOLD + invasor + \" Ainda possui seus \" + VariáveisGlobais.paisesExercitos.get(invasor) + \" exércitos\");");

                }
            }


        }

        //SEI LÁ
        else{
            Bukkit.broadcastMessage(ChatColor.RED + "Não sei o que está acontecendo");

        }

        VariáveisGlobais.invasorVsDefensor[0] = " ";
        VariáveisGlobais.invasorVsDefensor[1] = " ";

        vencedor.setHealth(20);
        vencedor.setFoodLevel(20);

        vencedor.setGameMode(GameMode.CREATIVE);
    }

    @EventHandler

    public void Respawn(PlayerRespawnEvent event){
        event.getPlayer().setGameMode(GameMode.CREATIVE);
        event.getPlayer().setHealth(20);
        event.getPlayer().setFoodLevel(20);
    }



}
