package net.even.mystictools.item;

import net.even.mystictools.MysticTools;
import net.even.mystictools.item.custom.ModArmorItem;
import net.even.mystictools.item.custom.MysticPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.even.mystictools.item.ModItemGroups;


public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));

    public static final Item MYSTIC_PICKAXE = registerItem("mystic_pickaxe",  new MysticPickaxeItem(
                    ToolMaterials.NETHERITE, new Item.Settings()));

    public static final Item AURUM_SOLARIS_HELMET = registerItem("aurum_solaris_helmet",
            new ModArmorItem(ModArmorMaterials.AURUM_SOLARIS_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item AURUM_SOLARIS_CHESTPLATE = registerItem("aurum_solaris_chestplate",
            new ArmorItem(ModArmorMaterials.AURUM_SOLARIS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item AURUM_SOLARIS_LEGGINGS = registerItem("aurum_solaris_leggings",
            new ArmorItem(ModArmorMaterials.AURUM_SOLARIS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item AURUM_SOLARIS_BOOTS = registerItem("aurum_solaris_boots",
            new ArmorItem(ModArmorMaterials.AURUM_SOLARIS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(MysticTools.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        MysticTools.LOGGER.info("Registering Mod Items for " + MysticTools.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
        });
    }


}
