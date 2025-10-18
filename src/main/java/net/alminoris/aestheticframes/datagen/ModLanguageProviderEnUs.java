package net.alminoris.aestheticframes.datagen;

import net.alminoris.aestheticframes.AestheticFrames;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class ModLanguageProviderEnUs extends LanguageProvider
{
    public ModLanguageProviderEnUs(DataGenerator output)
    {
        super(output, AestheticFrames.MOD_ID, "en_us");
    }

    @Override
    public void addTranslations()
    {
        for (Block block : ForgeRegistries.BLOCKS)
        {
            ResourceLocation id = ForgeRegistries.BLOCKS.getKey(block);

            if (!AestheticFrames.MOD_ID.equals(id.getNamespace()))
                continue;

            String path = id.getPath();
            String[] parts = path.split("_");
            List<String> beforeFrame = new ArrayList<>();
            List<String> afterFrame = new ArrayList<>();
            boolean foundFrame = false;

            for (String part : parts) {
                if (part.equalsIgnoreCase("nss")) continue;

                if (part.equalsIgnoreCase("frame")) {
                    foundFrame = true;
                    beforeFrame.add("Frame");
                } else {
                    if (foundFrame) {
                        afterFrame.add(capitalize(part));
                    } else {
                        beforeFrame.add(capitalize(part));
                    }
                }
            }

            List<String> finalParts = new ArrayList<>();
            finalParts.addAll(afterFrame);
            finalParts.addAll(beforeFrame);

            String displayName = String.join(" ", finalParts);
            add("block." + AestheticFrames.MOD_ID + "." + path, displayName);
        }

        add("itemGroup.aestheticframes.afstab","Aesthetic Frames");
    }
}