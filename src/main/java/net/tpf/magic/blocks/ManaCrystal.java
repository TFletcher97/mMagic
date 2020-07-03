package net.tpf.magic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ManaCrystal extends HorizontalFacingBlock {


    public ManaCrystal(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING, Properties.LIT);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        switch(dir){
            case NORTH:
                return VoxelShapes.cuboid(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.25f);
            case SOUTH:
                return VoxelShapes.cuboid(0.25f, 0.25f, 0.75f, 0.75f, 0.75f, 1.0);
            case EAST:
                return VoxelShapes.cuboid(1.0f, 0.25f, 0.75f, 0.75f, 0.75f, 0.25f);
            case WEST:
                return VoxelShapes.cuboid(0.0f, 0.25f, 0.75f, 0.25f, 0.75f, 0.25f);
            default:
                return VoxelShapes.fullCube();
        }
    }

}
