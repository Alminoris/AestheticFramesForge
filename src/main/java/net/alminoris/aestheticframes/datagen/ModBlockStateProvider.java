package net.alminoris.aestheticframes.datagen;

import net.alminoris.aestheticframes.AestheticFrames;
import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.alminoris.aestheticframes.util.helper.ModJsonHelper;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper fileHelper)
    {
        super(gen, AestheticFrames.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(ModBlocks.WHITENED_WHITE_TERRACOTTA.get());

        for (String name : BlockSetsHelper.getWoods())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
            {
                ModJsonHelper.createFusionModel(frameName+"frame_"+name);
                ModJsonHelper.createFusionTextureMetadataPieced(frameName+"frame_"+name);
                registerSimpleStateAndItem(ModBlocks.FRAMES.get(frameName + name).get());
            }

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
            {
                ModJsonHelper.createFusionModel(frameName+"frame_"+name);
                ModJsonHelper.createFusionTextureMetadataFull(frameName+"frame_"+name);
                registerSimpleStateAndItem(ModBlocks.SCALED_FRAMES.get(frameName + name).get());
            }
        }

        for (String name : BlockSetsHelper.getStones())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
            {
                ModJsonHelper.createFusionModel(frameName+"frame_"+name);
                ModJsonHelper.createFusionTextureMetadataPieced(frameName+"frame_"+name);
                registerSimpleStateAndItem(ModBlocks.FRAMES.get(frameName + name).get());
            }

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
            {
                ModJsonHelper.createFusionModel(frameName+"frame_"+name);
                ModJsonHelper.createFusionTextureMetadataFull(frameName+"frame_"+name);
                registerSimpleStateAndItem(ModBlocks.SCALED_FRAMES.get(frameName + name).get());
            }
        }
    }

    private void registerSimpleStateAndItem(Block block)
    {
        ResourceLocation id = ForgeRegistries.BLOCKS.getKey(block);
        if (id == null)
            return;

        ModelFile model = new ModelFile.UncheckedModelFile(
                new ResourceLocation(AestheticFrames.MOD_ID, "block/" + id.getPath())
        );

        simpleBlock(block, new ConfiguredModel(model));
    }
}