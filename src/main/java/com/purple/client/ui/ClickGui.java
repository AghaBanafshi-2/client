package com.purple.client.ui;

import com.purple.client.PurpleClientMod;
import com.purple.client.module.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGUI extends Screen {
    public ClickGUI() {
        super(Text.literal("Purple Client GUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        // باکس پس‌زمینه منو با تم بنفش تیره
        context.fill(width / 2 - 100, height / 2 - 120, width / 2 + 100, height / 2 + 120, 0x85150025);

        // عنوان منو
        String title = PurpleClientMod.isPersianLanguage ? "کلاینت اختصاصی پرپل" : "Purple Utility Client";
        context.drawCenteredTextWithShadow(textRenderer, title, width / 2, height / 2 - 110, 0xD8A0FF);

        // راهنمای تغییر زبان
        String langHint = PurpleClientMod.isPersianLanguage ? "تغییر زبان: کلید P" : "Change Language: Press P";
        context.drawCenteredTextWithShadow(textRenderer, langHint, width / 2, height / 2 + 100, 0xAAAAAA);

        // دکمه‌های ماژول‌ها
        int startY = height / 2 - 80;
        for (int i = 0; i < PurpleClientMod.MODULES.size(); i++) {
            Module module = PurpleClientMod.MODULES.get(i);
            int boxY = startY + (i * 35);
            
            int color = module.isToggled() ? 0xAA8800CC : 0xAA444444;
            context.fill(width / 2 - 80, boxY, width / 2 + 80, boxY + 25, color);

            String status = module.isToggled() ? 
                (PurpleClientMod.isPersianLanguage ? " [فعال]" : " [ON]") : 
                (PurpleClientMod.isPersianLanguage ? " [غیرفعال]" : " [OFF]");
            
            context.drawCenteredTextWithShadow(textRenderer, module.getName() + status, width / 2, boxY + 8, 0xFFFFFF);
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int startY = height / 2 - 80;
        for (int i = 0; i < PurpleClientMod.MODULES.size(); i++) {
            Module module = PurpleClientMod.MODULES.get(i);
            int boxY = startY + (i * 35);

            if (mouseX >= width / 2 - 80 && mouseX <= width / 2 + 80 && mouseY >= boxY && mouseY <= boxY + 25) {
                module.toggle();
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
