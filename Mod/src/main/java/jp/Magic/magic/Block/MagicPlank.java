package jp.Magic.magic.Block;

import jp.Magic.magic.Main;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;

public class MagicPlank extends Block {
    public MagicPlank(String name,float hardness,float resistance){
        super(Block.Properties.create(Material.WOOD)
                .hardnessAndResistance(hardness,resistance)
                .sound(SoundType.WOOD)
                .harvestLevel(0).harvestTool(ToolType.AXE));
        this.setRegistryName(new ResourceLocation(Main.MODID,name));
    }
}
