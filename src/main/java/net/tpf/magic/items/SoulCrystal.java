package net.tpf.magic.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SoulCrystal extends Item{
    public SoulCrystal(Settings settings) {
        super(settings);
    }




    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);

        stack.setDamage(stack.getMaxDamage());
    }
}