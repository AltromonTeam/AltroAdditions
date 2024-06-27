package com.mrxdata;

import com.mrxdata.proxy.CommonProxy;
import com.mrxdata.registry.RegisterBlocks;
import com.mrxdata.registry.RegisterItems;
import com.mrxdata.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class AltroCore {
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(RegisterBlocks.class);
        MinecraftForge.EVENT_BUS.register(RegisterItems.class);
        init();
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        RegisterBlocks.registerModels(event);
        RegisterBlocks.registerModels(event);
    }

    public static CreativeTabs tabAltroAdditions;

    public static void init() {
        tabAltroAdditions = new CreativeTabs(Reference.MODID) {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(RegisterBlocks.autoFusionCore));
            }
            @Override
            public String getTranslatedTabLabel() {
                return "AltroAdditions";
            }
        };

    }
    public static void logMessage(String message) {
        Minecraft mc = Minecraft.getMinecraft();
        mc.player.sendChatMessage(message);
    }
}
