package io.github.kodiitulip.toywars.block;

import io.github.kodiitulip.toywars.Toywars;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ToywarsBlocks {

	public static final Block EXAMPLE_BLOCK = new Block(QuiltBlockSettings.copyOf(
		Blocks.IRON_BLOCK
	));
	public static final Block SECOND_BLOCK = new Block(QuiltBlockSettings.copyOf(
		Blocks.GLASS
	));

	private static void registerBlock(String modid, String name, Block block) {
		registerBlockItem(modid, name, block);
		Registry.register(
			Registries.BLOCK,
			new Identifier(modid, name),
			block
		);
	}

	private static void registerBlockItem(String modid, String name, Block block) {
		Registry.register(
			Registries.ITEM,
			new Identifier(modid, name),
			new BlockItem(block, new QuiltItemSettings())
		);
	}

	public static void registerModBlocks(@NotNull ModContainer mod) {
		final String MOD_ID = mod.metadata().id();

		registerBlock(MOD_ID, "example_block", EXAMPLE_BLOCK);
		registerBlock(MOD_ID, "second_block", SECOND_BLOCK);

		Toywars.LOGGER.info("Registering Mod Blocks for [{}]", mod.metadata().name());
	}
}
