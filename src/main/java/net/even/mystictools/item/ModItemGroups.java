package net.even.mystictools.item;

import net.even.mystictools.MysticTools;
import net.even.mystictools.block.ModBlocks;
import net.even.mystictools.item.custom.MysticPickaxeItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public  static final ItemGroup MYSTICTOOLS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MysticTools.MOD_ID, "mystic_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.mystictools.mystic_items"))
                    .entries((displayContext, entries) ->
                    {
                        entries.add(ModItems.MYSTIC_PICKAXE);
                        entries.add(ModItems.AURUM_SOLARIS_HELMET);
                        entries.add(ModItems.AURUM_SOLARIS_CHESTPLATE);
                        entries.add(ModItems.AURUM_SOLARIS_LEGGINGS);
                        entries.add(ModItems.AURUM_SOLARIS_BOOTS);
                    })
                    .build());

    public  static final ItemGroup MYSTICTOOLS_TEST_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MysticTools.MOD_ID, "mystic_test_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.mystictools.mystic_test_items"))
                    .entries((displayContext, entries) ->
                    {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                    })
                    .build());

    public static void registerItemGroups()
    {
        MysticTools.LOGGER.info("Registering MysticTools Item Groups");
    }
}
