package io.github.kodiitulip.toywars.common;

import io.github.kodiitulip.toywars.common.init.ToywarsBlocks;
import io.github.kodiitulip.toywars.common.init.ToywarsEntities;
import io.github.kodiitulip.toywars.common.init.ToywarsItemGroups;
import io.github.kodiitulip.toywars.common.init.ToywarsItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Toywars implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Toy Wars");
	public static final String MODID = "toywars";

    @Override
    public void onInitialize(ModContainer mod) {
		// Initialization
		ToywarsEntities.initialize();
		ToywarsBlocks.initialize();
		ToywarsItems.initialize();
		ToywarsItemGroups.initialize();

        LOGGER.info("Hello from {}! Stay fresh!", mod.metadata().name());
    }
}
