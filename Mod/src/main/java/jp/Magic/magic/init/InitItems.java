package jp.Magic.magic.init;

import jp.Magic.magic.Item.MagicItemTier;
import jp.Magic.magic.Main;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InitItems {
    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(
                createItem()
        );
    }
    private static Item createItem(){
        IItemTier tier = MagicItemTier.VENEER;
        int attackDamage = 100;
        float attackSpeed = 10.0f;
        Item.Properties builder = new Item.Properties().group(ItemGroup.COMBAT);
        Item MagicSword = new SwordItem(tier,attackDamage,attackSpeed,builder);

        String namespace = Main.MODID;
        String path = Main.ITEM_ID_MAGIC_SWORD;
        MagicSword.setRegistryName(new ResourceLocation(namespace,path));

        return MagicSword;
    }
}
