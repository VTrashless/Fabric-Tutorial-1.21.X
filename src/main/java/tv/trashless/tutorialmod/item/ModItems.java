package tv.trashless.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tv.trashless.tutorialmod.TutorialMod;
import tv.trashless.tutorialmod.item.functional.ChiselItem;

import java.util.List;

public class ModItems {
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    //functional items
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    //foods
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower.1"));
            tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower.2"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(RAW_PINK_GARNET);
            fabricItemGroupEntries.add(PINK_GARNET);
        });
    }
}
