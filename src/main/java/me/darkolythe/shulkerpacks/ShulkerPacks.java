package me.darkolythe.shulkerpacks;

import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class ShulkerPacks extends JavaPlugin {

    ShulkerListener shulkerlistener;

    String prefix = ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "[" + ChatColor.BLUE.toString() + "ShulkerPacks" + ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "] ";

    Map<UUID, ItemStack> openshulkers = new HashMap<>();
    Map<UUID, Inventory> openinventories = new HashMap<>();
    boolean canopeninchests = true;
    List<String> blacklist = new ArrayList<>();
    String defaultname = ChatColor.BLUE + "Shulker Pack";
    boolean shiftclicktoopen = false;
    boolean canopeninenderchest = true;
    boolean canplaceshulker = true;
    boolean canopeninair = true;
    Map<UUID, ItemStack> thrownItem = new HashMap<>();

    /*
    Sets up the plugin
     */
    @Override
    public void onEnable() {
        shulkerlistener = new ShulkerListener(this);

        getServer().getPluginManager().registerEvents(shulkerlistener, this);

        saveDefaultConfig();
        canopeninchests = getConfig().getBoolean("canopeninchests");
        canopeninenderchest = getConfig().getBoolean("canopeninenderchest");
        canplaceshulker = getConfig().getBoolean("canplaceshulker");
        blacklist = getConfig().getStringList("blacklistedinventories");
        canopeninair = getConfig().getBoolean("canopeninair");
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

    ItemStack getThrownItem(Player player) {
        if (thrownItem.containsKey(player.getUniqueId())) {
            return thrownItem.get(player.getUniqueId());
        } else {
            thrownItem.put(player.getUniqueId(), new ItemStack(Material.AIR));
            return thrownItem.get(player.getUniqueId());
        }
    }

    void putThrownItem(Player player, ItemStack item) {
        thrownItem.put(player.getUniqueId(), item);
    }
}
