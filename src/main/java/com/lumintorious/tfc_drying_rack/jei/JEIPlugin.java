package com.lumintorious.tfc_drying_rack.jei;

import java.util.List;
import java.util.stream.Collectors;

import com.lumintorious.tfc_drying_rack.TFCDryingRack;
import com.lumintorious.tfc_drying_rack.recipes.DryingRackRecipeHandler;
import com.lumintorious.tfc_drying_rack.registry.BlockRegistry;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin{
	
	public static final String rackID = TFCDryingRack.MODID+".drying_rack";
	
	@Override
	public void register(IModRegistry registry) {
		registerHandling(registry);
	}

	private void registerHandling(IModRegistry registry) {
		registry.addRecipeCatalyst(new ItemStack(BlockRegistry.DRYING_RACK), rackID);
		List<DryingRackRecipeWrapper> list = DryingRackRecipeHandler.recipes
	            .stream()
	            .map(DryingRackRecipeWrapper::new)
	            .collect(Collectors.toList());
//		registry.addRecipes(DryingRackRecipeHandler.recipes, rackID);
		registry.addRecipes(list, rackID);
//		registry.handleRecipes(DryingRackRecipe.class, DryingRackRecipeWrapper::new, rackID);

	}

	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IJeiHelpers helpers = registry.getJeiHelpers();
		IGuiHelper guiHelpers = helpers.getGuiHelper();
		
		registry.addRecipeCategories(new DryingRackRecipeCategory(guiHelpers, rackID));
		
		
	}
	
}
