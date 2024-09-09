package dev.terminalmc.resend;

import com.mojang.blaze3d.platform.InputConstants;
import dev.terminalmc.resend.util.ModLogger;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.Screen;

import static dev.terminalmc.resend.util.Localization.translationKey;

public class Resend {
    public static final String MOD_ID = "resend";
    public static final String MOD_NAME = "Resend";
    public static final ModLogger LOG = new ModLogger(MOD_NAME);
    public static final KeyMapping EXAMPLE_KEY = new KeyMapping(
            translationKey("key", "group.resend"), InputConstants.Type.KEYSYM,
            InputConstants.UNKNOWN.getValue(), translationKey("key", "group"));

    public static void onEndTick(Minecraft mc) {
        while (EXAMPLE_KEY.consumeClick()) {
            Screen oldScreen = mc.screen;
            mc.setScreen(new ChatScreen(""));
            String msg = mc.gui.getChat().getRecentChat().peekLast();
            if (msg != null && mc.screen instanceof ChatScreen cs) {
                cs.handleChatInput(msg, false);
            }
            mc.setScreen(oldScreen);
        }
    }
}
