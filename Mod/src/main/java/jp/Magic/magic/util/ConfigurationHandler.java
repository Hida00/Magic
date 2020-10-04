package jp.Magic.magic.util;

import net.minecraft.util.datafix.fixes.SpawnEggNames;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class ConfigurationHandler {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);
    public static final Spawn SPAWN = new Spawn(BUILDER);

    public static class General {
        public final ForgeConfigSpec.BooleanValue dropItem;
        public final ForgeConfigSpec.BooleanValue dropExp;

        General(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            dropItem = builder.comment("Enable that Entity drop Item(0-2 Magic Wood)")
                    .translation("magic.configgui.dropItem")
                    .define("dropItem", false);
            dropExp = builder.comment("Entity should drop experience?")
                    .translation("magic.configgui.dropExp")
                    .define("dropExp", true);
            builder.pop();
        }
    }

    public static class Spawn {
        public final ForgeConfigSpec.IntValue min;
        public final ForgeConfigSpec.IntValue max;
        public final ForgeConfigSpec.IntValue weight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> include;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> exclude;

        Spawn(ForgeConfigSpec.Builder builder) {
            builder.push("spawn chances");
            builder.comment("Configure Entity weight & min/max group size. Set weight to 0 to disable.");
            min = builder.defineInRange("min",1,0,64);
            max = builder.defineInRange("max",4,0,64);
            weight = builder.defineInRange("weight",4,0,100);
            builder.pop();
            builder.push("Spawnable Biomes");
            builder.comment("BiomeDictionary type to include & exclude.");
            include = builder.defineList("include", Collections.singletonList(SNOWY.toString()),
                    o -> BiomeDictionary.Type.getAll().
                            contains(BiomeDictionaryHelper.getType(String.valueOf(o))));
            exclude = builder.defineList("exclude", Arrays.asList(FOREST.toString()),
                    o -> BiomeDictionary.Type.getAll().
                            contains(BiomeDictionaryHelper.getType(String.valueOf(o))));
        }
    }
    public static final ForgeConfigSpec spec = BUILDER.build();
}
