package net.alminoris.aestheticframes.item;

import net.alminoris.aestheticframes.AestheticFrames;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;


public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            new DeferredRegister<>(ForgeRegistries.ITEMS, AestheticFrames.MOD_ID);

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item)
    {
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
