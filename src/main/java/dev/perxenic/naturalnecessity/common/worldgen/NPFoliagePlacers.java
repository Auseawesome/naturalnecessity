package dev.perxenic.naturalnecessity.common.worldgen;

import dev.perxenic.naturalnecessity.NaturalNecessity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import dev.perxenic.naturalnecessity.common.worldgen.foliageplacers.BranchedMegaJungleFoliagePlacer;
import dev.perxenic.naturalnecessity.common.worldgen.foliageplacers.BranchedMegaPineFoliagePlacer;

public class NPFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, NaturalNecessity.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<BranchedMegaPineFoliagePlacer>> BRANCHED_MEGA_PINE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("branched_mega_pine_foliage_placer", () -> new FoliagePlacerType<>(BranchedMegaPineFoliagePlacer.CODEC));
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<BranchedMegaJungleFoliagePlacer>> BRANCHED_MEGA_JUNGLE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("branched_jungle_foliage_placer", () -> new FoliagePlacerType<>(BranchedMegaJungleFoliagePlacer.CODEC));
}
