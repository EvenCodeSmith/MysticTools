package net.even.mystictools;

import net.even.mystictools.block.ModBlocks;
import net.even.mystictools.item.ModItemGroups;
import net.even.mystictools.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysticTools implements ModInitializer {

	public static final String MOD_ID = "mystictools";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}