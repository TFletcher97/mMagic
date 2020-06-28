package net.tpf.magic;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tpf.magic.Entities.CustomProjectile;
import net.tpf.magic.items.MagicBook;
import net.tpf.magic.items.Wand;


public class MagicMod implements ModInitializer{
    public static final Item MAGIC_BOOK = new MagicBook(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WAND = new Wand(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier("magic", "magic_book"), MAGIC_BOOK);
        Registry.register(Registry.ITEM, new Identifier("magic", "wand"), WAND);
    }
}
