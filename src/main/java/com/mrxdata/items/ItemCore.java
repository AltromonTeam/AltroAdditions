package com.mrxdata.items;

import net.minecraft.item.Item;
import com.mrxdata.util.Reference;

public abstract class ItemCore extends Item {

    protected String name;

    public ItemCore(String name) {
        this.setRegistryName(Reference.MODID, name);
        this.setUnlocalizedName(name);
    }

    @Override
    public Item setUnlocalizedName(String name) {
        this.name = name;
        name = Reference.MODID + "." + name;
        return super.setUnlocalizedName(name);
    }
}
