package net.even.mystictools.datagen;

import net.even.mystictools.MysticTools;
import net.even.mystictools.block.ModBlocks;
import net.even.mystictools.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MYSTIC_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AURUM_SOLARIS_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AURUM_SOLARIS_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AURUM_SOLARIS_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AURUM_SOLARIS_BOOTS));

    }
}
