package me.gianzin.kub.minecraftwar.menu;


import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Selecionar implements Listener {


    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Atacar")){
            p.closeInventory();
            p.performCommand("menuatacar "+p.getName()+" "+VariáveisGlobais.playerMenu.get(p)+"" );
            p.sendMessage("Abrindo menu de ataque...");
        }
        else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Remover")){
            p.sendMessage("Removido");
            p.performCommand("exercitos "+ VariáveisGlobais.playerMenu.get(p)+" remove 1");
            p.performCommand("gui "+ p.getName()+" "+ VariáveisGlobais.playerMenu.get(p));
        }
        else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Adicionar")){
            p.sendMessage("Adicionado");
            p.performCommand( "exercitos "+ VariáveisGlobais.playerMenu.get(p)+" add 1");
            p.performCommand("gui "+ p.getName()+" "+ VariáveisGlobais.playerMenu.get(p));
        }

        //MenuAtacar
        else if(e.getInventory().contains(Material.RED_WOOL)){
            String pais = e.getCurrentItem().getItemMeta().getDisplayName();
            p.sendMessage("Você esta atacando " + pais);
            p.performCommand("attack "+ VariáveisGlobais.playerMenu.get(p) + " " + pais);
            Bukkit.broadcastMessage("attack "+ VariáveisGlobais.playerMenu.get(p) + " " + pais);

        }


        e.setCancelled(true);
    }

}
