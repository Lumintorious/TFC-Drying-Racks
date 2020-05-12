package com.lumintorious.tfc_drying_rack;

import com.lumintorious.tfc_drying_rack.recipes.DryingRackRecipeHandler;
import com.lumintorious.tfc_drying_rack.registry.TileEntityRegistry;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TFCDryingRack.MODID, name = TFCDryingRack.NAME, version = TFCDryingRack.VERSION)
public class TFCDryingRack
{
    public static final String MODID = "tfc_drying_rack";
    public static final String NAME = "TFC Drying Rack";
    public static final String VERSION = "1.0";

    @Instance
    public static TFCDryingRack instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	TileEntityRegistry.register();
    	
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
//    	System.exit(0);
    	DryingRackRecipeHandler.init();
    }
    
}
