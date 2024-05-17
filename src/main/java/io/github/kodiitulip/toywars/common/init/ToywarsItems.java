package io.github.kodiitulip.toywars.common.init;

import io.github.kodiitulip.toywars.common.Toywars;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ToywarsItems {
	Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

	Item EXAMPLE_ITEM = createItem(
		"example_item",
		new Item(
			new QuiltItemSettings()
		)
	);
	Item SECOND_ITEM = createItem(
		"second_item",
		new Item(
			new QuiltItemSettings()
		)
	);

	Item LIVING_TOY_SPAWN_EGG = createItem(
		"living_toy_spawn_egg",
		new SpawnEggItem(
			ToywarsEntities.LIVINGTOY,
			0xa86518,
			0x3b260f,
			new QuiltItemSettings()
		)
	);

	private static <T extends Item> T createItem(String name, T item) {
		ITEMS.put(item, new Identifier(Toywars.MODID, name));
		return item;
	}

	static void initialize() {
		ITEMS.keySet().forEach(item -> Registry.register(Registries.ITEM, ITEMS.get(item), item));
	}
}
