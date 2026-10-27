package com.purple.client;

import com.purple.client.module.AutoCrystal;
import com.purple.client.module.CrystalSpammer;
import com.purple.client.module.KillAura;
import com.purple.client.module.Module;
import com.purple.client.ui.ClickGUI;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class PurpleClientMod implements ClientModInitializer {
    public static final String MOD_ID = "purpleclient";
    private static KeyBinding guiKeyBind;
    private static KeyBinding langKeyBind;
    
    public static final List<Module> MODULES = new ArrayList<>();
    public static boolean isPersianLanguage = false;

    @Override
    public void onInitializeClient() {
        guiKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.purpleclient.gui",
                InputUtil.Type.KEY_SYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.purpleclient"
        ));

        langKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.purpleclient.lang",
                InputUtil.Type.KEY_SYM,
                GLFW.GLFW_KEY_P,
                "category.purpleclient"
        ));

        MODULES.add(new AutoCrystal());
        MODULES.add(new CrystalSpammer());
        MODULES.add(new KillAura());

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            if (guiKeyBind.wasPressed()) {
                client.setScreen(new ClickGUI());
            }

            if (langKeyBind.wasPressed()) {
                isPersianLanguage = !isPersianLanguage;
                if (client.player != null) {
                    client.player.sendMessage(
                        net.minecraft.text.Text.literal(isPersianLanguage ? 
                            "§5[Purple Client] زبان به فارسی تغییر کرد." : 
                            "§5[Purple Client] Language changed to English."), 
                        true
                    );
                }
            }

            for (Module module : MODULES) {
                if (module.isToggled()) {
                    module.onTick(client);
                }
            }
        });
    }
}
