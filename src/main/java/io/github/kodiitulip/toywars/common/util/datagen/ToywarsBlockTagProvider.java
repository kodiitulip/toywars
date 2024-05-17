package io.github.kodiitulip.toywars.common.util.datagen;

import io.github.kodiitulip.toywars.common.init.ToywarsBlocks;
import io.github.kodiitulip.toywars.common.util.ToywarsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ToywarsBlockTagProvider extends FabricTagProvider.BlockTagProvider {


	public ToywarsBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider arg) {
		getOrCreateTagBuilder(ToywarsTags.Blocks.EXAMPLE_ORES)
			.add(ToywarsBlocks.EXAMPLE_ORE)
			.add(ToywarsBlocks.DEEPSLATE_EXAMPLE_ORE);

		getOrCreateTagBuilder(ToywarsTags.Blocks.EXAMPLE_BLOCKS)
			.add(ToywarsBlocks.SECOND_BLOCK)
			.add(ToywarsBlocks.EXAMPLE_BLOCK)
			.forceAddTag(ToywarsTags.Blocks.EXAMPLE_ORES);

		getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
			.forceAddTag(ToywarsTags.Blocks.EXAMPLE_BLOCKS);

		getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
			.forceAddTag(ToywarsTags.Blocks.EXAMPLE_BLOCKS);
	}
}
