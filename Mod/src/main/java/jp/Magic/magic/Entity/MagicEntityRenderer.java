package jp.Magic.magic.Entity;

import jp.Magic.magic.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class MagicEntityRenderer extends MobRenderer<MagicEntity,MagicEntityModel<MagicEntity>> {
    public MagicEntityRenderer(EntityRendererManager rendererManager){
        super(rendererManager,new MagicEntityModel<>(),0.5F);
    }
    @Override
    @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull MagicEntity entity){
        String name = entity.getName().getString().toLowerCase().trim();
        return entity.isChild() ? getTexture("magic_child") : getTexture("magic");
    }
    private ResourceLocation getTexture(String filename){
        return new ResourceLocation(Main.MODID,"textures/entity/" + filename + ".png");
    }
}
