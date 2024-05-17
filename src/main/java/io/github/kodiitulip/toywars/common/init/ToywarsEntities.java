package io.github.kodiitulip.toywars.common.init;

import io.github.kodiitulip.toywars.common.Toywars;
import io.github.kodiitulip.toywars.common.entity.LivingToyEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ToywarsEntities {
	Map<EntityType<? extends Entity>, Identifier> ENTITIES = new LinkedHashMap<>();

	EntityType<LivingToyEntity> LIVINGTOY = createEntity(
		"living_toy",
		QuiltEntityTypeBuilder
			.<LivingToyEntity>createMob()
			.entityFactory(LivingToyEntity::new)
			.spawnGroup(SpawnGroup.CREATURE)
			.defaultAttributes(LivingToyEntity.createLivingToyAttributes())
			.setDimensions(EntityDimensions.fixed(1f, 1f))
			.build()
	);

	private static <T extends EntityType<? extends Entity>> T createEntity(
			String name, T entity) {
		ENTITIES.put(entity, new Identifier(Toywars.MODID, name));
		return entity;
	}

	static void initialize() {
		ENTITIES.keySet().forEach(entityType -> Registry
			.register(
				Registries.ENTITY_TYPE,
				ENTITIES.get(entityType),
				entityType
			));
	}
}
