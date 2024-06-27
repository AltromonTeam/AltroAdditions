package com.mrxdata.registry;

import com.mrxdata.blocks.AutoFusionCore;
import com.mrxdata.blocks.BlockCore;
import com.mrxdata.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class RegisterBlocks {

    public static BlockCore autoFusionCore;

    public static void init() {
        autoFusionCore = new AutoFusionCore();
        autoFusionCore.setRegistryName(new ResourceLocation(Reference.MODID, "auto_fusion_core"));
    }


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        init();
        event.getRegistry().registerAll(autoFusionCore);
    }


    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(new ItemBlock(autoFusionCore).setRegistryName(autoFusionCore.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        registerModel(Item.getItemFromBlock(autoFusionCore));
    }

    public static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
