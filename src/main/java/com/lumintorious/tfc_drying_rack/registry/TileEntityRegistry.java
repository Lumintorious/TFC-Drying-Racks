package com.lumintorious.tfc_drying_rack.registry;

import com.lumintorious.tfc_drying_rack.objects.rack.TileEntityRack;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityRegistry {
	
	
	public static void register() {

    	GameRegistry.registerTileEntity(TileEntityRack.class, TileEntityRack.NAME);
	}
}
