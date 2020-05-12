package com.lumintorious.mundanity.jei;

import java.util.List;

import com.lumintorious.mundanity.util.Reference;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CauldronRecipeCategory implements IRecipeCategory {

	private final IDrawable background;
	
	public CauldronRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID,"textures/gui/mixcauldron.png");
		background = guiHelper.createDrawable(location, 0, 0, 108, 18);
	}
	
	@Override
	public String getUid() {
		return JeiPlugin.cauldronID;
	}

	@Override
	public String getTitle() {
		return "Mix Cauldron";
	}

	@Override
	public String getModName() {
		return Reference.NAME;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup isg = recipeLayout.getItemStacks();
		
		isg.init(0, true, 0, 0);
		isg.init(1, true, 18, 0);
		isg.init(2, true, 36, 0);
		isg.init(3, true, 54, 0);
		isg.init(4, false, 90, 0);
		
		List<ItemStack> inputs = ingredients.getInputs(VanillaTypes.ITEM).get(0);
		List<ItemStack> outputs = ingredients.getOutputs(VanillaTypes.ITEM).get(0);
		
		isg.set(0,inputs.get(0));
		isg.set(1,inputs.get(1));
		isg.set(2,inputs.get(2));
		isg.set(3,inputs.get(3));
		isg.set(4,outputs);

	}

}
