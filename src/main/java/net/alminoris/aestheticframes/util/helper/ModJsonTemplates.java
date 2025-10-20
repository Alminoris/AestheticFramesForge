package net.alminoris.aestheticframes.util.helper;

public class ModJsonTemplates
{

    public static String SHAPED_RECIPE = "{\n" +
            "  \"type\": \"minecraft:crafting_shaped\",\n" +
            "  \"category\": \"building\",\n" +
            "  \"key\": {\n" +
            "    \"#\": {\n" +
            "      \"item\": \"INGREDIENT_NAME\"\n" +
            "    },\n" +
            "    \"/\": {\n" +
            "      \"item\": \"LOG_NAME\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"pattern\": [\n" +
            "    PATTERN1,\n" +
            "    PATTERN2,\n" +
            "    PATTERN3\n" +
            "  ],\n" +
            "  \"result\": {\n" +
            "    \"count\": COUNT,\n" +
            "    \"item\": \"aestheticframes:OUTPUT_NAME\"\n" +
            "  }\n" +
            "}";

    public static String FUSION_PIECED_CONNECTING = "{\n" +
            "  \"fusion\": {\n" +
            "    \"layout\": \"pieced\",\n" +
            "    \"type\": \"fusion:connecting\"\n" +
            "  }\n" +
            "}";

    public static String FUSION_FULL_CONNECTING = "{\n" +
            "  \"fusion\": {\n" +
            "    \"type\": \"fusion:connecting\"\n" +
            "  }\n" +
            "}";

    public static String FUSION_CONNECTING_BLOCK_MODEL = "{\n" +
            "  \"parent\": \"minecraft:block/cube_all\",\n" +
            "  \"textures\": {\n" +
            "    \"all\": \"aestheticframes:block/NAME\"\n" +
            "  },\n" +
            "  \"connections\": {\n" +
            "    \"predicates\": [\n" +
            "      {\n" +
            "        \"type\": \"fusion:is_same_block\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"type\": \"fusion:or\"\n" +
            "  },\n" +
            "  \"loader\": \"fusion:model\",\n" +
            "  \"type\": \"fusion:connecting\"\n" +
            "}";

}