package net.tpf.magic.gen.features;

import com.mojang.serialization.Codec;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.tpf.magic.blocks.BlockHandler;
import net.tpf.magic.blocks.ManaCrystal;

import java.util.Random;

public class ManaCrystalFeature extends Feature<DefaultFeatureConfig> {


    public ManaCrystalFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ServerWorldAccess serverWorldAccess, StructureAccessor accessor, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {

        boolean isPlaced = false;
        if (serverWorldAccess.getBlockState(pos).isAir()) {
            if (!serverWorldAccess.getBlockState(pos.north()).isAir() && !serverWorldAccess.getBlockState(pos.north()).isOf(BlockHandler.MANA_CRYSTAL)){
                serverWorldAccess.setBlockState(pos, BlockHandler.MANA_CRYSTAL.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH), 3);
            }else if(!serverWorldAccess.getBlockState(pos.south()).isAir() && !serverWorldAccess.getBlockState(pos.south()).isOf(BlockHandler.MANA_CRYSTAL)){
                serverWorldAccess.setBlockState(pos, BlockHandler.MANA_CRYSTAL.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.SOUTH), 3);
            }else if(!serverWorldAccess.getBlockState(pos.east()).isAir() && !serverWorldAccess.getBlockState(pos.east()).isOf(BlockHandler.MANA_CRYSTAL)){
                serverWorldAccess.setBlockState(pos, BlockHandler.MANA_CRYSTAL.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.EAST), 3);
            }else if(!serverWorldAccess.getBlockState(pos.west()).isAir()&& !serverWorldAccess.getBlockState(pos.west()).isOf(BlockHandler.MANA_CRYSTAL)){
                serverWorldAccess.setBlockState(pos, BlockHandler.MANA_CRYSTAL.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.WEST), 3);
            }
        }
        return true;
    }
}
