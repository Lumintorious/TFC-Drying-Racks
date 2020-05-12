package com.lumintorious.mundanity.jei;

import java.util.Collections;

import com.lumintorious.mundanity.init.ModBlocks;
import com.lumintorious.mundanity.util.Reference;
import com.lumintorious.mundanity.util.handlers.CauldronRecipe;
import com.lumintorious.mundanity.util.handlers.CauldronRecipeHandler;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JeiPlugin implements IModPlugin{
	
	public static final String cauldronID = Reference.MOD_ID+".mixcauldron";
	@Override
	public void register(IModRegistry registry) {
		registerCauldronHandling(registry);
		
	}

	private void registerCauldronHandling(IModRegistry registry) {
		registry.addRecipeCatalyst(new ItemStack(ModBlocks.MIX_CAULDRON), cauldronID);
		registry.addRecipes(CauldronRecipeHandler.recipes,cauldronID);
		registry.handleRecipes(CauldronRecipe.class,CauldronRecipeWrapper::new, cauldronID);
	}

	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IJeiHelpers helpers = registry.getJeiHelpers();
		IGuiHelper guiHelpers = helpers.getGuiHelper();
		
		registry.addRecipeCategories(new CauldronRecipeCategory(guiHelpers));
		
		
	}
	
}
