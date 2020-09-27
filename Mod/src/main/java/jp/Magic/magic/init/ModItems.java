package jp.Magic.magic.init;

import jp.Magic.magic.Item.MagicSword;
import jp.Magic.magic.Item.ModItemTier;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    public static final Item Magic_Sword = new MagicSword("magic_sword", ModItemTier.MAGICAL_WOOD,5,2.2f);

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(
                Magic_Sword
        );
    }
}
