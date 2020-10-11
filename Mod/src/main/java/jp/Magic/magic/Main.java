package jp.Magic.magic;

import jp.Magic.magic.init.ModItemGroups;
import jp.Magic.magic.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main
{
    public static final String MODID = "magic";
    public static final Logger LOGGER = LogManager.getLogger();
    public static PlayerEntity player;

    public static final ItemGroup MAGIC_MOD = new ModItemGroups(MODID,() -> new ItemStack(ModItems.Magic_Sword));
    public static final String ITEM_ID_MAGIC_SWORD = "magic_sword";

    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(Main::init);

        System.setProperty("Java.net.preferIPv4Stack" , "true");

        MinecraftForge.EVENT_BUS.register(this);
    }
    public static void init(final FMLCommonSetupEvent event){

    }
    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event){
        player = event.getPlayer();
    }
}
