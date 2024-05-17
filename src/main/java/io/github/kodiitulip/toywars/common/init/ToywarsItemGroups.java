package io.github.kodiitulip.toywars.common.init;

import io.github.kodiitulip.toywars.common.Toywars;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ToywarsItemGroups {
	Map<ItemGroup, Identifier> GROUPS = new LinkedHashMap<>();

	ItemGroup TOYWARS_ITEMS_GROUP = generateItemGroup(
		"items",
		ToywarsItems.EXAMPLE_ITEM
	);
	ItemGroup TOYWARS_BLOCKS_GROUP = generateItemGroup(
		"blocks",
		ToywarsBlocks.EXAMPLE_BLOCK
	);

	private static ItemGroup generateItemGroup(String name, ItemConvertible ditem) {
		ItemGroup group = FabricItemGroup.builder()
			.name(Text.translatable("itemgroup.toywars." + name))
			.icon(() -> new ItemStack(ditem))
			.build();
		GROUPS.put(group, new Identifier(Toywars.MODID, name));
		return group;
	}

	static void initialize() {
		GROUPS.keySet().forEach(itemGroup -> Registry.register(
			Registries.ITEM_GROUP,
			GROUPS.get(itemGroup),
			itemGroup
		));

		ItemGroupEvents.modifyEntriesEvent(
			RegistryKey.of(Registries.ITEM_GROUP.getKey(), GROUPS.get(TOYWARS_BLOCKS_GROUP)))
			.register(entries -> {
				entries.addItem(ToywarsBlocks.EXAMPLE_BLOCK);
				entries.addItem(ToywarsBlocks.EXAMPLE_ORE);
				entries.addItem(ToywarsBlocks.DEEPSLATE_EXAMPLE_ORE);
			});

		ItemGroupEvents.modifyEntriesEvent(
				RegistryKey.of(Registries.ITEM_GROUP.getKey(), GROUPS.get(TOYWARS_ITEMS_GROUP)))
			.register(entries -> {
				entries.addItem(ToywarsItems.EXAMPLE_ITEM);
				entries.addItem(ToywarsItems.SECOND_ITEM);
			});

		ItemGroupEvents.modifyEntriesEvent(
			ItemGroups.SPAWN_EGGS)
			.register(entries -> {
				entries.addItem(ToywarsItems.LIVING_TOY_SPAWN_EGG);
			});
	}
}
