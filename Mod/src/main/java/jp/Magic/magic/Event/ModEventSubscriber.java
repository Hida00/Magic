package jp.Magic.magic.Event;

import jp.Magic.magic.Main;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = Main.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
    @SubscribeEvent
    public void onModConfigEvent(final ModConfig.ModConfigEvent event){

    }
}
