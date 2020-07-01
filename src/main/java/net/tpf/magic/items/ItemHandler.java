package net.tpf.magic.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ItemHandler {
    public static final ItemGroup MAGIC_GROUP = FabricItemGroupBuilder.build(
            new Identifier("magic", "general"),
            () -> new ItemStack(Items.LAPIS_BLOCK)
    );

    public static final Item MAGIC_BOOK = new MagicBook(new Item.Settings().group(ItemHandler.MAGIC_GROUP)
            .maxDamage(32)
            .rarity(Rarity.RARE));

    public static final Item WAND = new Wand(new Item.Settings().group(ItemHandler.MAGIC_GROUP)
            .maxCount(1)
            .rarity(Rarity.RARE));
    public static final Item WAND_FOCUS = new WandFocus(new Item.Settings().group(ItemHandler.MAGIC_GROUP)
            .maxCount(1)
            .rarity(Rarity.UNCOMMON));
    public static final Item WAND_CORE = new WandCore(new Item.Settings().group(ItemHandler.MAGIC_GROUP)
            .maxCount(1)
            .rarity(Rarity.UNCOMMON));

    public static final Item SOUL_CRYSTAL_SHARD = new SoulCrystalShard(new Item.Settings().group(ItemHandler.MAGIC_GROUP)
            .maxCount(16)
            .rarity(Rarity.UNCOMMON));
    public static final Item SOUL_CRYSTAL = new SoulCrystal(new Item.Settings().group(ItemHandler.MAGIC_GROUP)
            .maxDamage(16)
            .rarity(Rarity.RARE));

    public ItemHandler(){}

    public void init(){


        Registry.register(Registry.ITEM, new Identifier("magic", "magic_book"), MAGIC_BOOK);
        Registry.register(Registry.ITEM, new Identifier("magic", "wand"), WAND);
        Registry.register(Registry.ITEM, new Identifier("magic", "wand_focus"), WAND_FOCUS);
        Registry.register(Registry.ITEM, new Identifier("magic", "wand_core"), WAND_CORE);

        Registry.register(Registry.ITEM, new Identifier("magic", "soul_crystal_shard"), SOUL_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("magic", "soul_crystal"), SOUL_CRYSTAL);
    }

}
