package me.gianzin.kub.minecraftwar.eventos;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import me.gianzin.kub.minecraftwar.VariáveisGlobais;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DefinirTerritorios implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        if(VariáveisGlobais.mapearPaís==null){
            return;
        }


        MinecraftWar.data.getConfig().set("Pais."+VariáveisGlobais.mapearPaís+"blocos", e.getBlock().getLocation());

        e.getBlock().setType(Material.BEDROCK);

        Bukkit.broadcastMessage(MinecraftWar.chat+ "Bloco definido como território de " + VariáveisGlobais.mapearPaís);

    }


}
