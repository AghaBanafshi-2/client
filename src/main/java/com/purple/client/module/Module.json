package com.purple.client.module;

import net.minecraft.client.MinecraftClient;

public class Module {
    private final String nameEn;
    private final String nameFa;
    private boolean toggled;

    public Module(String nameEn, String nameFa) {
        this.nameEn = nameEn;
        this.nameFa = nameFa;
        this.toggled = false;
    }

    public String getName() {
        return com.purple.client.PurpleClientMod.isPersianLanguage ? nameFa : nameEn;
    }

    public String getNameEn() { return nameEn; }
    public String getNameFa() { return nameFa; }

    public boolean isToggled() { return toggled; }
    public void toggle() {
        this.toggled = !this.toggled;
    }

    public void onTick(MinecraftClient client) {}
}
