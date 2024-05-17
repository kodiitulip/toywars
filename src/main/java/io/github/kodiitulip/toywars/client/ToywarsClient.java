package io.github.kodiitulip.toywars.client;

import io.github.kodiitulip.toywars.client.model.LivingToyModel;
import io.github.kodiitulip.toywars.client.render.entity.LivingToyRenderer;
import io.github.kodiitulip.toywars.common.init.ToywarsEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToywarsClient implements ClientModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("Toy Wars Client");

	@Override
	public void onInitializeClient(ModContainer mod) {

		EntityRendererRegistry.register(ToywarsEntities.LIVINGTOY,
			LivingToyRenderer::new);
		EntityModelLayerRegistry
			.registerModelLayer(ToywarsModelLayers.LIVING_TOY, LivingToyModel::getTexturedModelData);

		LOGGER.info("Hello from {}! Stay fresh!", mod.metadata().name());
	}
}
