package net.tpf.magic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tpf.magic.items.SoulCrystal;

public class ManaCrucible extends Block {

    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");


    public ManaCrucible(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(ACTIVATED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient() && state.get(ACTIVATED)){
            if (player.getMainHandStack().getItem().getClass() == SoulCrystal.class){
                player.getMainHandStack().setDamage(0);
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        BlockPos blockDown = pos.down();
        if (world.getBlockState(blockDown).isOf(Blocks.MAGMA_BLOCK)){
            world.setBlockState(pos, state.with(ACTIVATED, true));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(ACTIVATED);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        super.neighborUpdate(state, world, pos, block, fromPos, notify);
        BlockPos blockDown = pos.down();
        if (world.getBlockState(blockDown).isOf(Blocks.MAGMA_BLOCK)) {
            world.setBlockState(pos, state.with(ACTIVATED, true));
        } else {
            world.setBlockState(pos, state.with(ACTIVATED, false));
        }
    }
}
