package jp.Magic.magic.Item;

import jp.Magic.magic.Main;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class MagicSword extends SwordItem{

    public MagicSword(String name, IItemTier tier,int attackDamage,float attackSpeed){
        super(tier,attackDamage,attackSpeed,new Item.Properties().group(Main.MAGIC_MOD));
        String namespace = Main.MODID;
        this.setRegistryName(new ResourceLocation(namespace,name));
    }
    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag){
        list.add(new StringTextComponent("This is not Magic..."));
    }
}
