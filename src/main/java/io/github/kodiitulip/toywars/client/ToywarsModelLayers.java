package io.github.kodiitulip.toywars.client;

import io.github.kodiitulip.toywars.common.Toywars;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ToywarsModelLayers {
	public static final EntityModelLayer LIVING_TOY =
		new EntityModelLayer(new Identifier(Toywars.MODID, "living_toy"), "main");
}
