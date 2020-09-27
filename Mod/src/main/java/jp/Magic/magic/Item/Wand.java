package jp.Magic.magic.Item;

import jp.Magic.magic.Main;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class Wand extends Item {
    public Wand(String name){
        super(new Properties().group(Main.MAGIC_MOD));

        String namespace = Main.MODID;
        this.setRegistryName(new ResourceLocation(namespace,name));
    }
}
