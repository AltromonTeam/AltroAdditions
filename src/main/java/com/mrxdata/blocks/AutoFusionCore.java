package com.mrxdata.blocks;

import com.mrxdata.AltroCore;
import com.mrxdata.tiles.TileEntityAutoFusionCore;
import com.mrxdata.tiles.TileEntityBlock;
import com.mrxdata.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class AutoFusionCore extends TileEntityBlock {

    public static final PropertyBool CONNECTED = PropertyBool.create("connected");

    public AutoFusionCore() {
        super(Material.IRON, Reference.MODID);
        setUnlocalizedName("auto_fusion_core");
        setCreativeTab(AltroCore.tabAltroAdditions);
        setHardness(3.0F);
        setResistance(5.0F);
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 2);
        this.setDefaultState(this.blockState.getBaseState().withProperty(CONNECTED, false));
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GREEN + I18n.format("tile.altroadditions.auto_fusion_core.tooltip"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public Class<TileEntityAutoFusionCore> getTileEntityClass() {

        return TileEntityAutoFusionCore.class;
    }

    @Override
    public TileEntityAutoFusionCore createTileEntity(World world, IBlockState blockState) {

        return new TileEntityAutoFusionCore();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, CONNECTED);
    }


    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(CONNECTED, meta == 1);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(CONNECTED) ? 1 : 0;
    }

}
