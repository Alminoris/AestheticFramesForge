package net.alminoris.aestheticframes.item;

import net.alminoris.aestheticframes.AestheticFrames;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AestheticFrames.MOD_ID);

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item)
    {
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
