package me.gianzin.kub.minecraftwar.menu;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gui implements CommandExecutor {
    Inventory gui;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length==0){
            sender.sendMessage(MinecraftWar.chat + "Utilize: /gui <player> <país>");
            return false;
        }

        Player p = Bukkit.getPlayer(args[0]);
        String pais = args[1];

        gui = Bukkit.createInventory(p,9,  ChatColor.ITALIC + pais + " possui " + ChatColor.BOLD + ChatColor.DARK_PURPLE+VariáveisGlobais.paisesExercitos.get(pais)+" exércitos");

        CriarItem(""+ ChatColor.RED + ChatColor.BOLD + "Atacar", Material.DIAMOND_SWORD, 1, 0);

        CriarItem(""+ ChatColor.GREEN + ChatColor.BOLD + "Adicionar 1 exército", Material.GREEN_WOOL, 1, 7);
        CriarItem(""+ ChatColor.RED + ChatColor.BOLD +"Remover 1 exército", Material.BUCKET, 1, 8);

        p.openInventory(gui);
        VariáveisGlobais.playerMenu.put(p, pais);
        return true;
    }
    public void CriarItem(String Nome, Material Material, int Quantidade, int Posição){
        ItemStack item = new ItemStack(Material,Quantidade);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(Nome);
        item.setItemMeta(itemmeta);


        gui.setItem(Posição,item);
    }
}
