package io.github.kodiitulip.toywars.datagen;

import io.github.kodiitulip.toywars.block.ToywarsBlocks;
import io.github.kodiitulip.toywars.item.ToywarsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Models;

public class ToywarsModelProvider extends FabricModelProvider {
	public ToywarsModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerSimpleCubeAll(ToywarsBlocks.EXAMPLE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(ToywarsBlocks.SECOND_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(ToywarsBlocks.EXAMPLE_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(ToywarsBlocks.DEEPSLATE_EXAMPLE_ORE);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ToywarsItems.EXAMPLE_ITEM, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(ToywarsItems.SECOND_ITEM, Models.SINGLE_LAYER_ITEM);
	}
}
