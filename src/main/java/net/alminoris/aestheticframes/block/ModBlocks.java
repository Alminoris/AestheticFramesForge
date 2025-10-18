package net.alminoris.aestheticframes.block;

import net.alminoris.aestheticframes.AestheticFrames;
import net.alminoris.aestheticframes.item.ModItemGroups;
import net.alminoris.aestheticframes.item.ModItems;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AestheticFrames.MOD_ID);

    public static final RegistryObject<Block> WHITENED_WHITE_TERRACOTTA = registerBlock("whitened_white_terracotta",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA)));

    public static final Dictionary<String, RegistryObject<Block>> FRAMES = new Hashtable<>()
    {{
        for(String frameName : BlockSetsHelper.FRAME_TYPES)
        {
            for(String name : BlockSetsHelper.getWoods())
            {
                put(frameName+name, registerBlock(frameName+"frame_"+name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA))));
            }

            for(String name : BlockSetsHelper.getStones())
            {
                put(frameName+name, registerBlock(frameName+"frame_"+name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA))));
            }
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SCALED_FRAMES = new Hashtable<>()
    {{
        for(String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
        {
            for(String name : BlockSetsHelper.getWoods())
            {
                put(frameName+name, registerBlock(frameName+"scaled_frame_"+name,
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA))));
            }

            for(String name : BlockSetsHelper.getStones())
            {
                put(frameName+name, registerBlock(frameName+"scaled_frame_"+name,
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA))));
            }
        }
    }};

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroups.AFS_TAB)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}