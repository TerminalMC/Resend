package dev.terminalmc.resend;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@Mod(value = Resend.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Resend.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ResendNeoForge {
    public ResendNeoForge() {
    }

    // Keybindings
    @SubscribeEvent
    static void registerKeyMappingsEvent(RegisterKeyMappingsEvent event) {
        event.register(Resend.EXAMPLE_KEY);
    }

    @EventBusSubscriber(modid = Resend.MOD_ID, value = Dist.CLIENT)
    static class ClientEventHandler {
        // Tick events
        @SubscribeEvent
        public static void clientTickEvent(ClientTickEvent.Post event) {
            Resend.onEndTick(Minecraft.getInstance());
        }
    }
}
