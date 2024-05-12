package io.github.kodiitulip.toywars.datagen;

import io.github.kodiitulip.toywars.block.ToywarsBlocks;
import io.github.kodiitulip.toywars.item.ToywarsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.ItemConvertible;

public class ToywarsLootTableProvider extends FabricBlockLootTableProvider {
	protected ToywarsLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		addDrop(ToywarsBlocks.EXAMPLE_BLOCK);
		addDropWithSilkTouch(ToywarsBlocks.SECOND_BLOCK);

		addDrop(ToywarsBlocks.EXAMPLE_ORE,
			(ItemConvertible) oreDrops(ToywarsBlocks.EXAMPLE_ORE,
				ToywarsItems.SECOND_ITEM));
		add(ToywarsBlocks.DEEPSLATE_EXAMPLE_ORE,
			oreDrops(ToywarsBlocks.DEEPSLATE_EXAMPLE_ORE,
				ToywarsItems.SECOND_ITEM));
	}
}
