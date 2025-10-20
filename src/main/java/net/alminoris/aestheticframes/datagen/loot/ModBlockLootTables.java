package net.alminoris.aestheticframes.datagen.loot;

import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootTables
{
    @Override
    protected void addTables()
    {
        func_218492_c(ModBlocks.WHITENED_WHITE_TERRACOTTA.get());

        for(String name : BlockSetsHelper.getWoods())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
                func_218492_c(ModBlocks.FRAMES.get(frameName+name).get());

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                func_218492_c(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
        }

        for(String name : BlockSetsHelper.getStones())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
                func_218492_c(ModBlocks.FRAMES.get(frameName+name).get());

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                func_218492_c(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
