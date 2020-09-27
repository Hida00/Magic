package jp.Magic.magic.Item;

import jp.Magic.magic.Main;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class MagicStick extends Item {
    public MagicStick(String name){
        super(new Properties().group(Main.MAGIC_MOD));

        this.setRegistryName(new ResourceLocation(Main.MODID,name));
    }
}
