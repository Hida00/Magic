package jp.Magic.magic.Block;

import jp.Magic.magic.Main;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.ResourceLocation;

public class MagicSapling extends SaplingBlock {
    public MagicSapling(String name, Tree tree){
        super(
            tree,Properties.create(Material.PLANTS)
            .hardnessAndResistance(0.0F)
            .sound(SoundType.PLANT)
            .doesNotBlockMovement()
            .tickRandomly()
        );
        setRegistryName(new ResourceLocation(Main.MODID,name));
    }
}
