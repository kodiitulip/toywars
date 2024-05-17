package io.github.kodiitulip.toywars.common.init;

import io.github.kodiitulip.toywars.common.Toywars;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.int_provider.UniformIntProvider;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ToywarsBlocks {
	Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();

	Block EXAMPLE_BLOCK = createBlock(
		"example_block",
		new Block(
			QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)
		),
		true
	);

	Block SECOND_BLOCK = createBlock(
		"second_block",
		new Block(
			QuiltBlockSettings.copyOf(Blocks.GLASS)
		),
		true
	);
	Block EXAMPLE_ORE = createBlock(
		"example_ore",
		new ExperienceDroppingBlock(
			QuiltBlockSettings.copyOf(Blocks.COAL_ORE),
			UniformIntProvider.create(2, 5)
		),
		true
	);
	Block DEEPSLATE_EXAMPLE_ORE = createBlock(
		"deepslate_example_ore",
		new ExperienceDroppingBlock(
			QuiltBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE),
			UniformIntProvider.create(2, 5)
		),
		true
	);

	private static <T extends Block> T createBlock(String name, T block) {
		return createBlock(name, block, false);
	}

	private static <T extends Block> T createBlock(
			String name, T block, boolean createItem) {
		BLOCKS.put(block, new Identifier(Toywars.MODID, name));
		if (createItem) {
			ToywarsItems.ITEMS.put(
				new BlockItem(
					block,
					new QuiltItemSettings()
				),
				BLOCKS.get(block));
		}
		return block;
	}

	static void initialize() {
		BLOCKS.keySet().forEach(block -> Registry.register(
			Registries.BLOCK, BLOCKS.get(block), block));
	}
}
