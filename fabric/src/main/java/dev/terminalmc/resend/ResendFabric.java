package dev.terminalmc.resend;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class ResendFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Keybindings
        KeyBindingHelper.registerKeyBinding(Resend.EXAMPLE_KEY);

        // Tick events
        ClientTickEvents.END_CLIENT_TICK.register(Resend::onEndTick);
    }
}
