package net.tpf.magic;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tpf.magic.items.MagicBook;
import net.tpf.magic.items.Wand;
import net.tpf.magic.items.WandCore;
import net.tpf.magic.items.WandFocus;


public class MagicMod implements ModInitializer{
    public static final Item MAGIC_BOOK = new MagicBook(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WAND = new Wand(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WAND_FOCUS = new WandFocus(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WAND_CORE = new WandCore(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier("magic", "magic_book"), MAGIC_BOOK);
        Registry.register(Registry.ITEM, new Identifier("magic", "wand"), WAND);
        Registry.register(Registry.ITEM, new Identifier("magic", "wand_focus"), WAND_FOCUS);
        Registry.register(Registry.ITEM, new Identifier("magic", "wand_core"), WAND_CORE);

    }
}
