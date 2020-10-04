package jp.Magic.magic.Entity;

import jp.Magic.magic.init.ModBlock;
import jp.Magic.magic.init.ModEntity;
import jp.Magic.magic.util.ConfigurationHandler;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTables;

import javax.annotation.Nonnull;
import javax.security.auth.login.Configuration;

public class MagicEntity extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ModBlock.Magic_Wood_Item);
    private boolean moveFlipper = false;
    public short rotationFlipper;

    public MagicEntity(EntityType<? extends MagicEntity> entity, World world) {
        super(entity, world);
        this.stepHeight = 1.5f;
    }
    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(0,new SwimGoal(this));
        this.goalSelector.addGoal(1,new EntityAIExtinguishFire());
        this.goalSelector.addGoal(2,new PanicGoal(this,1.5D));
        this.goalSelector.addGoal(3,new BreedGoal(this,0.8D));
        this.goalSelector.addGoal(4,new AvoidEntityGoal<>(this, PolarBearEntity.class,6.0F,1.0D,1.2D));
        this.goalSelector.addGoal(5,new TemptGoal(this,1.0D,false,TEMPTATION_ITEMS));
        this.goalSelector.addGoal(6,new FollowParentGoal(this,1.1D));
        this.goalSelector.addGoal(7,new RandomWalkingGoal(this,1.0D));
        this.goalSelector.addGoal(8,new LookAtGoal(this, PlayerEntity.class,6.0F));
        this.goalSelector.addGoal(9,new LookAtGoal(this,MagicEntity.class,6.0f));
        this.goalSelector.addGoal(10,new LookRandomlyGoal(this));
    }
    @Override
    protected void registerAttributes(){
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.16D);
    }
    @Override
    protected SoundEvent getAmbientSound(){
        return this.isChild() ? EntitySounds.MAGIC_BABY_AMBIENT : EntitySounds.MAGIC_AMBIENT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source){return EntitySounds.MAGIC_HURT;}
    @Override
    protected SoundEvent getDeathSound(){ return EntitySounds.MAGIC_DEATH; }
    @Override
    public void livingTick(){
        super.livingTick();
        if(this.world.isRemote){
            if(this.getPosX() != this.prevPosZ){
                if(this.moveFlipper){
                    this.rotationFlipper++;
                }
            }
        }
    }
    @Override
    protected int getExperiencePoints(PlayerEntity player){
        if(ConfigurationHandler.GENERAL.dropExp.get()){
            return super.getExperiencePoints(player);
        }
        return 0;
    }
    @Override
    public boolean canBreatheUnderwater(){
        return true;
    }
    @Override
    public boolean isBreedingItem(@Nonnull ItemStack stack){
        return !stack.isEmpty() && TEMPTATION_ITEMS.test(stack);
    }
    @Override
    @Nonnull
    public ResourceLocation getLootTable(){
        return ConfigurationHandler.GENERAL.dropItem.get() ? super.getLootTable() : LootTables.EMPTY;
    }
    @Override
    public AgeableEntity createChild(@Nonnull AgeableEntity entity){
        return ModEntity.MAGIC_ENTITY.create(this.world);
    }
    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size){
        return this.isChild() ? 0.5F:0.9f;
    }
    private class EntityAIExtinguishFire extends PanicGoal {
        EntityAIExtinguishFire() {
            super(MagicEntity.this, 2.0D);
        }
        @Override
        public boolean shouldExecute() {
            return (MagicEntity.this.isChild() || MagicEntity.this.isBurning()) && super.shouldExecute();
        }
    }
}
