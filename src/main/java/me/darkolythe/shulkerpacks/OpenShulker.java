package me.darkolythe.shulkerpacks;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class OpenShulker {
    private ShulkerPacks plugin;
    private HashMap<Inventory, OpenShulker> openShulkerInventories = new HashMap<>();
    private HashMap<UUID, Long> lastOpened = new HashMap<>();

    private ItemStack itemStack;
    private Location openLocation;
    private InventoryType.SlotType slotType;
    private int rawSlot;

    public OpenShulker(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
    public boolean doesPlayerShulkerOpen(UUID uuid) {
        for (Inventory inv : openShulkerInventories.keySet()) {
            for (HumanEntity he : inv.getViewers()) {
                if (he.getUniqueId().equals(uuid)) {
                    return true;
                }
            }
        }
        return false;
    }
}
