package io.github.kodiitulip.toywars.item;

import io.github.kodiitulip.toywars.Toywars;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ToywarsItems {

	public static final Item EXAMPLE_ITEM = new Item(new QuiltItemSettings());
	public static final Item SECOND_ITEM = new Item(new QuiltItemSettings());

	/**
	 * Helper function to register items
	 *
	 * @param modid The Mod ID
	 * @param name The path for the item name (modid:name)
	 * @param item The Item registry
	 */
	private static void registerItem(String modid, String name, Item item) {
		Registry.register(
			Registries.ITEM,
			new Identifier(modid, name),
			item
		);
	}

	/**
	 * Helper function to add items to item groups
	 *
	 * @param item_group The ItemGroup registry
	 * @param item The Item to Add
	 */
	private static void addToItemGroup(RegistryKey<ItemGroup> item_group, Item item) {
		ItemGroupEvents.modifyEntriesEvent(item_group).register(
			entries -> entries.addItem(item)
		);
	}

	public static void registerModItems(@NotNull ModContainer mod) {
		final String MOD_ID = mod.metadata().id();

		registerItem(MOD_ID, "example_item", EXAMPLE_ITEM);
		registerItem(MOD_ID, "second_item", SECOND_ITEM);

		addToItemGroup(ItemGroups.INGREDIENTS, EXAMPLE_ITEM);
		addToItemGroup(ItemGroups.COMBAT, SECOND_ITEM);
		addToItemGroup(ItemGroups.COMBAT, SECOND_ITEM);

		Toywars.LOGGER.info("Registering Mod Items for [{}]", mod.metadata().name());
	}
}
