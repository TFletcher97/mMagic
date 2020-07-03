package net.tpf.magic.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tpf.magic.items.ItemHandler;

public class BlockHandler {
    public static final ManaCrucible MANA_CRUCIBLE = new ManaCrucible(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
    public static final ManaCrystal MANA_CRYSTAL = new ManaCrystal(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

    public BlockHandler(){}

    public void init(){
        Registry.register(Registry.BLOCK, new Identifier("magic", "mana_crucible"), MANA_CRUCIBLE);
        Registry.register(Registry.ITEM, new Identifier("magic", "mana_crucible"), new BlockItem(MANA_CRUCIBLE, new Item.Settings().group(ItemHandler.MAGIC_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("magic", "mana_crystal"), MANA_CRYSTAL);
        Registry.register(Registry.ITEM, new Identifier("magic", "mana_crystal"), new BlockItem(MANA_CRYSTAL, new Item.Settings().group(ItemHandler.MAGIC_GROUP)));

    }
}
