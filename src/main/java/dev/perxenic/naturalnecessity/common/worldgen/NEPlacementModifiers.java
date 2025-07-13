package dev.perxenic.naturalnecessity.common.worldgen;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import dev.perxenic.naturalnecessity.NaturalNecessity;
import dev.perxenic.naturalnecessity.common.worldgen.placementmodifiers.DepthFilter;

import javax.annotation.Nonnull;

public class NEPlacementModifiers {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, NaturalNecessity.MODID);

    public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<DepthFilter>> DEPTH_FILTER = PLACEMENT_MODIFIERS.register("depth_filter",
        () -> new PlacementModifierType<>() {
            @Override
            @Nonnull
            public MapCodec<DepthFilter> codec() {
                return DepthFilter.CODEC;
            }
        });
}
