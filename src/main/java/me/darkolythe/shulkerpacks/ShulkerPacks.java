package me.darkolythe.shulkerpacks;

import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class ShulkerPacks extends JavaPlugin {

    public ShulkerListener shulkerlistener;

    public String prefix = ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "[" + ChatColor.BLUE.toString() + "ShulkerPacks" + ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "] ";

    public Map<UUID, ItemStack> openshulkers = new HashMap<>();
    public Map<UUID, Inventory> openinventories = new HashMap<>();
    public boolean canopeninchests = true;
    public List<String> blacklist = new ArrayList<>();
    public String defaultname = ChatColor.BLUE + "Shulker Pack";
    public boolean shiftclicktoopen = false;

    /*
    Sets up the plugin
     */
    @Override
    public void onEnable() {
        shulkerlistener = new ShulkerListener(this);

        getServer().getPluginManager().registerEvents(shulkerlistener, this);

        saveDefaultConfig();
        canopeninchests = getConfig().getBoolean("canopeninchests");
        blacklist = getConfig().getStringList("blacklistedinventories");
        if (getConfig().getString("defaultname") != null) {
            defaultname = ChatColor.translateAlternateColorCodes('&', getConfig().getString("defaultname"));
        }
        shiftclicktoopen = getConfig().getBoolean("shiftclicktoopen");

        Metrics metrics = new Metrics(this);

        System.out.println(prefix + ChatColor.GREEN + "ShulkerPacks has been enabled!");
    }

    /*
    Doesnt do much. Just says a message
     */
    @Override
    public void onDisable() {
        System.out.println(prefix + ChatColor.RED + "ShulkerPacks has been disabled!");
    }
}
