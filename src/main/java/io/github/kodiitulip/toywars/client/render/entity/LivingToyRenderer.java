package io.github.kodiitulip.toywars.client.render.entity;

import io.github.kodiitulip.toywars.common.Toywars;
import io.github.kodiitulip.toywars.common.entity.LivingToyEntity;
import io.github.kodiitulip.toywars.client.model.LivingToyModel;
import io.github.kodiitulip.toywars.client.ToywarsModelLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LivingToyRenderer extends MobEntityRenderer<LivingToyEntity, LivingToyModel<LivingToyEntity>> {
	private static final Identifier TEXTURE = new Identifier(Toywars.MODID,
		"textures/entity/living_toy.png");

	public LivingToyRenderer(EntityRendererFactory.Context context) {
		super(context, new LivingToyModel<>(context.getPart(ToywarsModelLayers.LIVING_TOY)), 0.6f);
	}

	@Override
	public Identifier getTexture(LivingToyEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(LivingToyEntity mobEntity, float f, float g,
					   MatrixStack matrixStack,
					   VertexConsumerProvider vertexConsumerProvider, int i) {

		if (mobEntity.isBaby()) {
			matrixStack.scale(0.25f,0.25f,0.25f);
		} else {
			matrixStack.scale(0.5f,0.5f,0.5f);
		}

		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}
