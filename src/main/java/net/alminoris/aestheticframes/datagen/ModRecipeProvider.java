package net.alminoris.aestheticframes.datagen;

import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.item.ModItemGroups;
import net.alminoris.aestheticframes.item.ModItems;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.alminoris.aestheticframes.util.helper.ModJsonHelper;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(DataGenerator pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeExporter)
    {
        ShapedRecipeBuilder.shaped(ModBlocks.WHITENED_WHITE_TERRACOTTA.get(), 1)
                .pattern("#/")
                .define('#', Blocks.WHITE_TERRACOTTA)
                .define('/', Items.WHITE_DYE)
                .unlockedBy(getHasName(Blocks.WHITE_TERRACOTTA), has(Blocks.WHITE_TERRACOTTA))
                .unlockedBy(getHasName(Items.WHITE_DYE), has(Items.WHITE_DYE))
                .save(recipeExporter);

        for(String name : BlockSetsHelper.STONES)
        {
            Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", name.equals("basalt_side") ? "basalt" :
                    (name.equals("quartz_block_bottom") ? "quartz_block" : name)));

            registerFrame(recipeExporter, ModBlocks.FRAMES.get(name).get(), block);
            registerCrestFrame(recipeExporter, ModBlocks.FRAMES.get("crest_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerVerticalFrame(recipeExporter, ModBlocks.FRAMES.get("vertical_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerHorizontalFrame(recipeExporter, ModBlocks.FRAMES.get("horizontal_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerPerpendicularFrame(recipeExporter, ModBlocks.FRAMES.get("perpendicular_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerHorizontalCrestFrame(recipeExporter, ModBlocks.FRAMES.get("horizontal_crest_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerVerticalCrestFrame(recipeExporter, ModBlocks.FRAMES.get("vertical_crest_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerPerpendicularCrestFrame(recipeExporter, ModBlocks.FRAMES.get("perpendicular_crest_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerScaledCrestFrame(recipeExporter, ModBlocks.SCALED_FRAMES.get("crest_"+name).get(), ModBlocks.FRAMES.get("crest_"+name).get(), block);
        }

        for(String name : BlockSetsHelper.WOODS)
        {
            String blockName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");
            Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", "stripped_"+name+"_"+blockName));

            registerFrame(recipeExporter, ModBlocks.FRAMES.get(name).get(), block);
            registerCrestFrame(recipeExporter, ModBlocks.FRAMES.get("crest_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerVerticalFrame(recipeExporter, ModBlocks.FRAMES.get("vertical_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerHorizontalFrame(recipeExporter, ModBlocks.FRAMES.get("horizontal_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerPerpendicularFrame(recipeExporter, ModBlocks.FRAMES.get("perpendicular_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerHorizontalCrestFrame(recipeExporter, ModBlocks.FRAMES.get("horizontal_crest_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerVerticalCrestFrame(recipeExporter, ModBlocks.FRAMES.get("vertical_crest_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerPerpendicularCrestFrame(recipeExporter, ModBlocks.FRAMES.get("perpendicular_crest_"+name).get(), ModBlocks.FRAMES.get(name).get(), block);
            registerScaledCrestFrame(recipeExporter, ModBlocks.SCALED_FRAMES.get("crest_"+name).get(), ModBlocks.FRAMES.get("crest_"+name).get(), block);
        }

        registerExtraFrames(ModItemGroups.AN_WOOD_NAMES.toArray(new String[0]), "arborealnature");
        registerExtraFrames(ModItemGroups.WF_WOOD_NAMES.toArray(new String[0]), "wildfields");
        registerExtraFrames(ModItemGroups.EXTRA_STONES_WF.toArray(new String[0]), "wildfields");
        registerExtraFrames(ModItemGroups.MT_WOOD_NAMES.toArray(new String[0]), "missingtrees");
        registerExtraFrames(ModItemGroups.WT_WOOD_NAMES.toArray(new String[0]), "whisperleaftrees");
        registerExtraFrames(ModItemGroups.ST_WOOD_NAMES.toArray(new String[0]), "silverwoodtrees");
        registerExtraFrames(ModItemGroups.NSS_WOOD_NAMES.toArray(new String[0]), "natures_spirit", "_nss");
    }

    private void registerExtraFrames(String[] list, String modId)
    {
        for(String name : list)
        {
            ModJsonHelper.createShapedRecipe("frame_"+name, "4", modId+":stripped_"+name+"_log", "aestheticframes:whitened_white_terracotta",
                    "\"///\",", "\"/#/\",", "\"///\"");
            ModJsonHelper.createShapedRecipe("crest_frame_"+name, "2", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"/ /\",", "\" # \",", "\"/ /\"");
            ModJsonHelper.createShapedRecipe("vertical_frame_"+name, "1", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"/\",", "\"#\",", "\"/\"");
            ModJsonHelper.createShapedRecipe("horizontal_frame_"+name, "1", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "", "\"/#/\"", "");
            ModJsonHelper.createShapedRecipe("perpendicular_frame_"+name, "2", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\" / \",", "\"/#/\",", "\" / \"");
            ModJsonHelper.createShapedRecipe("horizontal_crest_frame_"+name, "3", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"/ /\",", "\"/#/\",", "\"/ /\"");
            ModJsonHelper.createShapedRecipe("vertical_crest_frame_"+name, "3", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"///\",", "\" # \",", "\"///\"");
            ModJsonHelper.createShapedRecipe("perpendicular_crest_frame_"+name, "4", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"///\",", "\"/#/\",", "\"///\"");
            ModJsonHelper.createShapedRecipe("crest_scaled_frame_"+name, "4", modId+":stripped_"+name+"_log", "aestheticframes:crest_frame_"+name,
                    "\"///\",", "\"/#/\",", "\"///\"");
        }
    }

    private static String getHasName(ItemLike p_176603_) {
        return "has_" + getItemName(p_176603_);
    }

    private static String getItemName(ItemLike p_176633_) {
        return Registry.ITEM.getKey(p_176633_.asItem()).getPath();
    }

    private void registerExtraFrames(String[] list, String modId, String toRemove)
    {
        for(String nameL : list)
        {
            String name;
            if (nameL.contains(toRemove))
                name = nameL.replaceFirst(toRemove, "");
            else
                name = nameL;

            ModJsonHelper.createShapedRecipe("frame_"+name, "4", modId+":stripped_"+name+"_log", "aestheticframes:whitened_white_terracotta",
                    "\"///\",", "\"/#/\",", "\"///\"");
            ModJsonHelper.createShapedRecipe("crest_frame_"+name, "2", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"/ /\",", "\" # \",", "\"/ /\"");
            ModJsonHelper.createShapedRecipe("vertical_frame_"+name, "1", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"/\",", "\"#\",", "\"/\"");
            ModJsonHelper.createShapedRecipe("horizontal_frame_"+name, "1", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "", "\"/#/\"", "");
            ModJsonHelper.createShapedRecipe("perpendicular_frame_"+name, "2", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\" / \",", "\"/#/\",", "\" / \"");
            ModJsonHelper.createShapedRecipe("horizontal_crest_frame_"+name, "3", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"/ /\",", "\"/#/\",", "\"/ /\"");
            ModJsonHelper.createShapedRecipe("vertical_crest_frame_"+name, "3", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"///\",", "\" # \",", "\"///\"");
            ModJsonHelper.createShapedRecipe("perpendicular_crest_frame_"+name, "4", modId+":stripped_"+name+"_log", "aestheticframes:frame_"+name,
                    "\"///\",", "\"/#/\",", "\"///\"");
            ModJsonHelper.createShapedRecipe("crest_scaled_frame_"+name, "4", modId+":stripped_"+name+"_log", "aestheticframes:crest_frame_"+name,
                    "\"///\",", "\"/#/\",", "\"///\"");
        }
    }

    private void registerFrame(Consumer<FinishedRecipe> recipeExporter, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shaped(frame, 4)
                .pattern("///")
                .pattern("/#/")
                .pattern("///")
                .define('#', ModBlocks.WHITENED_WHITE_TERRACOTTA.get())
                .define('/', strippedOak)
                .unlockedBy(getHasName(ModBlocks.WHITENED_WHITE_TERRACOTTA.get()), has(ModBlocks.WHITENED_WHITE_TERRACOTTA.get()))
                .unlockedBy(getHasName(strippedOak), has(strippedOak))
                .save(recipeExporter);
    }

    private void registerCrestFrame(Consumer<FinishedRecipe> recipeExporter, Block crestFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shaped(crestFrame, 2)
                .pattern("/ /")
                .pattern(" # ")
                .pattern("/ /")
                .define('#', frame)
                .define('/', strippedOak)
                .unlockedBy(getHasName(frame), has(frame))
                .unlockedBy(getHasName(strippedOak), has(strippedOak))
                .save(recipeExporter);
    }

    private void registerHorizontalFrame(Consumer<FinishedRecipe> recipeExporter, Block horizontalFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shaped(horizontalFrame, 1)
                .pattern("/#/")
                .define('#', frame)
                .define('/', strippedOak)
                .unlockedBy(getHasName(frame), has(frame))
                .unlockedBy(getHasName(strippedOak), has(strippedOak))
                .save(recipeExporter);
    }

    private void registerVerticalFrame(Consumer<FinishedRecipe> recipeExporter, Block verticalFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shaped(verticalFrame, 1)
                .pattern("/")
                .pattern("#")
                .pattern("/")
                .define('#', frame)
                .define('/', strippedOak)
                .unlockedBy(getHasName(frame), has(frame))
                .unlockedBy(getHasName(strippedOak), has(strippedOak))
                .save(recipeExporter);
    }

    private void registerPerpendicularFrame(Consumer<FinishedRecipe> recipeExporter, Block perpendicularFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shaped(perpendicularFrame, 2)
                .pattern(" / ")
                .pattern("/#/")
                .pattern(" / ")
                .define('#', frame)
                .define('/', strippedOak)
                .unlockedBy(getHasName(frame), has(frame))
                .unlockedBy(getHasName(strippedOak), has(strippedOak))
                .save(recipeExporter);
    }

    private void registerPerpendicularCrestFrame(Consumer<FinishedRecipe> recipeExporter, Block perpendicularCrestFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shaped(perpendicularCrestFrame, 4)
                .pattern("///")
                .pattern("/#/")
                .pattern("///")
                .define('#', frame)
                .define('/', strippedOak)
                .unlockedBy(getHasName(frame), has(frame))
                .unlockedBy(getHasName(strippedOak), has(strippedOak))
                .save(recipeExporter);
    }

    private void registerHorizontalCrestFrame(Consumer<FinishedRecipe> recipeExporter, Block horizontalCrestFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shaped(horizontalCrestFrame, 3)
                .pattern("/ /")
                .pattern("/#/")
                .pattern("/ /")
                .define('#', frame)
                .define('/', strippedOak)
                .unlockedBy(getHasName(frame), has(frame))
                .unlockedBy(getHasName(strippedOak), has(strippedOak))
                .save(recipeExporter);
    }

    private void registerVerticalCrestFrame(Consumer<FinishedRecipe> recipeExporter, Block verticalCrestFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shaped(verticalCrestFrame, 3)
                .pattern("///")
                .pattern(" # ")
                .pattern("///")
                .define('#', frame)
                .define('/', strippedOak)
                .unlockedBy(getHasName(frame), has(frame))
                .unlockedBy(getHasName(strippedOak), has(strippedOak))
                .save(recipeExporter);
    }

    private void registerScaledCrestFrame(Consumer<FinishedRecipe> recipeExporter, Block scaledCrestFrame, Block crestFrame, Block strippedOak)
    {
        ShapedRecipeBuilder.shaped(scaledCrestFrame, 4)
                .pattern("///")
                .pattern("/#/")
                .pattern("///")
                .define('#', crestFrame)
                .define('/', strippedOak)
                .unlockedBy(getHasName(crestFrame), has(crestFrame))
                .unlockedBy(getHasName(strippedOak), has(strippedOak))
                .save(recipeExporter);
    }
}