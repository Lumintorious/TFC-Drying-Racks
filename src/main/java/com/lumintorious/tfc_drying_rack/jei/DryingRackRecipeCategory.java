package com.lumintorious.tfc_drying_rack.jei;

import java.util.List;

import com.lumintorious.tfc_drying_rack.TFCDryingRack;

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

public class DryingRackRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {

	private final IDrawable background;
	private final String uid;
	
	public DryingRackRecipeCategory(IGuiHelper guiHelper, String uid) {
		ResourceLocation location = new ResourceLocation(TFCDryingRack.MODID, "textures/gui/drying_rack.png");
		background = guiHelper.createDrawable(location, 0, 0, 167, 18);
		this.uid = uid;
	}
	
	@Override
	public String getUid() {
		return uid;
	}

	@Override
	public String getTitle() {
		return "Drying Rack";
	}

	@Override
	public String getModName() {
		return TFCDryingRack.NAME;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup isg = recipeLayout.getItemStacks();
		
		isg.init(0, true, 0, 0);
		isg.init(1, false, 149, 0);
		
		
		List<ItemStack> inputs = ingredients.getInputs(VanillaTypes.ITEM).get(0);
		List<ItemStack> outputs = ingredients.getOutputs(VanillaTypes.ITEM).get(0);
		
		isg.set(0,inputs.get(0));
		isg.set(1,outputs);

	}

}
