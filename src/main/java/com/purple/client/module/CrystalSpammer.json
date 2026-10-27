package com.purple.client.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Items;

public class CrystalSpammer extends Module {
    private int ticker = 0;

    public CrystalSpammer() {
        super("Crystal Spammer", "اسپمر کریستال");
    }

    @Override
    public void onTick(MinecraftClient client) {
        if (client.player == null || client.interactionManager == null) return;
        
        ticker++;
        if (ticker >= 2) { 
            ticker = 0;
            if (client.player.getMainHandStack().isOf(Items.END_CRYSTAL)) {
                // منطق اسپم و قرار دادن سریع کریستال
            }
        }
    }
}
