package io.github.kodiitulip.toywars.common.util;

import io.github.kodiitulip.toywars.common.util.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ToywarsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ToywarsBlockTagProvider::new);
		pack.addProvider(ToywarsItemTagProvider::new);
		pack.addProvider(ToywarsModelProvider::new);
		pack.addProvider(ToywarsRecipeProvider::new);
		pack.addProvider(ToywarsLootTableProvider::new);
	}
}
