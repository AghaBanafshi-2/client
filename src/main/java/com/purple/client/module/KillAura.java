package com.purple.client.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;

public class KillAura extends Module {
    public KillAura() {
        super("Kill Aura", "کیل آورا");
    }

    @Override
    public void onTick(MinecraftClient client) {
        if (client.player == null || client.world == null || client.interactionManager == null) return;

        double reach = 4.0;
        for (Entity entity : client.world.getEntities()) {
            if (entity instanceof LivingEntity living && entity != client.player) {
                if (client.player.distanceTo(living) <= reach && living.getHealth() > 0) {
                    client.interactionManager.attackEntity(client.player, living);
                    client.player.swingHand(Hand.MAIN_HAND);
                    break;
                }
            }
        }
    }
}
