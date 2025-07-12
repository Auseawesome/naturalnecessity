package dev.perxenic.naturalnecessity.client;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import dev.perxenic.naturalnecessity.NaturalNecessity;
import dev.perxenic.naturalnecessity.common.NPBlocks;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = NaturalNecessity.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ColorHandler {

    @SubscribeEvent
    public static void handleGrassColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, world, pos, tintIndex) ->
                world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D),
            NPBlocks.DUNE_GRASS.get(), NPBlocks.TALL_DUNE_GRASS.get());
    }
}
