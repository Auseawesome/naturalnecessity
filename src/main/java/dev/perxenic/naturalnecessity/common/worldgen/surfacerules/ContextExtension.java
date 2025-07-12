package dev.perxenic.naturalnecessity.common.worldgen.surfacerules;

import net.minecraft.world.level.levelgen.SurfaceRules;

public interface ContextExtension {
    SurfaceRules.Condition naturalnecessity$getCliff();
    SurfaceRules.Condition naturalnecessity$getCliffLip();
    SurfaceRules.Condition naturalnecessity$getFlat();
    SurfaceRules.Condition naturalnecessity$getFlatLiquid();
}
