package jp.Magic.magic.Event;

import jp.Magic.magic.Main;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ModEventSubscriber {
    @SubscribeEvent
    public static void rightClickEmpty(PlayerInteractEvent.RightClickEmpty event){
        String S = event.getHand().name();
        Main.LOGGER.debug(S + "-------------------------");
    }

}
