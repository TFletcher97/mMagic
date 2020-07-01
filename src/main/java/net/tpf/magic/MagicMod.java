package net.tpf.magic;
import net.fabricmc.api.ModInitializer;
import net.tpf.magic.items.ItemHandler;

public class MagicMod implements ModInitializer{

    private ItemHandler itemHandler = new ItemHandler();
    @Override
    public void onInitialize() {
        itemHandler.init();

    }
}
