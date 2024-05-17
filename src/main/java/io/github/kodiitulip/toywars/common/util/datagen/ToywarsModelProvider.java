package io.github.kodiitulip.toywars.common.util.datagen;

import io.github.kodiitulip.toywars.common.init.ToywarsBlocks;
import io.github.kodiitulip.toywars.common.init.ToywarsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Model;
import net.minecraft.data.client.model.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

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

		itemModelGenerator.register(ToywarsItems.LIVING_TOY_SPAWN_EGG,
			new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
	}
}
