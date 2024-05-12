package io.github.kodiitulip.toywars.util;

import io.github.kodiitulip.toywars.Toywars;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;

public class ToywarsTags {
	public static class Blocks {

		public static TagKey<Block> EXAMPLE_ORES = null;
		public static TagKey<Block> EXAMPLE_BLOCKS = null;

	}

	public static class Items {

		public static TagKey<Item> EXAMPLE_ITEMS = null;
		public static TagKey<Item> EXAMPLE_FOODS = null;

	}

	private static TagKey<Block> createBlockTag(String modid, String name) {
		return TagKey.of(RegistryKeys.BLOCK, new Identifier(modid, name));
	}

	private static TagKey<Item> createItemTag(String modid, String name) {
		return TagKey.of(RegistryKeys.ITEM, new Identifier(modid, name));
	}

	public static void registerTags(@NotNull ModContainer mod) {
		final String MODID = mod.metadata().id();

		Blocks.EXAMPLE_ORES = createBlockTag(MODID, "example_ores");
		Blocks.EXAMPLE_BLOCKS = createBlockTag(MODID, "example_blocks");
		Items.EXAMPLE_ITEMS = createItemTag(MODID, "example_items");
		Items.EXAMPLE_FOODS = createItemTag(MODID, "example_foods");

		Toywars.LOGGER.info("Registering Mod Tags for [{}]", mod.metadata().name());
	}
}
