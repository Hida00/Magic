package jp.Magic.magic.Block;

import jp.Magic.magic.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class MagicLeave extends LeavesBlock {
    public MagicLeave(String name){
        super(
            Block.Properties.create(Material.LEAVES)
                .hardnessAndResistance(0.2F)
                .tickRandomly()
                .notSolid()
                .sound(SoundType.PLANT)
        );
        this.setRegistryName(new ResourceLocation(Main.MODID,name));
    }
    /*
    @Override
    public int getOpacity(BlockState state, IBlockReader world, BlockPos pos){
        return 20;
    }
    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face){
        return 60;
    }
    @Override
    public int getFireSpreadSpeed(BlockState state,IBlockReader world,BlockPos pos,Direction face){
        return 30;
    }
    */
}
