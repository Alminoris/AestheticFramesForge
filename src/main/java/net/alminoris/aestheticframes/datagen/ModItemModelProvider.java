package net.alminoris.aestheticframes.datagen;

import net.alminoris.aestheticframes.AestheticFrames;
import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.item.ModItems;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(DataGenerator output, ExistingFileHelper existingFileHelper)
    {
        super(output, AestheticFrames.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        registerItemModel(ModBlocks.WHITENED_WHITE_TERRACOTTA.get());
        for (String name : BlockSetsHelper.getWoods())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
                registerItemModel(ModBlocks.FRAMES.get(frameName + name).get());

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                registerItemModel(ModBlocks.SCALED_FRAMES.get(frameName + name).get());
        }

        for (String name : BlockSetsHelper.getStones())
        {
            for (String frameName : BlockSetsHelper.FRAME_TYPES)
                registerItemModel(ModBlocks.FRAMES.get(frameName + name).get());

            for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                registerItemModel(ModBlocks.SCALED_FRAMES.get(frameName + name).get());
        }
    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryCreate( "item/generated")).texture("layer0",
                new ResourceLocation(AestheticFrames.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryCreate("item/handheld")).texture("layer0",
                new ResourceLocation(AestheticFrames.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder registerItemModel(Block block)
    {
        ResourceLocation id = ForgeRegistries.BLOCKS.getKey(block);

        return getBuilder(id.getPath())
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation(AestheticFrames.MOD_ID, "block/" + id.getPath())));
    }

    @Override
    public String getName() {
        return "";
    }
}