package net.alminoris.aestheticframes.util.helper;

public class ModJsonTemplates {

    public static String SHAPED_RECIPE = "{\n" +
            "  \"type\": \"minecraft:crafting_shaped\",\n" +
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

}