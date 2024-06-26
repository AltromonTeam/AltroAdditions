package com.mrxdata.registry;

import com.mrxdata.items.CustomItem;
import com.mrxdata.items.ItemCore;
import com.mrxdata.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import static com.mrxdata.registry.RegisterBlocks.autoFusionCore;

@Mod.EventBusSubscriber
public class RegisterItems {

    public static ItemCore customItem;

    public static void init() {
        customItem = new CustomItem();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        init();
        event.getRegistry().registerAll(customItem);
    }


}
