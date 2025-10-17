package net.alminoris.aestheticframes.item;

import net.alminoris.aestheticframes.AestheticFrames;
import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = AestheticFrames.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AestheticFrames.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AFS_TAB = CREATIVE_MODE_TABS.register("afstab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(ModBlocks.FRAMES.get("oak").get().asItem()::getDefaultInstance)
            .title(Component.translatable("itemgroup.afstab"))
            .displayItems((parameters, entries) ->
            {
                entries.accept(ModBlocks.WHITENED_WHITE_TERRACOTTA.get());

                for(String name : BlockSetsHelper.WOODS)
                {
                    for (String frameName : BlockSetsHelper.FRAME_TYPES)
                        entries.accept(ModBlocks.FRAMES.get(frameName+name).get());
                }

                if (ModList.get().isLoaded("arborealnature"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
                    {
                        for (String frameName : BlockSetsHelper.FRAME_TYPES)
                            entries.accept(ModBlocks.FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("wildfields"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
                    {
                        for (String frameName : BlockSetsHelper.FRAME_TYPES)
                            entries.accept(ModBlocks.FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("whisperleaftrees"))
                {
                    for(String name : BlockSetsHelper.WT_WOOD_NAMES)
                    {
                        for (String frameName : BlockSetsHelper.FRAME_TYPES)
                            entries.accept(ModBlocks.FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("silverwoodtrees"))
                {
                    for(String name : BlockSetsHelper.ST_WOOD_NAMES)
                    {
                        for (String frameName : BlockSetsHelper.FRAME_TYPES)
                            entries.accept(ModBlocks.FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("missingtrees"))
                {
                    for(String name : BlockSetsHelper.MT_WOOD_NAMES)
                    {
                        for (String frameName : BlockSetsHelper.FRAME_TYPES)
                            entries.accept(ModBlocks.FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("natures_spirit"))
                {
                    for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
                    {
                        for (String frameName : BlockSetsHelper.FRAME_TYPES)
                            entries.accept(ModBlocks.FRAMES.get(frameName+name).get());
                    }
                }

                for(String name : BlockSetsHelper.STONES)
                {
                    for (String frameName : BlockSetsHelper.FRAME_TYPES)
                        entries.accept(ModBlocks.FRAMES.get(frameName+name).get());
                }

                if (ModList.get().isLoaded("wildfields"))
                {
                    for(String name : BlockSetsHelper.EXTRA_STONES_WF)
                    {
                        for (String frameName : BlockSetsHelper.FRAME_TYPES)
                            entries.accept(ModBlocks.FRAMES.get(frameName+name).get());
                    }
                }

                for(String name : BlockSetsHelper.WOODS)
                {
                    for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                        entries.accept(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
                }

                if (ModList.get().isLoaded("arborealnature"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
                    {
                        for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                            entries.accept(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("wildfields"))
                {
                    for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
                    {
                        for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                            entries.accept(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("whisperleaftrees"))
                {
                    for(String name : BlockSetsHelper.WT_WOOD_NAMES)
                    {
                        for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                            entries.accept(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("silverwoodtrees"))
                {
                    for(String name : BlockSetsHelper.ST_WOOD_NAMES)
                    {
                        for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                            entries.accept(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("missingtrees"))
                {
                    for(String name : BlockSetsHelper.MT_WOOD_NAMES)
                    {
                        for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                            entries.accept(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
                    }
                }

                if (ModList.get().isLoaded("natures_spirit"))
                {
                    for(String name : BlockSetsHelper.NSS_WOOD_NAMES)
                    {
                        for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                            entries.accept(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
                    }
                }

                for(String name : BlockSetsHelper.STONES)
                {
                    for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                        entries.accept(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
                }

                if (ModList.get().isLoaded("wildfields"))
                {
                    for(String name : BlockSetsHelper.EXTRA_STONES_WF)
                    {
                        for (String frameName : BlockSetsHelper.SCALED_FRAME_TYPES)
                            entries.accept(ModBlocks.SCALED_FRAMES.get(frameName+name).get());
                    }
                }
            }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}