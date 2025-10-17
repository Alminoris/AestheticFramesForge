package net.alminoris.aestheticframes.datagen;

import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider
{
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate()
    {
        dropSelf(ModBlocks.WHITENED_WHITE_TERRACOTTA.get());

        for(String name : BlockSetsHelper.getWoods())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
                dropSelf(ModBlocks.FRAMES.get(frameName+name).get());

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                dropSelf(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
        }

        for(String name : BlockSetsHelper.getStones())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
                dropSelf(ModBlocks.FRAMES.get(frameName+name).get());

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                dropSelf(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}