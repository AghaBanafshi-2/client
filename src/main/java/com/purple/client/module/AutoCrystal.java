package com.purple.client.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.util.Hand;

public class AutoCrystal extends Module {
    public AutoCrystal() {
        super("Auto Crystal", "اتوکریستال");
    }

    @Override
    public void onTick(MinecraftClient client) {
        if (client.targetedEntity instanceof EndCrystalEntity crystal && client.interactionManager != null) {
            client.interactionManager.attackEntity(client.player, crystal);
            client.player.swingHand(Hand.MAIN_HAND);
        }
    }
}
