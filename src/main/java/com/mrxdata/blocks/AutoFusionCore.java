package com.mrxdata.blocks;

import com.mrxdata.AltroCore;
import com.mrxdata.util.Reference;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AutoFusionCore extends BlockCore {

    public AutoFusionCore() {
        super(Material.IRON, Reference.MODID);
        setUnlocalizedName("auto_fusion_core");
        setCreativeTab(AltroCore.tabAltroAdditions);
        setHardness(3.0F);
        setResistance(5.0F);
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 2);
    }
}
