package net.alminoris.aestheticframes.datagen;

import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.item.ModItemGroups;
import net.alminoris.aestheticframes.item.ModItems;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.alminoris.aestheticframes.util.helper.ModJsonHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(DataGenerator pOutput)
    {
        super(pOutput);
    }



    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> recipeExporter)
    {
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.WHITENED_WHITE_TERRACOTTA.get(), 1)
                .patternLine("#/")
                .key('#', Blocks.WHITE_TERRACOTTA)
                .key('/', Items.WHITE_DYE)
                .addCriterion(getHasName(Blocks.WHITE_TERRACOTTA), hasItem(Blocks.WHITE_TERRACOTTA))
                .addCriterion(getHasName(Items.WHITE_DYE), hasItem(Items.WHITE_DYE))
                .build(recipeExporter);

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


    private static String getHasName(IItemProvider item) {
        return "hasItem_" + getItemName(item);
    }

    private static String getItemName(IItemProvider item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem()).getPath();
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

    private void registerFrame(Consumer<IFinishedRecipe> recipeExporter, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shapedRecipe(frame, 4)
                .patternLine("///")
                .patternLine("/#/")
                .patternLine("///")
                .key('#', ModBlocks.WHITENED_WHITE_TERRACOTTA.get())
                .key('/', strippedOak)
                .addCriterion(getHasName(ModBlocks.WHITENED_WHITE_TERRACOTTA.get()), hasItem(ModBlocks.WHITENED_WHITE_TERRACOTTA.get()))
                .addCriterion(getHasName(strippedOak), hasItem(strippedOak))
                .build(recipeExporter);
    }

    private void registerCrestFrame(Consumer<IFinishedRecipe> recipeExporter, Block crestFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shapedRecipe(crestFrame, 2)
                .patternLine("/ /")
                .patternLine(" # ")
                .patternLine("/ /")
                .key('#', frame)
                .key('/', strippedOak)
                .addCriterion(getHasName(frame), hasItem(frame))
                .addCriterion(getHasName(strippedOak), hasItem(strippedOak))
                .build(recipeExporter);
    }

    private void registerHorizontalFrame(Consumer<IFinishedRecipe> recipeExporter, Block horizontalFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shapedRecipe(horizontalFrame, 1)
                .patternLine("/#/")
                .key('#', frame)
                .key('/', strippedOak)
                .addCriterion(getHasName(frame), hasItem(frame))
                .addCriterion(getHasName(strippedOak), hasItem(strippedOak))
                .build(recipeExporter);
    }

    private void registerVerticalFrame(Consumer<IFinishedRecipe> recipeExporter, Block verticalFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shapedRecipe(verticalFrame, 1)
                .patternLine("/")
                .patternLine("#")
                .patternLine("/")
                .key('#', frame)
                .key('/', strippedOak)
                .addCriterion(getHasName(frame), hasItem(frame))
                .addCriterion(getHasName(strippedOak), hasItem(strippedOak))
                .build(recipeExporter);
    }

    private void registerPerpendicularFrame(Consumer<IFinishedRecipe> recipeExporter, Block perpendicularFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shapedRecipe(perpendicularFrame, 2)
                .patternLine(" / ")
                .patternLine("/#/")
                .patternLine(" / ")
                .key('#', frame)
                .key('/', strippedOak)
                .addCriterion(getHasName(frame), hasItem(frame))
                .addCriterion(getHasName(strippedOak), hasItem(strippedOak))
                .build(recipeExporter);
    }

    private void registerPerpendicularCrestFrame(Consumer<IFinishedRecipe> recipeExporter, Block perpendicularCrestFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shapedRecipe(perpendicularCrestFrame, 4)
                .patternLine("///")
                .patternLine("/#/")
                .patternLine("///")
                .key('#', frame)
                .key('/', strippedOak)
                .addCriterion(getHasName(frame), hasItem(frame))
                .addCriterion(getHasName(strippedOak), hasItem(strippedOak))
                .build(recipeExporter);
    }

    private void registerHorizontalCrestFrame(Consumer<IFinishedRecipe> recipeExporter, Block horizontalCrestFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shapedRecipe(horizontalCrestFrame, 3)
                .patternLine("/ /")
                .patternLine("/#/")
                .patternLine("/ /")
                .key('#', frame)
                .key('/', strippedOak)
                .addCriterion(getHasName(frame), hasItem(frame))
                .addCriterion(getHasName(strippedOak), hasItem(strippedOak))
                .build(recipeExporter);
    }

    private void registerVerticalCrestFrame(Consumer<IFinishedRecipe> recipeExporter, Block verticalCrestFrame, Block frame, Block strippedOak)
    {
        ShapedRecipeBuilder.shapedRecipe(verticalCrestFrame, 3)
                .patternLine("///")
                .patternLine(" # ")
                .patternLine("///")
                .key('#', frame)
                .key('/', strippedOak)
                .addCriterion(getHasName(frame), hasItem(frame))
                .addCriterion(getHasName(strippedOak), hasItem(strippedOak))
                .build(recipeExporter);
    }

    private void registerScaledCrestFrame(Consumer<IFinishedRecipe> recipeExporter, Block scaledCrestFrame, Block crestFrame, Block strippedOak)
    {
        ShapedRecipeBuilder.shapedRecipe(scaledCrestFrame, 4)
                .patternLine("///")
                .patternLine("/#/")
                .patternLine("///")
                .key('#', crestFrame)
                .key('/', strippedOak)
                .addCriterion(getHasName(crestFrame), hasItem(crestFrame))
                .addCriterion(getHasName(strippedOak), hasItem(strippedOak))
                .build(recipeExporter);
    }
}