package tv.trashless.tutorialmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tv.trashless.tutorialmod.block.ModBlocks;
import tv.trashless.tutorialmod.item.ModItemGroups;
import tv.trashless.tutorialmod.item.ModItems;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}