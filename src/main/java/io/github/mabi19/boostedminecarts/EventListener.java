package io.github.mabi19.boostedminecarts;

import org.bukkit.Material;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

import java.util.Map;

public class EventListener implements Listener {

    Map<Material, Double> multipliers;
    EventListener(Map<Material, Double> multipliers) {
        this.multipliers = multipliers;
    }

    @EventHandler
    void onMinecartMove(VehicleMoveEvent ev) {
        if (ev.getVehicle() instanceof Minecart minecart) {
            var blockBelow = minecart.getLocation().add(0.0, -1.0, 0.0).getBlock();
            var blockMaterial = blockBelow.getType();
            var multiplier = multipliers.get(blockMaterial);
            if (multiplier != null) {
                minecart.setMaxSpeed(0.4 * multiplier);
            }
        }
    }
}
