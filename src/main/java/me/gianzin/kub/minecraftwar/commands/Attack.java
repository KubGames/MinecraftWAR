package me.gianzin.kub.minecraftwar.commands;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Attack implements CommandExecutor {

    void EntregarKit(Player player, Boolean invasor, String pais) {

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clear " + player.getName());
        player.setFoodLevel(20);
        int exercitos = VariáveisGlobais.paisesExercitos.get(pais);
        if (invasor == false) {

            ItemStack escudoUnbreaking = new ItemStack(Material.SHIELD);
            ItemStack escudoUnbreaking3 = new ItemStack(Material.SHIELD);
            escudoUnbreaking.addEnchantment(Enchantment.DURABILITY, 1);
            escudoUnbreaking3.addEnchantment(Enchantment.DURABILITY, 3);
            if (exercitos < 2) {

                ItemStack[] armadura = new ItemStack[4];
                armadura[3] = new ItemStack(Material.CHAINMAIL_HELMET);
                armadura[2] = new ItemStack(Material.LEATHER_CHESTPLATE);
                armadura[1] = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                armadura[0] = new ItemStack(Material.CHAINMAIL_BOOTS);
                player.getInventory().setArmorContents(armadura);

                player.getInventory().setItemInMainHand(new ItemStack(Material.STONE_SWORD));
                player.getInventory().addItem(new ItemStack((Material.STONE_AXE)));

                player.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD));

            }
            else if (exercitos == 2) {

                ItemStack[] armadura = new ItemStack[4];
                armadura[3] = new ItemStack(Material.IRON_HELMET);
                armadura[2] = new ItemStack(Material.IRON_CHESTPLATE);
                armadura[1] = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                armadura[0] = new ItemStack(Material.IRON_BOOTS);
                player.getInventory().setArmorContents(armadura);

                player.getInventory().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
                player.getInventory().addItem(new ItemStack((Material.IRON_AXE)));

                player.getInventory().setItemInOffHand(escudoUnbreaking);

            }
            else if (exercitos >= 3) {

                ItemStack[] armadura = new ItemStack[4];
                armadura[3] = new ItemStack(Material.DIAMOND_HELMET);
                armadura[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
                armadura[1] = new ItemStack(Material.IRON_LEGGINGS);
                armadura[0] = new ItemStack(Material.IRON_BOOTS);
                player.getInventory().setArmorContents(armadura);

                player.getInventory().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
                player.getInventory().addItem(new ItemStack((Material.IRON_AXE)));

                player.getInventory().setItemInOffHand(escudoUnbreaking3);

            }

        }
        if (invasor == true) {
            ItemStack escudoUnbreaking = new ItemStack(Material.SHIELD);
            escudoUnbreaking.addEnchantment(Enchantment.DURABILITY, 1);
            ItemStack escudoUnbreaking3 = new ItemStack(Material.SHIELD);
            escudoUnbreaking3.addEnchantment(Enchantment.DURABILITY, 3);
            if (exercitos < 3) {

                ItemStack[] armadura = new ItemStack[4];
                armadura[3] = new ItemStack(Material.LEATHER_HELMET);
                armadura[2] = new ItemStack(Material.LEATHER_CHESTPLATE);
                armadura[1] = new ItemStack(Material.LEATHER_LEGGINGS);
                armadura[0] = new ItemStack(Material.LEATHER_BOOTS);
                player.getInventory().setArmorContents(armadura);

                player.getInventory().setItemInMainHand(new ItemStack(Material.STONE_SWORD));
                player.getInventory().addItem(new ItemStack((Material.STONE_AXE)));

                player.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD));
            }

            else if (exercitos == 3) {

                ItemStack[] armadura = new ItemStack[4];
                armadura[3] = new ItemStack(Material.CHAINMAIL_HELMET);
                armadura[2] = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                armadura[1] = new ItemStack(Material.LEATHER_LEGGINGS);
                armadura[0] = new ItemStack(Material.IRON_BOOTS);
                player.getInventory().setArmorContents(armadura);

                player.getInventory().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
                player.getInventory().addItem(new ItemStack((Material.IRON_AXE)));

                player.getInventory().setItemInOffHand(escudoUnbreaking);

            }
             else if (exercitos >= 4) {

                ItemStack[] armadura = new ItemStack[4];
                armadura[3] = new ItemStack(Material.IRON_HELMET);
                armadura[2] = new ItemStack(Material.IRON_CHESTPLATE);
                armadura[1] = new ItemStack(Material.IRON_LEGGINGS);
                armadura[0] = new ItemStack(Material.IRON_BOOTS);
                player.getInventory().setArmorContents(armadura);

                player.getInventory().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
                player.getInventory().addItem(new ItemStack((Material.DIAMOND_AXE)));

                player.getInventory().setItemInOffHand(escudoUnbreaking3);


            }

        }
    }





    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Mudar nome do player para nome do território
        if(args.length==0){
            sender.sendMessage(MinecraftWar.chat + "A utilização do comando é:" + ChatColor.GOLD + "/attack <Território invasor> <Território defensor>");
            return true;
        }

        if(VariáveisGlobais.spawnDefensor == null || VariáveisGlobais.spawnInvasor == null){
            sender.sendMessage(MinecraftWar.chat + "Você ainda não definiu a arena de PVP, utilize" + ChatColor.RED + ChatColor.ITALIC + "/setarena");
        }

        if(!VariáveisGlobais.paisesList.contains(args[0]) || !VariáveisGlobais.paisesList.contains(args[1])){
            sender.sendMessage(MinecraftWar.chat + "Algum dos países que você digitou não existe");
        }

        Player invasor =VariáveisGlobais.paisesPlayers.get(args[0]);
        Player defensor =VariáveisGlobais.paisesPlayers.get(args[1]);

        if(VariáveisGlobais.paisesPlayers.get(args[0]) == VariáveisGlobais.paisesPlayers.get(args[1])){
            Bukkit.broadcastMessage(MinecraftWar.chat + "Você não pode atacar a si mesmo");
        }

        else if(VariáveisGlobais.paisesPlayers.get(args[0]) == sender && VariáveisGlobais.paisesExercitos.get(args[0]) > 1) {


            invasor.setGameMode(GameMode.ADVENTURE);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clear " + invasor.getDisplayName());
            EntregarKit(invasor, true, args[0]);
            invasor.setHealth(20);

            defensor.setGameMode(GameMode.ADVENTURE);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clear " + defensor.getDisplayName());
            EntregarKit(defensor, false, args[1]);
            defensor.setHealth(20);

            invasor.teleport(VariáveisGlobais.spawnInvasor);
            defensor.teleport(VariáveisGlobais.spawnDefensor);

            VariáveisGlobais.invasorVsDefensor[0] = args[0];
            VariáveisGlobais.invasorVsDefensor[1] = args[1];


        }
        else{
            Bukkit.broadcastMessage(MinecraftWar.chat + args[0] + "não possui exércitos suficientes");
        }

        return true;
    }
}
