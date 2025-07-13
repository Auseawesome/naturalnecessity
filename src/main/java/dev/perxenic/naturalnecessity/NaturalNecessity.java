package dev.perxenic.naturalnecessity;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import static dev.perxenic.naturalnecessity.common.worldgen.NEFeatures.FEATURES;
import static dev.perxenic.naturalnecessity.common.worldgen.NERootPlacers.ROOT_PLACERS;
import static dev.perxenic.naturalnecessity.common.worldgen.NEFoliagePlacers.FOLIAGE_PLACERS;
import static dev.perxenic.naturalnecessity.common.worldgen.NEPlacementModifiers.PLACEMENT_MODIFIERS;

@Mod(NaturalNecessity.MODID)
public class NaturalNecessity {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "naturalnecessity";

    public NaturalNecessity(IEventBus modEventBus) {
        // Register mod content
        FEATURES.register(modEventBus);
        ROOT_PLACERS.register(modEventBus);
        FOLIAGE_PLACERS.register(modEventBus);
        PLACEMENT_MODIFIERS.register(modEventBus);
    }
}
