package jp.Magic.magic.init;

import jp.Magic.magic.Block.MagicWood;
import jp.Magic.magic.Main;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlock {

    public static final Block Magic_Wood = new MagicWood("magicwood",2.0f,2.0f);

    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent.Register<Block> event){
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.registerAll(
                Magic_Wood
        );
    }
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(
                new BlockItem(Magic_Wood,new Item.Properties().group(Main.MAGIC_MOD))
        );
    }
}
