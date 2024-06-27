package com.mrxdata.proxy;

import com.mrxdata.blocks.AutoFusionCore;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import static com.mrxdata.registry.RegisterBlocks.autoFusionCore;

public class ClientProxy extends CommonProxy {
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ModelLoader.setCustomStateMapper(autoFusionCore, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                boolean connected = state.getValue(AutoFusionCore.CONNECTED);
                return new ModelResourceLocation(new ResourceLocation("altroadditions", "auto_fusion_core_" + (connected ? "connected" : "disconnected")), "inventory");
            }
        });

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(autoFusionCore), 0, new ModelResourceLocation(new ResourceLocation("altroadditions", "auto_fusion_core_off"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(autoFusionCore), 1, new ModelResourceLocation(new ResourceLocation("altroadditions", "auto_fusion_core"), "inventory"));
    }
}
