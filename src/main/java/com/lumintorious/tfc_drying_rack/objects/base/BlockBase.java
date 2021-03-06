package com.lumintorious.tfc_drying_rack.objects.base;

import net.dries007.tfc.api.capability.size.Size;
import net.dries007.tfc.api.capability.size.Weight;
import net.dries007.tfc.objects.items.itemblock.ItemBlockTFC;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;

public class BlockBase extends Block{
	
	public BlockBase(String registryName, Material materialIn) {
		super(materialIn);
		this.setRegistryName(registryName);
		this.setTranslationKey(registryName);
		
	}


	private ItemBlock item;
	
	public Item getItemBlock() {
		if(item == null) {
			item = new ItemBlockTFC(this);
			item.setRegistryName(this.getRegistryName());
		}
		return item;
	}
	
	private void registerModel(int meta) {
		ModelLoader.setCustomModelResourceLocation(getItemBlock(), meta, new ModelResourceLocation(getItemBlock().getRegistryName(), "inventory"));
	}

}
