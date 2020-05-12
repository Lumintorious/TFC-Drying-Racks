package com.lumintorious.mundanity.jei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lumintorious.mundanity.util.handlers.CauldronRecipe;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.item.ItemStack;

public class CauldronRecipeWrapper implements ICraftingRecipeWrapper{
	
	List<List<ItemStack>> inputs;
	ItemStack output ;

	public CauldronRecipeWrapper(CauldronRecipe recipe) {
		List<ItemStack> inputer = new ArrayList<ItemStack>();
		for(int i = 0;i<recipe.getInputs().length;i++) {
			inputer.add(recipe.getInputs()[i].copy());
		}
		this.inputs=Collections.singletonList(inputer);
		this.output=recipe.getOutputs().copy();
	}
	
	
	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setOutput(VanillaTypes.ITEM, output);
		ingredients.setInputLists(VanillaTypes.ITEM, inputs);
	}

}
