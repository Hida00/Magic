package jp.Magic.magic.Item;

import jp.Magic.magic.Main;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;

public class MagicSword extends SwordItem{

    public MagicSword(String name, IItemTier tier,int attackDamage,float attackSpeed){
        super(tier,attackDamage,attackSpeed,new Item.Properties().group(Main.MAGIC_MOD));
        String namespace = Main.MODID;
        this.setRegistryName(new ResourceLocation(namespace,name));
    }
}
