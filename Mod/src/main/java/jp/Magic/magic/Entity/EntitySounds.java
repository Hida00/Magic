package jp.Magic.magic.Entity;

import com.google.common.collect.Lists;
import jp.Magic.magic.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.List;

@Mod.EventBusSubscriber(modid = Main.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Main.MODID)
public class EntitySounds {
    private static List<SoundEvent> sounds = Lists.newArrayList();
    public static final SoundEvent MAGIC_AMBIENT = createSound("magic.ambient");
    public static final SoundEvent MAGIC_BABY_AMBIENT = createSound("magic.baby.ambient");
    public static final SoundEvent MAGIC_DEATH = createSound("magic.death");
    public static final SoundEvent MAGIC_HURT = createSound("magic.hurt");

    private static SoundEvent createSound(String name){
        ResourceLocation location = new ResourceLocation(Main.MODID,name);
        SoundEvent sound = new SoundEvent(location);
        sound.setRegistryName(location);
        sounds.add(sound);
        return sound;
    }
    @SubscribeEvent
    public static void registerSound(RegistryEvent.Register<SoundEvent> event){
        for(SoundEvent sound : sounds){
            event.getRegistry().register(sound);
        }
    }
}
