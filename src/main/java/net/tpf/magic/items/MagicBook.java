package net.tpf.magic.items;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.tpf.magic.guis.MagicGUI;
import net.tpf.magic.guis.MagicScreen;

public class MagicBook extends Item {
    public MagicBook(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient() && hand == Hand.MAIN_HAND) {
            MinecraftClient.getInstance().openScreen(new MagicScreen(new MagicGUI()));
        }

        return super.use(world, user, hand);
    }
}
