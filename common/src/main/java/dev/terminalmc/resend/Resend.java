/*
 * Copyright 2024 TerminalMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
