package me.gianzin.kub.minecraftwar;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VariáveisGlobais {

    public static int players = 0;

    public static Location spawnInvasor;
    public static Location spawnDefensor;

    public static String[] paises = {"Alaska", "Mackenzie", "Groenlandia", "Vancouver", "Ottawa", "Labrador", "California", "NovaYork", "Mexico", //América do Norte
            "Venezuela", "Peru", "Brasil", "Argentina", //América do Sul
            "Islandia", "ReinoUnido", "Escandinavia", "Franca", "Alemanha", "Italia", "Moscou", //Europa
             "Argelia", "Egito", "Sudao", "Congo", "AfricaDoSul", "Madagascar", //Africa
            "OrienteMedio", "Omsk", "Aral", "India", "Dudinka", "Siberia", "Vladivostok", "Tchita", "Mongolia", "China", "Vietna", "Japao", //Asia
            "Sumatra", "AustraliaOcidental", "NovaGuine", "AustraliaOriental" //Oceania
    };

    public static List<String> paisesList = new ArrayList<String>();

    public static Map<String, Player> paisesPlayers = new HashMap<String, Player>();

    public static Map<String, Integer> paisesExercitos = new HashMap<String, Integer>();

    public static Map<Player, String> playerCor = new HashMap<Player, String>();

    public static Map<Player, Integer> playerNumero = new HashMap<Player, Integer>();

    public static Map<Player, Integer> playerQntPaises = new HashMap<Player, Integer>();

    public static Map<Player, Integer> playerFortificar = new HashMap<Player, Integer>();

    public static Player playerDaVez;

    public static int round;

    public static String[] invasorVsDefensor = {" ", " "};
}
