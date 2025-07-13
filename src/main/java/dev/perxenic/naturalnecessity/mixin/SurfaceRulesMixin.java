package dev.perxenic.naturalnecessity.mixin;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import dev.perxenic.naturalnecessity.common.worldgen.surfacerules.NESurfaceConditions;
import dev.perxenic.naturalnecessity.common.worldgen.surfacerules.NESurfaceRules;
import dev.perxenic.naturalnecessity.common.worldgen.surfacerules.ContextExtension;

import java.util.function.Function;

@SuppressWarnings("unused")
@Mixin(SurfaceRules.class)
public abstract class SurfaceRulesMixin {

    @Mixin(SurfaceRules.ConditionSource.class)
    public interface ConditionSource extends Function<SurfaceRules.Context, SurfaceRules.Condition> {
        @Inject(method = "bootstrap", at = @At("HEAD"))
        private static void onBootstrap(
            Registry<MapCodec<? extends SurfaceRules.ConditionSource>> pRegistry,
            CallbackInfoReturnable<Codec<SurfaceRules.ConditionSource>> cir) {
            SurfaceRules.register(pRegistry, "naturalnecessity:cliff", NESurfaceRules.Cliff.CODEC);
            SurfaceRules.register(pRegistry, "naturalnecessity:cliff_lip", NESurfaceRules.CliffLip.CODEC);
            SurfaceRules.register(pRegistry, "naturalnecessity:flat", NESurfaceRules.Flat.CODEC);
            SurfaceRules.register(pRegistry, "naturalnecessity:flat_liquid", NESurfaceRules.FlatLiquid.CODEC);
            SurfaceRules.register(pRegistry, "naturalnecessity:climate_sampler", NESurfaceRules.ClimateSampler.CODEC);
            SurfaceRules.register(pRegistry, "naturalnecessity:heightmap_depth", NESurfaceRules.HeightmapDepthCheck.CODEC);
            SurfaceRules.register(pRegistry, "naturalnecessity:biome", NESurfaceRules.ExtendedBiomeConditionSource.CODEC);
        }
    }

    @Mixin(SurfaceRules.Context.class)
    protected static final class Context implements ContextExtension {
        @Unique
        SurfaceRules.Condition cliff, flat, cliffLip, flatLiquid;

        @Inject(method="<init>", at=@At("RETURN"))
        public void instantiateConditions(SurfaceSystem system,
                                          RandomState randomState,
                                          ChunkAccess chunk,
                                          NoiseChunk noiseChunk,
                                          Function<BlockPos, Holder<Biome>> biomeGetter,
                                          Registry<Biome> p_224621_,
                                          WorldGenerationContext context,
                                          CallbackInfo ci) {
            SurfaceRules.Context self = (SurfaceRules.Context) (Object) this;
            cliff = new NESurfaceConditions.CliffMaterialCondition(self);
            cliffLip = new NESurfaceConditions.CliffLipMaterialCondition(self);
            flat = new NESurfaceConditions.FlatMaterialCondition(self);
            flatLiquid = new NESurfaceConditions.FlatLiquidMaterialCondition(self);
        }

        @Override
        public SurfaceRules.Condition naturalnecessity$getCliff() {
            return cliff;
        }

        @Override
        public SurfaceRules.Condition naturalnecessity$getCliffLip() {
            return cliffLip;
        }

        @Override
        public SurfaceRules.Condition naturalnecessity$getFlat() {
            return flat;
        }

        @Override
        public SurfaceRules.Condition naturalnecessity$getFlatLiquid() {
            return flatLiquid;
        }
    }
}
