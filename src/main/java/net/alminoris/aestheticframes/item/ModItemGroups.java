package net.alminoris.aestheticframes.item;

import net.alminoris.aestheticframes.AestheticFrames;
import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.ModList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ModItemGroups
{
    public static List<String> WF_WOOD_NAMES = Arrays.asList("olive", "tamarisk", "western_serviceberry", "trembling_aspen", "cottonwood");

    public static List<String> AN_WOOD_NAMES = Arrays.asList("hazelnut", "hornbeam", "hawthorn", "quince", "plum", "mango", "fig", "viburnum",
            "white_mulberry", "wild_cherry", "bauhinia", "pine", "fir", "cedar", "araucaria", "juniper",
            "bald_cypress", "thuja", "sequoia", "mountain_hemlock", "cryptomeria", "yew", "larch");

    public static List<String> EXTRA_STONES_WF = Arrays.asList("dolomite_block", "saltmarsh_block", "loessic_marl_block", "loamy_marl_block", "fossil_marlstone_block", "limestone_block");

    public static List<String> ST_WOOD_NAMES = Arrays.asList( "walnut", "silver_maple", "staghorn_sumac", "silverberry");

    public static List<String> WT_WOOD_NAMES = Arrays.asList("willow", "poplar", "alder", "aspen");

    public static List<String> MT_WOOD_NAMES = Arrays.asList("azalea", "apple", "scots_pine", "swamp_oak");

    public static List<String> NSS_WOOD_NAMES = Arrays.asList("aspen_nss", "cedar_nss", "coconut_nss", "cypress_nss", "fir_nss", "ghaf_nss",
            "larch_nss", "mahogany_nss", "maple_nss", "olive_nss", "palo_verde_nss", "redwood_nss", "saxaul_nss", "sugi_nss", "willow_nss", "wisteria_nss");

    public static final ItemGroup AFS_TAB = new ItemGroup(AestheticFrames.MOD_ID + ".afstab")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.FRAMES.get("oak").get().asItem());
        }

        @Override
        public String getTranslationKey() {
            return new TranslationTextComponent("itemGroup." + AestheticFrames.MOD_ID + ".afstab").getKey();
        }
    };

    public static void registerModItemGroups()
    {
        WF_WOOD_NAMES = new ArrayList<>();

        AN_WOOD_NAMES = new ArrayList<>();

        EXTRA_STONES_WF = new ArrayList<>();

        ST_WOOD_NAMES = new ArrayList<>();

        WT_WOOD_NAMES = new ArrayList<>();

        MT_WOOD_NAMES = new ArrayList<>();

        NSS_WOOD_NAMES = new ArrayList<>();

        if (ModList.get().isLoaded("arborealnature"))
        {
            AN_WOOD_NAMES = Arrays.asList("hazelnut", "hornbeam", "hawthorn", "quince", "plum", "mango", "fig", "viburnum",
                    "white_mulberry", "wild_cherry", "bauhinia", "pine", "fir", "cedar", "araucaria", "juniper");
        }
        if (ModList.get().isLoaded("wildfields"))
        {
            WF_WOOD_NAMES = Arrays.asList("olive", "tamarisk", "western_serviceberry");
            EXTRA_STONES_WF = Arrays.asList("dolomite_block", "saltmarsh_block", "loessic_marl_block", "loamy_marl_block", "fossil_marlstone_block");
        }
        if (ModList.get().isLoaded("silverwoodtrees"))
        {
            ST_WOOD_NAMES = Arrays.asList( "walnut", "silver_maple", "staghorn_sumac", "silverberry");
        }
        if (ModList.get().isLoaded("whisperleaftrees"))
        {
            WT_WOOD_NAMES = Arrays.asList("willow", "poplar", "alder", "aspen");
        }
        if (ModList.get().isLoaded("missingtrees"))
        {
            MT_WOOD_NAMES = Arrays.asList("azalea", "apple", "scots_pine", "swamp_oak");
        }
        if (ModList.get().isLoaded("natures_spirit"))
        {
            NSS_WOOD_NAMES = Arrays.asList("aspen_nss", "cedar_nss", "coconut_nss", "cypress_nss", "fir_nss", "ghaf_nss",
                    "larch_nss", "mahogany_nss", "maple_nss", "olive_nss", "palo_verde_nss", "redwood_nss", "saxaul_nss", "sugi_nss", "willow_nss", "wisteria_nss");
        }
    }
}