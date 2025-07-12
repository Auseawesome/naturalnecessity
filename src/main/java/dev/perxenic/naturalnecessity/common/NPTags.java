package dev.perxenic.naturalnecessity.common;

import dev.perxenic.naturalnecessity.NaturalNecessity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;

public class NPTags {
    public static class Blocks {
        public static final TagKey<Block> WATER_PLANTS = tag("water_plant_survivable");

        private static TagKey<Block> tag(@Nonnull String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NaturalNecessity.MODID, name));
        }
    }
}
