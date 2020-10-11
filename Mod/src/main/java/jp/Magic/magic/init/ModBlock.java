package jp.Magic.magic.init;

import jp.Magic.magic.Block.MagicLeave;
import jp.Magic.magic.Block.MagicPlank;
import jp.Magic.magic.Block.MagicSapling;
import jp.Magic.magic.Block.MagicWood;
import jp.Magic.magic.Main;
import jp.Magic.magic.world.tree.MagicTree;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlock {
    public static final Block Magic_Wood = new MagicWood("magicwood",2.0f,2.0f);
    public static final Item Magic_Wood_Item = new BlockItem(Magic_Wood.getBlock(),new Item.Properties().group(Main.MAGIC_MOD)).setRegistryName(Magic_Wood.getRegistryName());

    public static final Block Magic_Plank = new MagicPlank("magicplank",2.0f,3.0f);
    public static final Item Magic_Plank_Item = new BlockItem(Magic_Plank.getBlock(),new Item.Properties().group(Main.MAGIC_MOD)).setRegistryName(Magic_Plank.getRegistryName());

    public static final Block Magic_Leave = new MagicLeave("magicleave");
    public static final Item Magic_Leave_Item = new BlockItem(Magic_Leave.getBlock(),new Item.Properties().group(Main.MAGIC_MOD)).setRegistryName(Magic_Leave.getRegistryName());

    public static final Block Magic_Sapling = new MagicSapling("magicsapling",new MagicTree());
    public static final Item Magic_Sapling_Item = new BlockItem(Magic_Sapling.getBlock(),new Item.Properties().group(Main.MAGIC_MOD)).setRegistryName(Magic_Sapling.getRegistryName());

    //public static final Block Magic_WorkBench = null;
    //public static final Item Magic_WorkBench_Item = null;

    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent.Register<Block> event){
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.registerAll(
                Magic_Wood,Magic_Plank,Magic_Leave,Magic_Sapling
        );
    }
}
