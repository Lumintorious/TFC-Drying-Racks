package com.lumintorious.tfc_drying_rack.recipes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.lumintorious.tfc_drying_rack.DryingRackConfig;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.recipes.ShapedRecipe;
import crafttweaker.mc1120.recipes.ShapedRecipeBasic;
import mezz.jei.api.IRecipeRegistry;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Plant;
import net.dries007.tfc.compat.crafttweaker.CTHelper;
import net.dries007.tfc.compat.crafttweaker.CTItemRegistry;
import net.dries007.tfc.compat.crafttweaker.CTQuern;
import net.dries007.tfc.compat.jei.categories.QuernCategory;
import net.dries007.tfc.objects.blocks.BlocksTFC;
import net.dries007.tfc.objects.blocks.plants.BlockPlantTFC;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemSeedsTFC;
import net.dries007.tfc.objects.items.ItemsTFC;
import net.dries007.tfc.objects.items.food.ItemFoodTFC;
import net.dries007.tfc.objects.items.metal.ItemOreTFC;
import net.dries007.tfc.util.agriculture.Crop;
import net.dries007.tfc.util.agriculture.Food;
import net.minecraft.block.BlockDoublePlant.EnumPlantType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.FlowerEntry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class DryingRackRecipeHandler {
	public static final Set<DryingRackRecipe> recipes = new HashSet<DryingRackRecipe>();

	
	public static void init() {
		if(DryingRackConfig.GENERAL.seedsFromVegetables)
			for(Crop crop: Crop.values()) {
				try {
					IIngredient input = IIngredient.of(crop.getFoodDrop(crop.getMaxStage()).getItem());
					ItemStack output  = ItemSeedsTFC.get(crop, 1);
					int duration	  = 72;
					float chance      = 0.15f;
					recipes.add(new DryingRackRecipe("tfc_drying_rack:" + crop.toString() + "_seed", input, output, duration, chance));
				}catch(Exception e) {
					
				}
			}
		
		if(DryingRackConfig.GENERAL.driedFlowers) {
			IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) TFCRegistries.QUERN;
			TFCRegistries.QUERN.forEach((recipe) -> {
				IIngredient<ItemStack> input = recipe.getIngredients().get(0);
				ItemStack output = recipe.getOutputs().get(0);
				if(input.getValidIngredients().get(0).getItem().getRegistryName().toString().contains("plants/")) {
					recipes.add(new DryingRackRecipe("tfc_drying_rack:dried_pre_" + recipe.getRegistryName(), input, output, 8, 1f));
		            modRegistry.remove(recipe.getRegistryName());
				}
			});
		}
		
		if(DryingRackConfig.GENERAL.thatchFromLeaves)
			recipes.add(new DryingRackRecipe("tfc_drying_rack:thatch_from_leaves", IIngredient.of("treeLeaves"), new ItemStack(BlocksTFC.THATCH), 92, 1.0f));
		
		if(DryingRackConfig.GENERAL.saltFromSaltPeter)
			recipes.add(new DryingRackRecipe("tfc_drying_rack:salt_from_saltpeter", IIngredient.of("dustSaltpeter"), new ItemStack(ItemsTFC.SALT), 24, 1.0f));
	}
	
	public static DryingRackRecipe getRecipe(ItemStack input) {
		for(DryingRackRecipe recipe: recipes) {
			if(recipe.input.testIgnoreCount(input)) {
				return recipe;
			}
		}
		return null;
	}
	
	public static DryingRackRecipe getRecipe(IIngredient input) {
		for(DryingRackRecipe recipe: recipes) {
			if(recipe.input == input) {
				return recipe;
			}
		}
		return null;
	}
	
	public static DryingRackRecipe getRecipe(String registryName) {
		for(DryingRackRecipe recipe: recipes) {
			if(recipe.registryName == registryName) {
				return recipe;
			}
		}
		return null;
	}
	
	public static void addRecipe(DryingRackRecipe recipe) {
		recipes.add(recipe);
	}
}
