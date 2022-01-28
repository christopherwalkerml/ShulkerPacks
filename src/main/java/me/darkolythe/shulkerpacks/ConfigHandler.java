package me.darkolythe.shulkerpacks;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler {

    static void loadConfig(ShulkerPacks main) {
        main.reloadConfig();
        FileConfiguration config = main.getConfig();

        main.saveDefaultConfig();
        main.canopeninchests = config.getBoolean("canopeninchests");
        main.canopeninenderchest = config.getBoolean("canopeninenderchest", true);
        main.canopeninbarrels = config.getBoolean("canopeninbarrels", true);
        main.canopenininventory = config.getBoolean("canopenininventory", true);
        main.canplaceshulker = config.getBoolean("canplaceshulker", true);
        main.blacklist = config.getStringList("blacklistedinventories");
        main.canopeninair = config.getBoolean("canopeninair", true);
        main.openpreviousinv = config.getBoolean("open-previous-inventory", false);
        main.volume = (float) config.getDouble("shulkervolume", 1.0);
        main.pvp_timer_enabled = config.getBoolean("disable-in-combat", true);
        if (config.getString("defaultname") != null) {
            main.defaultname = ChatColor.translateAlternateColorCodes('&', config.getString("defaultname"));
        }
        main.shiftclicktoopen = config.getBoolean("shiftclicktoopen");
    }
}
