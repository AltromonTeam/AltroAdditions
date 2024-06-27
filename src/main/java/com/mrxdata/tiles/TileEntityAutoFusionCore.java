package com.mrxdata.tiles;





import appeng.api.util.AECableType;
import appeng.api.util.AEPartLocation;
import appeng.tile.grid.AENetworkTile;
import com.mrxdata.blocks.AutoFusionCore;
import net.minecraft.block.state.IBlockState;



public class TileEntityAutoFusionCore extends AENetworkTile {

    private boolean lastConnectedState;

    public TileEntityAutoFusionCore() {
        this.getProxy().setIdlePowerUsage(1);
        this.lastConnectedState = false;
    }

    @Override
    public AECableType getCableConnectionType(final AEPartLocation dir) {
        return AECableType.COVERED;
    }
//    Doesn't work:
//    @Override
//    public void onReady() {
//        super.onReady();
//        this.getProxy().setVisualRepresentation(this.getItemFromTile(this));
//        }


    @Override
    public void gridChanged() {
        boolean isConnected = this.getProxy().isActive();
        if (isConnected != lastConnectedState) {
            lastConnectedState = isConnected;
            updateBlockState(isConnected);
        }
    }

    private void updateBlockState(boolean isConnected) {
        if (world != null) {
            IBlockState state = world.getBlockState(pos);
            if (state.getBlock() instanceof AutoFusionCore) {
                world.setBlockState(pos, state.withProperty(AutoFusionCore.CONNECTED, isConnected), 3);
            }
        }
    }

}