package net.alminoris.aestheticframes.datagen;

import net.alminoris.aestheticframes.AestheticFrames;
import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.alminoris.aestheticframes.util.helper.ModJsonHelper;
import net.alminoris.aestheticframes.util.helper.ModJsonTemplates;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(DataGenerator output, ExistingFileHelper exFileHelper)
    {
        super(output, AestheticFrames.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(ModBlocks.WHITENED_WHITE_TERRACOTTA.get());
        blockItem(ModBlocks.WHITENED_WHITE_TERRACOTTA, "block/whitened_white_terracotta");

        for (String name : BlockSetsHelper.getWoods())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
            {
                Block block = ModBlocks.FRAMES.get(frameName + name).get();
                registerSimpleStateAndItem(block);
            }

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
            {
                Block block = ModBlocks.SCALED_FRAMES.get(frameName + name).get();
                registerSimpleStateAndItem(block);
            }
        }

        for (String name : BlockSetsHelper.getStones())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
            {
                Block block = ModBlocks.FRAMES.get(frameName + name).get();
                registerSimpleStateAndItem(block);
            }

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
            {
                Block block = ModBlocks.SCALED_FRAMES.get(frameName + name).get();
                registerSimpleStateAndItem(block);
            }
        }
    }

    private void registerSimpleStateAndItem(Block block)
    {
        ResourceLocation id = ForgeRegistries.BLOCKS.getKey(block);
        if (id == null) return;

        // reference an already existing model (not generating one)
        ModelFile model = new ModelFile.UncheckedModelFile(
                new ResourceLocation(AestheticFrames.MOD_ID, "block/" + id.getPath())
        );

        // creates blockstate that points to block/<name>.json
        simpleBlock(block, ConfiguredModel.builder().modelFile(model).build());

        // creates item model that points to same block model
        itemModels().getBuilder(id.getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        new ResourceLocation(AestheticFrames.MOD_ID, "block/" + id.getPath())
                ));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String name)
    {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("aestheticframes:" + name));
    }
}