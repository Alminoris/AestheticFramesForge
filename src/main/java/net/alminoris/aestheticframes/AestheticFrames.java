package net.alminoris.aestheticframes;

import com.mojang.logging.LogUtils;
import net.alminoris.aestheticframes.block.ModBlocks;
import net.alminoris.aestheticframes.item.ModItemGroups;
import net.alminoris.aestheticframes.item.ModItems;
import net.alminoris.aestheticframes.util.helper.BlockSetsHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AestheticFrames.MOD_ID)
public class AestheticFrames
{
    public static final String MOD_ID = "aestheticframes";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AestheticFrames(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents entries)
    {
        if (entries.getTab() == ModItemGroups.AFS_TAB)
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
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}