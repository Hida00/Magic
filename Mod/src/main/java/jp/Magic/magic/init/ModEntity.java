package jp.Magic.magic.init;

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import jp.Magic.magic.Entity.MagicEntity;
import jp.Magic.magic.Main;
import jp.Magic.magic.util.BiomeDictionaryHelper;
import jp.Magic.magic.util.ConfigurationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.fixes.ItemSpawnEggSplit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Main.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntity {
    private static final List<EntityType<?>> ENTITIES = Lists.newArrayList();
    private static final List<Item> SPAWN_EGG = Lists.newArrayList();

    public static final EntityType<MagicEntity> MAGIC_ENTITY = createEntity(MagicEntity.class,MagicEntity::new,0.9f,0.95f,0x000000,0xFFFFFF);

    private static <T extends AnimalEntity> EntityType<T> createEntity(Class<T> entityClass ,EntityType.IFactory<T> factory,float width,float height,int eggPrimary,int eggSecondary){
        ResourceLocation location = new ResourceLocation(Main.MODID,classToStrong(entityClass));
        EntityType<T> entity = EntityType.Builder.create(factory, EntityClassification.CREATURE).size(width,height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        ENTITIES.add(entity);
        Item spawnEgg = new SpawnEggItem(entity,eggPrimary,eggSecondary,(new Item.Properties()).group(Main.MAGIC_MOD));
        spawnEgg.setRegistryName(new ResourceLocation(Main.MODID,classToStrong(entityClass) + "_spawn_egg"));
        SPAWN_EGG.add(spawnEgg);

        return entity;
    }
    private static String classToStrong(Class<? extends AnimalEntity> entityClass){
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,entityClass.getSimpleName()).replace("entity_","");
    }
    @SubscribeEvent
    public static void registerMagicEntity(RegistryEvent.Register<EntityType<?>> event){
        for(EntityType entity : ENTITIES){
            Preconditions.checkNotNull(entity.getRegistryName(),"registryName");
            event.getRegistry().register(entity);
            EntitySpawnPlacementRegistry.register(entity,EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,MagicEntity::canAnimalSpawn);
        }
    }
    @SubscribeEvent
    public static void registerSpawnEgg(RegistryEvent.Register<Item> event){
        for(Item spawnEgg : SPAWN_EGG){
            Preconditions.checkNotNull(spawnEgg.getRegistryName(),"registryName");
            event.getRegistry().register(spawnEgg);
        }
    }
    public static void addSpawn(){
        List<Biome> spawnableBiomes = Lists.newArrayList();

        List<BiomeDictionary.Type> includeList
                = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(ConfigurationHandler.SPAWN.include.get()));
        List<BiomeDictionary.Type> excludeList
                = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(ConfigurationHandler.SPAWN.exclude.get()));

        if(!includeList.isEmpty()){
            for(BiomeDictionary.Type type : includeList){
                for(Biome biome : BiomeDictionary.getBiomes(type)){
                    if(!biome.getSpawns(EntityClassification.CREATURE).isEmpty()){
                        spawnableBiomes.add(biome);
                    }
                }
            }
            if(!excludeList.isEmpty()){
                for(BiomeDictionary.Type type : excludeList){
                    Set<Biome> excludeBiomes = BiomeDictionary.getBiomes(type);
                    for(Biome biome : excludeBiomes){
                        spawnableBiomes.remove(biome);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException
                    ("Do not Leave the BiomeDictionary type inclusion list empty. " +
                            "If you wish to disable spawning of an entity, set the weight to 0 instead.");
        }
        for(Biome biome : spawnableBiomes){
            biome.getSpawns(EntityClassification.CREATURE).add(
                    new Biome.SpawnListEntry(MAGIC_ENTITY,ConfigurationHandler.SPAWN.weight.get(),
                            ConfigurationHandler.SPAWN.min.get(),ConfigurationHandler.SPAWN.max.get())
            );
        }
    }

}
