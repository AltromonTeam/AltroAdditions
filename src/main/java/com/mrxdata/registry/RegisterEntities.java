//package com.mrxdata.registry;
//
//import com.mrxdata.entities.CustomEntity;
//import com.mrxdata.entities.EntityCore;
//import net.minecraftforge.fml.common.registry.EntityRegistry;
//import net.minecraftforge.registries.ForgeRegistries;
//import com.mrxdata.util.Reference;
//
//public class RegisterEntities {
//
//    private static int entityId = 1; // Пример идентификатора сущности
//
//    public static void init() {
//        registerEntity(CustomEntity.class, "custom_entity", entityId++, 80, 3, true);
//    }
//
//    private static void registerEntity(Class<? extends EntityCore> entityClass, String entityName, int entityId, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
//        EntityRegistry.register(ForgeRegistries.ENTITIES.getKey(entityClass), entityClass, entityName, entityId, Reference.MODID, trackingRange, updateFrequency, sendsVelocityUpdates);
//    }
//}
