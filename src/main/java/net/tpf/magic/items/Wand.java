package net.tpf.magic.items;

import net.fabricmc.loader.game.MinecraftGameProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.Tag;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class Wand extends Item {

    private boolean canFire = false;
    private final int cost = 1;
    private final float explosionPower = 3;


    public Wand(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient()){
            Item offhand = user.getOffHandStack().getItem();
            if(offhand.getClass() == MagicBook.class){
                if(((MagicBook) offhand).useCharge(user.getOffHandStack(), cost)){
                    user.swingHand(Hand.MAIN_HAND);
                    canFire = true;
                }
            }
        }else{
            if (canFire){
                canFire = false;
                spawnProjectile(world, user);
            }else{
                if (user.getOffHandStack().getItem().getClass() != MagicBook.class){
                    world.createExplosion(null, user.getX(), user.getY(), user.getZ(), explosionPower, Explosion.DestructionType.DESTROY);
                }
            }
        }
        return super.use(world, user, hand);
    }

    public void spawnProjectile(World world, PlayerEntity user){
        SmallFireballEntity fireBall = new SmallFireballEntity(world, user.getX(), user.getEyeY(), user.getZ(), (double) (-MathHelper.sin(user.getHeadYaw() * 0.017453292F)), (double) (-MathHelper.sin(user.pitch * 0.017453292F)), (double) (MathHelper.cos(user.getHeadYaw() * 0.017453292F)));
        world.spawnEntity(fireBall);
        user.playSound(SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 10, 1);
    }
}
