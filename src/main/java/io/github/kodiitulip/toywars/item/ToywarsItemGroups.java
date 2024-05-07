package io.github.kodiitulip.toywars.item;

import io.github.kodiitulip.toywars.Toywars;
import io.github.kodiitulip.toywars.block.ToywarsBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
		ToywarsItems.SECOND_ITEM,
	};

	public static final ItemGroup TOYWARS_ITEMS_GROUP = generateItemGroup(
		"itemgroup.toywars_items",
		ToywarsItems.EXAMPLE_ITEM,
		TOYWARS_ITEM_ENTRIES
	);
	public static final ItemGroup TOYWARS_BLOCKS_GROUP = generateItemGroup(
		"itemgroup.toywars_blocks",
		ToywarsBlocks.EXAMPLE_BLOCK,
		new ItemConvertible[]{
			ToywarsBlocks.EXAMPLE_BLOCK,
			ToywarsBlocks.SECOND_BLOCK,
			ToywarsBlocks.EXAMPLE_ORE,
			ToywarsBlocks.DEEPSLATE_EXAMPLE_ORE,
		}
	);

	private static ItemGroup generateItemGroup(String name,
											   ItemConvertible ditem,
											   ItemConvertible[] items) {
		return FabricItemGroup.builder()
			.name(Text.translatable(name))
			.icon(() -> new ItemStack(ditem))
			.entries((displayParameters, itemStackCollector) -> {
				for (ItemConvertible item : items) {
					itemStackCollector.addItem(item);
				}
			}).build();
	}

	private static void registerItemGroup(String modid,
										  String name,
										  ItemGroup item_group) {
		Registry.register(
			Registries.ITEM_GROUP,
			new Identifier(modid, name),
			item_group
		);
	}

	public static void registerModItemGroups(@NotNull ModContainer mod) {
		final String MOD_ID = mod.metadata().id();

		registerItemGroup(MOD_ID, "toywars", TOYWARS_ITEMS_GROUP);
		registerItemGroup(MOD_ID, "toywars_second", TOYWARS_BLOCKS_GROUP);

		Toywars.LOGGER.info("Registering Mod ItemGrops for [{}]", mod.metadata().name());
	}
}
