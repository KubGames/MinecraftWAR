package me.gianzin.kub.minecraftwar.menu;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;
import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class MenuAtacar implements CommandExecutor {

    Inventory gui;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length==0){
            sender.sendMessage(MinecraftWar.chat + "Utilize: /menuatacar <Player> <País>");
            return false;
        }


        Player p = Bukkit.getPlayer(args[0]);
        String pais = args[1];

        gui = Bukkit.createInventory(p, 9, ""+ChatColor.BOLD + ChatColor.RED + "Menu de ATAQUE");
        for(int i = 0; i< VariáveisGlobais.paisVizinhos.get(pais).length; i++){
            CriarItem(VariáveisGlobais.paisVizinhos.get(pais)[i],Material.RED_WOOL, 1);
        }

        p.openInventory(gui);
        return false;
    }
    public void CriarItem(String Nome, Material Material, int Quantidade){
        int exercitos = VariáveisGlobais.paisesExercitos.get(Nome);
        ItemStack item = new ItemStack(Material,Quantidade);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(Nome);
        itemmeta.setLore(Collections.singletonList("" + ChatColor.RED + ChatColor.BOLD + Nome +" "+ ChatColor.RESET + "possui " + ChatColor.YELLOW + ChatColor.BOLD + exercitos+ " exérccitos"));
        item.setItemMeta(itemmeta);


        gui.addItem(item);
    }
}
