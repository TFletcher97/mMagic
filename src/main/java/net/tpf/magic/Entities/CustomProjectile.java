package net.tpf.magic.Entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.world.World;

public class CustomProjectile extends SmallFireballEntity {

    public CustomProjectile(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
    }
}
