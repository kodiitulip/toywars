package io.github.kodiitulip.toywars.item;

import io.github.kodiitulip.toywars.Toywars;
import io.github.kodiitulip.toywars.block.ToywarsBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;

public class ToywarsItemGroups {

	private static final ItemConvertible[] TOYWARS_ITEM_ENTRIES = {
		ToywarsItems.EXAMPLE_ITEM,
		ToywarsBlocks.EXAMPLE_BLOCK,
		ToywarsBlocks.SECOND_BLOCK,
	};

	public static final ItemGroup TOYWARS_GROUP = generateItemGroup(
		"itemgroup.toywars",
		ToywarsItems.EXAMPLE_ITEM,
		TOYWARS_ITEM_ENTRIES
	);
	public static final ItemGroup TOYWARS_SEC_GROUP = generateItemGroup(
		"itemgroup.toywars_second",
		ToywarsItems.SECOND_ITEM,
		new ItemConvertible[]{
			ToywarsItems.EXAMPLE_ITEM,
			ToywarsItems.SECOND_ITEM,
		}
	);

	private static ItemGroup generateItemGroup(String name, Item display_item, ItemConvertible[] items) {
		return FabricItemGroup.builder()
			.name(Text.translatable(name))
			.icon(() -> new ItemStack(display_item))
			.entries((displayParameters, itemStackCollector) -> {
				for (ItemConvertible item : items) {
					itemStackCollector.addItem(item);
				}
			}).build();
	}

	private static void registerItemGroup(String modid, String name, ItemGroup item_group) {
		Registry.register(
			Registries.ITEM_GROUP,
			new Identifier(modid, name),
			item_group
		);
	}

	public static void registerModItemGroups(@NotNull ModContainer mod) {
		final String MOD_ID = mod.metadata().id();

		registerItemGroup(MOD_ID, "toywars", TOYWARS_GROUP);
		registerItemGroup(MOD_ID, "toywars_second", TOYWARS_SEC_GROUP);

		Toywars.LOGGER.info("Registering Mod ItemGrops for [{}]", mod.metadata().name());
	}
}
