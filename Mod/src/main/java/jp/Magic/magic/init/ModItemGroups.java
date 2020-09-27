package jp.Magic.magic.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups extends ItemGroup {
    private final Supplier<ItemStack> iconSupplier;
    public ModItemGroups(final String name,final Supplier<ItemStack> iconSupplier){
        super(name);
        this.iconSupplier = iconSupplier;
    }
    @Override
    public ItemStack createIcon(){
        return iconSupplier.get();
    }
}
