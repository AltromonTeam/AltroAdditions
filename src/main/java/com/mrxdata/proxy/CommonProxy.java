package com.mrxdata.proxy;

import com.mrxdata.AltroCore;
import com.mrxdata.tiles.TileEntityAutoFusionCore;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void preInit() {
        GameRegistry.registerTileEntity(TileEntityAutoFusionCore.class, "tile_entity_auto_fusion_core");
        System.out.println("Tile Entity Registered");
    }
    public void init(FMLInitializationEvent event) {
        // Общая инициализация
    }
}
