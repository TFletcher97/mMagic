package net.tpf.magic.gen.features;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDepthDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;


public class FeatureHandler {
    public static final Feature<DefaultFeatureConfig> MANA_CRYSTAL = Registry.register(
            Registry.FEATURE,
            new Identifier("magic", "mn_crystal"),
            new ManaCrystalFeature(DefaultFeatureConfig.CODEC)
    );

    public FeatureHandler(){}

    public void init(){
        Registry.BIOME.forEach(biome -> biome.addFeature(
                GenerationStep.Feature.RAW_GENERATION,
                MANA_CRYSTAL.configure(new DefaultFeatureConfig())
                    .createDecoratedFeature(Decorator.MAGMA.configure(new CountDecoratorConfig(5)))
        ));
    }

}
