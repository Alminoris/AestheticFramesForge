package net.alminoris.aestheticframes.datagen;

import net.alminoris.aestheticframes.AestheticFrames;
import net.alminoris.aestheticframes.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(DataGenerator output, ExistingFileHelper existingFileHelper)
    {
        super(output, AestheticFrames.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {

    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                new ResourceLocation(AestheticFrames.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/handheld")).texture("layer0",
                new ResourceLocation(AestheticFrames.MOD_ID,"item/" + item.getId().getPath()));
    }
}