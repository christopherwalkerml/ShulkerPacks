package me.darkolythe.shulkerpacks;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.EventExecutor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ChestSortListener implements Listener {

    private static Method getInventoryMethod = null;

    static {
        try {
            getInventoryMethod = Class.forName("de.jeff_media.chestsort.api.ChestSortEvent").getMethod("getInventory",null);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final EventExecutor executor = (listener, event) -> {
        try {
            Inventory inventory = (Inventory) getInventoryMethod.invoke(event, (Object[]) null);
            inventory.forEach(possibleShulker -> {
                if(ShulkerPacks.getInstance().openshulkers.values().contains(possibleShulker)) {
                    ((Cancellable)event).setCancelled(true);
                }
            });
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    };

    public EventExecutor getExecutor() {
        return executor;
    }
}
