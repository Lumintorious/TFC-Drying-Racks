package com.lumintorious.tfc_drying_rack.registry;

import java.util.ArrayList;
import java.util.List;

import com.lumintorious.tfc_drying_rack.TFCDryingRack;
import com.lumintorious.tfc_drying_rack.objects.base.ItemBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = TFCDryingRack.MODID)
public class ItemRegistry {
	public static final List<Item> ITEMS = new ArrayList<>();
	
	public static Item
		SCOOP,
		FRAME;
	
	@SubscribeEvent
//	@SideOnly(Side.CLIENT)
	public static void registerItems(RegistryEvent.Register<Item> event) {

		event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
		for(Item item: ITEMS) {
			registerModel(item, "inventory");
		}
		event.getRegistry().registerAll(BlockRegistry.ITEM_BLOCKS.toArray(new Item[0]));
		for(Item item: BlockRegistry.ITEM_BLOCKS) {
			registerModel(item, "inventory");
		}
	}
	
	public static Item register(Item item) {
		ITEMS.add(item);
		return item;
	}

//	@SideOnly(Side.CLIENT)
	public static void registerModel(Item item, String id) {
		if(item instanceof ItemBase) {
			((ItemBase)item).registerModel(id);
		}else {
			TFCDryingRack.proxy.registerItemRenderer(item, 0, id);;
		}
	}

}
