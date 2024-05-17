package io.github.kodiitulip.toywars.common.util.datagen;

import io.github.kodiitulip.toywars.common.init.ToywarsBlocks;
import io.github.kodiitulip.toywars.common.init.ToywarsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ToywarsLootTableProvider extends FabricBlockLootTableProvider {
	public ToywarsLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		addDrop(ToywarsBlocks.EXAMPLE_BLOCK);
		addDropWithSilkTouch(ToywarsBlocks.SECOND_BLOCK);

		add(ToywarsBlocks.EXAMPLE_ORE,
			oreDrops(ToywarsBlocks.EXAMPLE_ORE,
				ToywarsItems.SECOND_ITEM));
		add(ToywarsBlocks.DEEPSLATE_EXAMPLE_ORE,
			oreDrops(ToywarsBlocks.DEEPSLATE_EXAMPLE_ORE,
				ToywarsItems.SECOND_ITEM));
	}
}
