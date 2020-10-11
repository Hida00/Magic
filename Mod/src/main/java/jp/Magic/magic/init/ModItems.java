package jp.Magic.magic.init;

import jp.Magic.magic.Item.MagicStick;
import jp.Magic.magic.Item.MagicSword;
import jp.Magic.magic.Item.Wand;
import jp.Magic.magic.Main;
import jp.Magic.magic.util.ModItemTier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    public static final Item Magic_Sword = new MagicSword("magic_sword", ModItemTier.MAGICAL_WOOD,2,0.5f);
    public static final Item Wand = new Wand("wand");

    public static final Item Magic_Stick = new MagicStick("magicstick");

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(
                Magic_Sword,Wand,Magic_Stick,
                ModBlock.Magic_Wood_Item,ModBlock.Magic_Plank_Item,
                ModBlock.Magic_Leave_Item,
                ModBlock.Magic_Sapling_Item
        );
    }
}
