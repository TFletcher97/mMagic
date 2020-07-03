package net.tpf.magic;
import net.fabricmc.api.ModInitializer;
import net.tpf.magic.blocks.BlockHandler;
import net.tpf.magic.gen.features.FeatureHandler;
import net.tpf.magic.items.ItemHandler;

public class MagicMod implements ModInitializer{

    private ItemHandler itemHandler = new ItemHandler();
    private BlockHandler blockHandler = new BlockHandler();
    private FeatureHandler featureHandler = new FeatureHandler();
    @Override
    public void onInitialize() {
        itemHandler.init();
        blockHandler.init();
        featureHandler.init();
    }
}
