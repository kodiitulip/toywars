package io.github.kodiitulip.toywars.datagen;

import io.github.kodiitulip.toywars.block.ToywarsBlocks;
import io.github.kodiitulip.toywars.item.ToywarsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ToywarsRecipeProvider extends FabricRecipeProvider {
	private static final List<ItemConvertible> EXAMPLE_SMELTABLES = List.of(
		ToywarsBlocks.EXAMPLE_ORE,
		ToywarsBlocks.DEEPSLATE_EXAMPLE_ORE,
		ToywarsItems.EXAMPLE_ITEM
	);

	public ToywarsRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
		offerSmelting(exporter, EXAMPLE_SMELTABLES, RecipeCategory.MISC, ToywarsItems.SECOND_ITEM,
			0.7f, 200, "example");
		offerBlasting(exporter, EXAMPLE_SMELTABLES, RecipeCategory.MISC, ToywarsItems.SECOND_ITEM,
			0.7f, 100, "example");

		offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
			ToywarsItems.SECOND_ITEM, RecipeCategory.MISC, ToywarsBlocks.SECOND_BLOCK);
		offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
			ToywarsItems.EXAMPLE_ITEM, RecipeCategory.MISC, ToywarsBlocks.EXAMPLE_BLOCK);
	}
}
