package com.lunar.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class LunarScreen extends Screen {

    public LunarScreen() {
        super(Text.literal("Lunar Client"));
    }

    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    ) {
        super.render(context, mouseX, mouseY, delta);

        int w = this.width;
        int h = this.height;

        // Затемнение фона
        context.fill(0, 0, w, h, 0x99000000);

        // Главное окно
        int left = w / 2 - 230;
        int top = h / 2 - 145;
        int right = left + 460;
        int bottom = top + 290;

        context.fill(left, top, right, bottom, 0xFF121218);

        // Верхняя панель
        context.fill(left, top, right, top + 50, 0xFF1B1B25);

        context.drawText(
                textRenderer,
                "LUNAR CLIENT",
                left + 18,
                top + 19,
                0xFFFFFFFF,
                false
        );

        context.drawText(
                textRenderer,
                "1.0",
                right - 35,
                top + 19,
                0xFF888888,
                false
        );

        // Категории
        drawButton(context, "Combat", left + 20, top + 70);
        drawButton(context, "Movement", left + 20, top + 105);
        drawButton(context, "Render", left + 20, top + 140);
        drawButton(context, "Player", left + 20, top + 175);
        drawButton(context, "Misc", left + 20, top + 210);

        // Модули
        drawModule(context, "Target Assist", left + 165, top + 70, false);
        drawModule(context, "Sprint", left + 165, top + 110, false);
        drawModule(context, "HUD", left + 165, top + 150, true);
        drawModule(context, "Coordinates", left + 165, top + 190, true);

        context.drawText(
                textRenderer,
                "R  •  Close menu",
                left + 20,
                bottom - 22,
                0xFF777777,
                false
        );
    }

    private void drawButton(
            DrawContext context,
            String text,
            int x,
            int y
    ) {
        context.fill(
                x,
                y,
                x + 125,
                y + 27,
                0xFF22222C
        );

        context.drawText(
                textRenderer,
                text,
                x + 10,
                y + 9,
                0xFFDDDDDD,
                false
        );
    }

    private void drawModule(
            DrawContext context,
            String name,
            int x,
            int y,
            boolean enabled
    ) {
        context.fill(
                x,
                y,
                x + 260,
                y + 30,
                enabled ? 0xFF30303D : 0xFF1E1E26
        );

        context.drawText(
                textRenderer,
                name,
                x + 10,
                y + 10,
                0xFFFFFFFF,
                false
        );

        context.drawText(
                textRenderer,
                enabled ? "ON" : "OFF",
                x + 225,
                y + 10,
                0xFFAAAAAA,
                false
        );
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
