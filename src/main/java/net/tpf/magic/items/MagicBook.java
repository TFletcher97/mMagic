package net.tpf.magic.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MagicBook extends Item {
    public MagicBook(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient() && user.isSneaking()) {
            //try charge
            if (hand == Hand.OFF_HAND){
                if (user.getMainHandStack().getItem().getClass() == SoulCrystal.class){
                    charge(user.getOffHandStack(), user.getMainHandStack());
                }
            }
        }

        return super.use(world, user, hand);
    }

    public boolean useCharge(ItemStack stack, int amount){
        if ((stack.getDamage() + amount) <= stack.getMaxDamage()){
            stack.setDamage(stack.getDamage() + amount);
            return true;
        }
        return false;
    }

    public void charge(ItemStack book, ItemStack crystal){
        //If book is full, or crystal is empty, don't do anything
        if (book.getDamage() == 0 || crystal.getDamage() == crystal.getMaxDamage()){
            return;
        }

        int crystalCharge = crystal.getMaxDamage() - crystal.getDamage();
        int bookCharge = book.getMaxDamage() - book.getDamage();

        //If full crystal charge fits in book, put charge in book, empty crystal
        if ((book.getMaxDamage() - bookCharge) >= crystalCharge){
            book.setDamage(book.getDamage() - crystalCharge);
            crystal.setDamage(crystal.getMaxDamage());
        }else {

            //If partial crystal charge would fit, put partial in book, take partial away from crystal
            int partial = crystal.getMaxDamage() - (crystalCharge - (book.getMaxDamage() - bookCharge));
            book.setDamage(book.getDamage() - partial);
            crystal.setDamage(crystal.getDamage() + partial);
        }
    }
}
