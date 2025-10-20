package net.alminoris.aestheticframes.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.alminoris.aestheticframes.datagen.loot.ModBlockLootTables;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class ModLootTableProvider extends LootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>>
            loot_tables = ImmutableList.of(Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK));

    public ModLootTableProvider(DataGenerator pGenerator)
    {
        super(pGenerator);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationResults validationtracker)
    {
        map.forEach((id, table) -> LootTableManager.func_215302_a(validationtracker, id, table, map::get));
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return loot_tables;
    }
}