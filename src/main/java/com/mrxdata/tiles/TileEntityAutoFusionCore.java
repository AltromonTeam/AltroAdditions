package com.mrxdata.tiles;
import java.lang.System;



import appeng.api.AEApi;
import appeng.api.networking.*;
import appeng.api.util.AEColor;
import appeng.api.util.AEPartLocation;
import appeng.api.util.DimensionalCoord;
import appeng.tile.grid.AENetworkTile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

import com.mrxdata.AltroCore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.EnumSet;


import static com.mrxdata.registry.RegisterBlocks.autoFusionCore;


public class TileEntityAutoFusionCore extends AENetworkTile implements IGridHost, IGridBlock {
    public TileEntityAutoFusionCore() {
        this.getProxy().setIdlePowerUsage(1);
    }


    @Nullable
    @Override
    public IGridNode getGridNode(@Nonnull AEPartLocation aePartLocation) {
        AltroCore.logMessage("getGridNode called");
        return AEApi.instance().grid().createGridNode(this);
    }


    @Override
    public double getIdlePowerUsage() {
        return 1;
    }

    @Nonnull
    @Override
    public EnumSet<GridFlags> getFlags() {
        return null;
    }

    @Override
    public boolean isWorldAccessible() {
        return true;
    }

    @Nonnull
    @Override
    public DimensionalCoord getLocation() {
        return new DimensionalCoord(world, pos.getX(), pos.getY(), pos.getZ());
    }

    @Nonnull
    @Override
    public AEColor getGridColor() {
        return AEColor.TRANSPARENT;
    }

    @Override
    public void onGridNotification(@Nonnull GridNotification gridNotification) {

    }

    @Override
    public void setNetworkStatus(IGrid iGrid, int i) {

    }

    @Nonnull
    @Override
    public EnumSet<EnumFacing> getConnectableSides() {
        return EnumSet.allOf(EnumFacing.class);
    }

    @Nonnull
    @Override
    public IGridHost getMachine() {
        return this;
    }


    @Nonnull
    @Override
    public ItemStack getMachineRepresentation() {
        return new ItemStack(autoFusionCore);
    }
}