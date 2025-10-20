package net.alminoris.aestheticframes.util.helper;

import net.alminoris.aestheticframes.AestheticFrames;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ModJsonHelper
{
    public static void createShapedRecipe(String outputName, String count, String logName, String ingredientName, String pattern1, String pattern2, String pattern3)
    {
        String projectPath = System.getProperty("user.dir");

        String filePath = projectPath.replace("run", "src\\main\\resources") + "/data/"+ AestheticFrames.MOD_ID+"/recipes/";

        File directory = new File(filePath);
        if (!directory.exists())
            directory.mkdirs();

        String fileName = outputName + ".json";
        File modelFile = new File(directory, fileName);

        String jsonContent = ModJsonTemplates.SHAPED_RECIPE.replace("COUNT", count)
                .replace("INGREDIENT_NAME", ingredientName).replace("LOG_NAME", logName).replace("OUTPUT_NAME", outputName)
                .replace("PATTERN1", pattern1).replace("PATTERN2", pattern2).replace("PATTERN3", pattern3);

        try (FileWriter writer = new FileWriter(modelFile))
        {
            writer.write(jsonContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void createFusionModel(String name)
    {
        String projectPath = System.getProperty("user.dir");

        String filePath = projectPath.replace("run", "src\\main\\resources") + "/assets/"+ AestheticFrames.MOD_ID+"/models/block/";

        File directory = new File(filePath);
        if (!directory.exists())
            directory.mkdirs();

        String fileName = name + ".json";
        File modelFile = new File(directory, fileName);

        String jsonContent = ModJsonTemplates.FUSION_CONNECTING_BLOCK_MODEL.replace("NAME", name);

        try (FileWriter writer = new FileWriter(modelFile))
        {
            writer.write(jsonContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void createFusionTextureMetadataFull(String name)
    {
        String projectPath = System.getProperty("user.dir");

        String filePath = projectPath.replace("run", "src\\main\\resources") + "/assets/"+ AestheticFrames.MOD_ID+"/textures/block/";

        File directory = new File(filePath);
        if (!directory.exists())
            directory.mkdirs();

        String fileName = name + ".png.mcmeta";
        File modelFile = new File(directory, fileName);

        String jsonContent = ModJsonTemplates.FUSION_FULL_CONNECTING;

        try (FileWriter writer = new FileWriter(modelFile))
        {
            writer.write(jsonContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void createFusionTextureMetadataPieced(String name)
    {
        String projectPath = System.getProperty("user.dir");

        String filePath = projectPath.replace("run", "src\\main\\resources") + "/assets/"+ AestheticFrames.MOD_ID+"/textures/block/";

        File directory = new File(filePath);
        if (!directory.exists())
            directory.mkdirs();

        String fileName = name + ".png.mcmeta";
        File modelFile = new File(directory, fileName);

        String jsonContent = ModJsonTemplates.FUSION_PIECED_CONNECTING;

        try (FileWriter writer = new FileWriter(modelFile))
        {
            writer.write(jsonContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}