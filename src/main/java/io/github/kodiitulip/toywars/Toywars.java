package io.github.kodiitulip.toywars;

import io.github.kodiitulip.toywars.items.ToywarsItem;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Toywars implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Toy Wars");

    @Override
    public void onInitialize(ModContainer mod) {
		ToywarsItem.registerModItems(mod);

        LOGGER.info("Hello from {}! Stay fresh!", mod.metadata().name());
    }
}
