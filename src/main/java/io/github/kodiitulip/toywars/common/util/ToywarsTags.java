package io.github.kodiitulip.toywars.common.util;

import io.github.kodiitulip.toywars.common.Toywars;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ToywarsTags {
	public static class Blocks {

		public static TagKey<Block> EXAMPLE_ORES = createTag("example_ores");
		public static TagKey<Block> EXAMPLE_BLOCKS = createTag("example_blocks");

		private static TagKey<Block> createTag(String name) {
			return TagKey.of(RegistryKeys.BLOCK, new Identifier(Toywars.MODID, name));
		}
	}

	public static class Items {

		public static TagKey<Item> EXAMPLE_ITEMS = null;
		public static TagKey<Item> EXAMPLE_FOODS = null;

		private static TagKey<Item> createTag(String name) {
			return TagKey.of(RegistryKeys.ITEM, new Identifier(Toywars.MODID, name));
		}
	}
}
