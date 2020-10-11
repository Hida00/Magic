package jp.Magic.magic.world.tree;

import jp.Magic.magic.Block.MagicSapling;
import jp.Magic.magic.init.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class MagicTree extends Tree {
    public static final TreeFeatureConfig MAGIC_TREE_CONFIG  = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlock.Magic_Wood.getDefaultState()),
            new SimpleBlockStateProvider(ModBlock.Magic_Leave.getDefaultState()),
            new BlobFoliagePlacer(3,0))
            .baseHeight(4).heightRandA(1)
            .foliageHeight(1).ignoreVines().setSapling((IPlantable)ModBlock.Magic_Sapling).build());
    @Override
    protected ConfiguredFeature<TreeFeatureConfig,?> getTreeFeature(Random random,boolean bool){
        return Feature.NORMAL_TREE.withConfiguration(MAGIC_TREE_CONFIG);
    }
}
